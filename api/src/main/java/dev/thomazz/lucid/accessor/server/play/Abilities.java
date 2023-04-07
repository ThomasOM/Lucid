package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#ABILITIES}
* Some types in getters and setters may not be supported properly yet.
*/
public final class Abilities extends PacketAccessor {
    public Abilities(Object handle) {
        super(PacketType.Play.Server.ABILITIES, handle);
    }

    public Abilities() {
        super(PacketType.Play.Server.ABILITIES);
    }

    public boolean getInvulnerable() {
        return this.get(4);
    }

    public void setInvulnerable(boolean value) {
        this.set(4, value);
    }

    public boolean getIsFlying() {
        return this.get(5);
    }

    public void setIsFlying(boolean value) {
        this.set(5, value);
    }

    public boolean getCanFly() {
        return this.get(6);
    }

    public void setCanFly(boolean value) {
        this.set(6, value);
    }

    public boolean getInstabuild() {
        return this.get(7);
    }

    public void setInstabuild(boolean value) {
        this.set(7, value);
    }

    public float getFlyingSpeed() {
        return this.get(8);
    }

    public void setFlyingSpeed(float value) {
        this.set(8, value);
    }

    public float getWalkingSpeed() {
        return this.get(9);
    }

    public void setWalkingSpeed(float value) {
        this.set(9, value);
    }
}