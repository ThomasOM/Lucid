package dev.thomazz.lucid.event;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

/**
 * Parent event for all packet channel events.
 */
@Getter
@Setter
public abstract class PacketEvent extends Event implements Cancellable {
    private final Player player;
    private final PacketAccessor accessor;
    private final PacketType type;

    private boolean cancelled = false;

    public PacketEvent(Player player, PacketAccessor accessor) {
        super(true);
        this.player = player;
        this.accessor = accessor;
        this.type = accessor.getPacketType();
    }

    @SuppressWarnings("unchecked")
    public <T extends PacketAccessor> T getAccessor() {
        return (T) this.accessor;
    }
}
