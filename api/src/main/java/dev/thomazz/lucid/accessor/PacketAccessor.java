package dev.thomazz.lucid.accessor;

import dev.thomazz.lucid.Lucid;
import dev.thomazz.lucid.channel.LucidChannelHandler;
import dev.thomazz.lucid.packet.PacketSource;
import dev.thomazz.lucid.packet.PacketType;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * Base implementation for accessing fields in packet objects.
 */
@Getter
public class PacketAccessor extends Accessor {
    protected final PacketType packetType;

    public PacketAccessor(PacketType packetType) {
        this(packetType, packetType.createPacket());
    }

    public PacketAccessor(PacketType packetType, Object handle) {
        super(handle);
        this.packetType = packetType;
    }

    public void send(Player player) {
        Channel channel = Lucid.get().getPlayerManager().getChannel(player);

        // Depending on the source we fire write or read
        if (this.packetType.getSource() == PacketSource.SERVER) {
            channel.writeAndFlush(this.handle);
        } else {
            ChannelHandlerContext context = channel.pipeline().context(LucidChannelHandler.HANDLER_NAME);
            context.fireChannelRead(this.handle);
        }
    }
}
