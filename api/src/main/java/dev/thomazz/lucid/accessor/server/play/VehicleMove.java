package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#VEHICLE_MOVE}
* Some types in getters and setters may not be supported properly yet.
*/
public final class VehicleMove extends PacketAccessor {
    public VehicleMove(Object handle) {
        super(PacketType.Play.Server.VEHICLE_MOVE, handle);
    }

    public VehicleMove() {
        super(PacketType.Play.Server.VEHICLE_MOVE);
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
}
