package dev.thomazz.lucid.channel;

import io.netty.channel.Channel;
import java.net.InetAddress;
import java.util.Collection;
import org.bukkit.entity.Player;

/**
 * Base interface for accessing networking {@link Channel}s for players using the API
 */
public interface ChannelAccess {
    /**
     * Gets the networking {@link Channel} for a {@link Player}
     * @param player - Player to get channel for
     * @return       - Networking channel
     */
    Channel getChannel(Player player);

    /**
     * Gets the networking {@link Channel} for a {@link InetAddress}
     * @param address - Address to get channel for
     * @return        - Networking channel
     */
    Channel getChannel(InetAddress address);

    /**
     * Gets all registered {@link Channel}s to the server connection.
     * @return - All registered channels
     */
    Collection<Channel> getAllChannels();
}
