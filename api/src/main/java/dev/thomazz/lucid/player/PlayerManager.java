package dev.thomazz.lucid.player;

import dev.thomazz.lucid.Lucid;
import dev.thomazz.lucid.channel.LucidChannelHandler;
import io.netty.channel.Channel;
import java.util.HashMap;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor
public class PlayerManager implements Listener {
    private final Map<Player, Channel> channelMap = new HashMap<>();
    private final Lucid lucid;

    @EventHandler
    public void onLogin(PlayerLoginEvent login) {
        Player player = login.getPlayer();
        Channel channel = this.getChannel(player);
        LucidChannelHandler handler = this.getHandler(channel);
        handler.player = player;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent join) {
        Channel channel = this.getChannel(join.getPlayer());
        LucidChannelHandler handler = this.getHandler(channel);
        handler.joined = true;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent quit) {
        this.channelMap.remove(quit.getPlayer());
    }

    public Channel getChannel(Player player) {
        return this.channelMap.computeIfAbsent(player, key -> this.lucid.getChannelAccess().getChannel(key));
    }

    private LucidChannelHandler getHandler(Channel channel) {
        return (LucidChannelHandler) channel.pipeline().get(LucidChannelHandler.HANDLER_NAME);
    }
}


