package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#USE_ENTITY}
* Some types in getters and setters may not be supported properly yet.
*/
public final class UseEntity extends PacketAccessor {
    public UseEntity(Object handle) {
        super(PacketType.Play.Client.USE_ENTITY, handle);
    }

    public UseEntity() {
        super(PacketType.Play.Client.USE_ENTITY);
    }

    public int getEntityId() {
        return this.get(0);
    }

    public void setEntityId(int value) {
        this.set(0, value);
    }

    public EntityUseAction getAction() {
        int ordinal = ((Enum<?>) this.get(1)).ordinal();
        return EntityUseAction.values()[ordinal];
    }

    public void setAction(EntityUseAction value) {
        Class<?> enumClass = this.getType(1);
        Object object = enumClass.getEnumConstants()[value.ordinal()];
        this.set(1, object);
    }

    public boolean getUsingSecondaryAction() {
        return this.get(2);
    }

    public void setUsingSecondaryAction(boolean value) {
        this.set(2, value);
    }

    public enum EntityUseAction {
        INTERACT,
        ATTACK,
        INTERACT_AT
    }
}
