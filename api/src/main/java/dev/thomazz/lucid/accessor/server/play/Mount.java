package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#MOUNT}
* Some types in getters and setters may not be supported properly yet.
*/
public final class Mount extends PacketAccessor {
    public Mount(Object handle) {
        super(PacketType.Play.Server.MOUNT, handle);
    }

    public Mount() {
        super(PacketType.Play.Server.MOUNT);
    }

    public int getVehicle() {
        return this.get(0);
    }

    public void setVehicle(int value) {
        this.set(0, value);
    }

    public int[] getPassengers() {
        return this.get(1);
    }

    public void setPassengers(int[] value) {
        this.set(1, value);
    }
}