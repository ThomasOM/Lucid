package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;
import java.util.Optional;
import java.util.Optional;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#BEACON}
* Some types in getters and setters may not be supported properly yet.
*/
public final class Beacon extends PacketAccessor {
    public Beacon(Object handle) {
        super(PacketType.Play.Client.BEACON, handle);
    }

    public Beacon() {
        super(PacketType.Play.Client.BEACON);
    }

    public Optional getPrimary() {
        return this.get(0);
    }

    public void setPrimary(Optional value) {
        this.set(0, value);
    }

    public Optional getSecondary() {
        return this.get(1);
    }

    public void setSecondary(Optional value) {
        this.set(1, value);
    }
}
