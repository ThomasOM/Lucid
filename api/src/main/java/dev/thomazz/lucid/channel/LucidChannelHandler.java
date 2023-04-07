package dev.thomazz.lucid.channel;

import dev.thomazz.lucid.accessor.PacketAccessorRegistry;
import dev.thomazz.lucid.event.PacketReceiveEvent;
import dev.thomazz.lucid.event.PacketSendEvent;
import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LucidChannelHandler extends ChannelDuplexHandler {
    public static final String HANDLER_NAME = "mini-packet-handler";
    public volatile Player player;
    public volatile boolean joined;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        PacketType type = PacketType.fromClass(msg.getClass());
        PacketAccessor accessor = PacketAccessorRegistry.createAccessor(type, msg);

        PacketReceiveEvent event = new PacketReceiveEvent(this.player, accessor);
        Bukkit.getPluginManager().callEvent(event);

        if (!event.isCancelled()) {
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        PacketType type = PacketType.fromClass(msg.getClass());
        PacketAccessor accessor = PacketAccessorRegistry.createAccessor(type, msg);

        PacketSendEvent event = new PacketSendEvent(this.player, accessor);
        Bukkit.getPluginManager(). callEvent(event);

        if (!event.isCancelled()) {
            super.write(ctx, msg, promise);
        }
    }
}
