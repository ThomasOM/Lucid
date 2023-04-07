package dev.thomazz.lucid.event;

import dev.thomazz.lucid.accessor.PacketAccessor;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * Called every time a packet is sent by the server to the client.
 * Note: This event is called from netty threads!
 */
@Getter
public class PacketSendEvent extends PacketEvent {
    private static final HandlerList handlers = new HandlerList();

    public PacketSendEvent(Player player, PacketAccessor accessor) {
        super(player, accessor);
    }

    public HandlerList getHandlers() {
        return PacketSendEvent.handlers;
    }

    public static HandlerList getHandlerList() {
        return PacketSendEvent.handlers;
    }
}
