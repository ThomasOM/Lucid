package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#ENTITY_VELOCITY}
* Some types in getters and setters may not be supported properly yet.
*/
public final class EntityVelocity extends PacketAccessor {
    public EntityVelocity(Object handle) {
        super(PacketType.Play.Server.ENTITY_VELOCITY, handle);
    }

    public EntityVelocity() {
        super(PacketType.Play.Server.ENTITY_VELOCITY);
    }

    public int getId() {
        return this.get(0);
    }

    public void setId(int value) {
        this.set(0, value);
    }

    public int getXa() {
        return this.get(1);
    }

    public void setXa(int value) {
        this.set(1, value);
    }

    public int getYa() {
        return this.get(2);
    }

    public void setYa(int value) {
        this.set(2, value);
    }

    public int getZa() {
        return this.get(3);
    }

    public void setZa(int value) {
        this.set(3, value);
    }
}
