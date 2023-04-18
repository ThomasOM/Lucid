package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.accessor.data.conversion.Conversions;
import dev.thomazz.lucid.packet.PacketType;
import org.bukkit.potion.PotionEffectType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#REMOVE_ENTITY_EFFECT}
* Some types in getters and setters may not be supported properly yet.
*/
public final class RemoveEntityEffect extends PacketAccessor {
    public RemoveEntityEffect(Object handle) {
        super(PacketType.Play.Server.REMOVE_ENTITY_EFFECT, handle);
    }

    public RemoveEntityEffect() {
        super(PacketType.Play.Server.REMOVE_ENTITY_EFFECT);
    }

    public int getEntityId() {
        return this.get(0);
    }

    public void setEntityId(int value) {
        this.set(0, value);
    }

    public PotionEffectType getEffect() {
        return Conversions.getConverter(PotionEffectType.class).fromHandle(this.get(1));
    }

    public void setEffect(PotionEffectType value) {
        this.set(1, Conversions.getConverter(PotionEffectType.class).toHandle(value));
    }
}
