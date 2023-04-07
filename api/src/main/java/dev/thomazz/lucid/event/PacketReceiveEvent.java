package dev.thomazz.lucid.event;

import dev.thomazz.lucid.accessor.PacketAccessor;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/**
 * Called every time a packet is received by the server from the client.
 * Note: This event is called from netty threads!
 */
@Getter
public class PacketReceiveEvent extends PacketEvent {
    private static final HandlerList handlers = new HandlerList();

    public PacketReceiveEvent(Player player, PacketAccessor accessor) {
        super(player, accessor);
    }

    public HandlerList getHandlers() {
        return PacketReceiveEvent.handlers;
    }

    public static HandlerList getHandlerList() {
        return PacketReceiveEvent.handlers;
    }
}
