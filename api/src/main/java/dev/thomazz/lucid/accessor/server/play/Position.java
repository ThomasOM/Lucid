package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.accessor.data.conversion.Conversions;
import dev.thomazz.lucid.packet.PacketType;
import java.util.Set;
import java.util.stream.Collectors;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#POSITION}
* Some types in getters and setters may not be supported properly yet.
*/
public final class Position extends PacketAccessor {
    public Position(Object handle) {
        super(PacketType.Play.Server.POSITION, handle);
    }

    public Position() {
        super(PacketType.Play.Server.POSITION);
    }

    public double getX() {
        return this.get(0);
    }

    public void setX(double value) {
        this.set(0, value);
    }

    public double getY() {
        return this.get(1);
    }

    public void setY(double value) {
        this.set(1, value);
    }

    public double getZ() {
        return this.get(2);
    }

    public void setZ(double value) {
        this.set(2, value);
    }

    public float getYRot() {
        return this.get(3);
    }

    public void setYRot(float value) {
        this.set(3, value);
    }

    public float getXRot() {
        return this.get(4);
    }

    public void setXRot(float value) {
        this.set(4, value);
    }

    public Set<TeleportFlag> getFlags() {
        return ((Set<?>) this.get(5)).stream()
            .map(flag -> Conversions.convertEnum(TeleportFlag.class, flag))
            .collect(Collectors.toSet());
    }

    public void setFlags(Set<TeleportFlag> value) {
        this.set(5, value.stream()
            .map(flag -> Conversions.convertEnum(this.type(5), flag))
            .collect(Collectors.toSet())
        );
    }

    public int getId() {
        return this.get(6);
    }

    public void setId(int value) {
        this.set(6, value);
    }

    public enum TeleportFlag {
        X,
        Y,
        Z,
        Y_ROT,
        X_ROT
    }
}
