package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.accessor.data.BlockPosition;
import dev.thomazz.lucid.accessor.data.conversion.Conversions;
import dev.thomazz.lucid.packet.PacketType;
import org.bukkit.Material;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#BLOCK_CHANGE}
* Some types in getters and setters may not be supported properly yet.
*/
public final class BlockChange extends PacketAccessor {
    public BlockChange(Object handle) {
        super(PacketType.Play.Server.BLOCK_CHANGE, handle);
    }

    public BlockChange() {
        super(PacketType.Play.Server.BLOCK_CHANGE);
    }

    public BlockPosition getPos() {
        return Conversions.getConverter(BlockPosition.class).fromHandle(this.get(0));
    }

    public void setPos(BlockPosition value) {
        this.set(0, Conversions.getConverter(BlockPosition.class).toHandle(value));
    }

    public Material getMaterial() {
        return Conversions.getConverter(Material.class).fromHandle(this.get(1));
    }

    public void setMaterial(Material value) {
        this.set(1, Conversions.getConverter(Material.class).toHandle(value));
    }
}
