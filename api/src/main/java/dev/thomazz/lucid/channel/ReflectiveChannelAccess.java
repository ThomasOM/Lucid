package dev.thomazz.lucid.channel;

import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.ReflectionUtil;
import io.netty.channel.Channel;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.bukkit.entity.Player;

@SuppressWarnings("unchecked")
public final class ReflectiveChannelAccess implements ChannelAccess {
    private static final Class<?> NETWORK_MANAGER_CLASS = MinecraftReflection.getMinecraftClass(
        "network.NetworkManager",
        "NetworkManager"
    );

    private static final Class<?> PACKET_LISTENER_CLASS = MinecraftReflection.getMinecraftClass(
        "network.PacketListener",
        "PacketListener"
    );

    @Override
    public Channel getChannel(Player player) {
        try {
            UUID playerId = player.getUniqueId();
            Object handle = player.getClass().getDeclaredMethod("getHandle").invoke(player);

            List<Object> networkManagers = this.getNetworkManagers();

            Field channelField = ReflectionUtil.getFieldByType(ReflectiveChannelAccess.NETWORK_MANAGER_CLASS, Channel.class);
            Field listenerField = ReflectionUtil.getFieldByType(ReflectiveChannelAccess.NETWORK_MANAGER_CLASS,
                ReflectiveChannelAccess.PACKET_LISTENER_CLASS);

            for (Object networkManager : networkManagers) {
                Object packetListener = listenerField.get(networkManager);
                if (packetListener != null) {
                    if (packetListener.getClass().getSimpleName().equals("LoginListener")) {
                        // We can use the game profile to look up the player id in the listener
                        Field profileField = ReflectionUtil.getFieldByClassNames(packetListener.getClass(), "GameProfile");
                        Object gameProfile = profileField.get(packetListener);

                        Field uuidField = ReflectionUtil.getFieldByType(gameProfile.getClass(), UUID.class);
                        UUID foundId = (UUID) uuidField.get(gameProfile);
                        if (playerId.equals(foundId)) {
                            return (Channel) channelField.get(networkManager);
                        }
                    } else {
                        // For player connection listeners we can get the player handle
                        Field playerField = ReflectionUtil.getFieldByClassNames(packetListener.getClass(), "EntityPlayer");
                        Object entityPlayer = playerField.get(packetListener);
                        if (handle.equals(entityPlayer)) {
                            return (Channel) channelField.get(networkManager);
                        }
                    }
                }
            }

            throw new NoSuchElementException("Did not find player channel!");
        } catch (Exception ex) {
            throw new RuntimeException("Could not get channel for player: " + player.getName(), ex);
        }
    }

    @Override
    public Channel getChannel(InetAddress address) {
        return this.getAllChannels().stream()
            .filter(channel -> ((InetSocketAddress) channel.remoteAddress()).getAddress().equals(address))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No channel linked to address: " + address));
    }

    @Override
    public Collection<Channel> getAllChannels() {
        try {
            List<Object> networkManagers = this.getNetworkManagers();
            Field channelField = ReflectionUtil.getFieldByType(ReflectiveChannelAccess.NETWORK_MANAGER_CLASS, Channel.class);

            List<Channel> channels = new ArrayList<>();
            for (Object o : Collections.synchronizedList(networkManagers)) {
                Channel channel = (Channel) channelField.get(o);
                channels.add(channel);
            }

            return channels;
        } catch (Exception ex) {
            throw new RuntimeException("Cannot access server channels", ex);
        }
    }

    private List<Object> getNetworkManagers() {
        try {
            Object serverConnection = MinecraftReflection.getServerConnection();
            for (Field field : serverConnection.getClass().getDeclaredFields()) {
                if (!List.class.isAssignableFrom(field.getType()) || !field.getGenericType().getTypeName().contains("NetworkManager")) {
                    continue;
                }

                field.setAccessible(true);

                List<Object> networkManagers = (List<Object>) field.get(serverConnection);
                return Collections.synchronizedList(networkManagers);
            }

            throw new NoSuchElementException("Did not find correct list in server connection");
        } catch (Exception ex) {
            throw new RuntimeException("Cannot retrieve network managers", ex);
        }
    }
}
