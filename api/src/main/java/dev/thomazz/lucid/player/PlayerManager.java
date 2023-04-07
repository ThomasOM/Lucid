package dev.thomazz.lucid.player;

import dev.thomazz.lucid.Lucid;
import dev.thomazz.lucid.channel.LucidChannelHandler;
import io.netty.channel.Channel;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerManager implements Listener {
    private final Map<Player, Channel> channelMap = new HashMap<>();

    @EventHandler
    public void onLogin(PlayerLoginEvent login) {
        Lucid lucid = Lucid.get();
        Player player = login.getPlayer();
        InetAddress address = login.getAddress();

        Channel channel = this.channelMap.compute(player, (key, value) -> lucid.getChannelAccess().getChannel(address));
        LucidChannelHandler handler = getHandler(channel);
        handler.player = player;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent join) {
        Lucid lucid = Lucid.get();
        Player player = join.getPlayer();
        Channel channel = this.channelMap.computeIfAbsent(player, key -> lucid.getChannelAccess().getChannel(key));

        LucidChannelHandler handler = getHandler(channel);
        handler.player = player;
        handler.joined = true;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent quit) {
        this.channelMap.remove(quit.getPlayer());
    }

    public Channel getChannel(Player player) {
        return this.channelMap.get(player);
    }

    private LucidChannelHandler getHandler(Channel channel) {
        return (LucidChannelHandler) channel.pipeline().get(LucidChannelHandler.HANDLER_NAME);
    }
}


