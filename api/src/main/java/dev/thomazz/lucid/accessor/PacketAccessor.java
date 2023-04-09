package dev.thomazz.lucid.accessor;

import dev.thomazz.lucid.Lucid;
import dev.thomazz.lucid.channel.LucidChannelHandler;
import dev.thomazz.lucid.packet.PacketSource;
import dev.thomazz.lucid.packet.PacketType;
import dev.thomazz.lucid.util.PacketAccessCache;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

/**
 * Base implementation for accessing fields in packet objects.
 */
@Getter
@RequiredArgsConstructor
public class PacketAccessor {
    protected final PacketType packetType;
    protected final Object handle;

    public PacketAccessor(PacketType packetType) {
        this(packetType, packetType.createPacket());
    }

    @SuppressWarnings("unchecked")
    public <T> T get(int fieldId) {
        return (T) PacketAccessCache.get(this.handle.getClass(), this.handle, fieldId);
    }

    public <T> void set(int fieldId, T value) {
        PacketAccessCache.set(this.handle.getClass(), this.handle, fieldId, value);
    }

    @SuppressWarnings("unchecked")
    protected <T> Class<T> getType(int fieldId) {
        return (Class<T>) PacketAccessCache.type(this.handle.getClass(), fieldId);
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
