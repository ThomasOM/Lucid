package dev.thomazz.lucid.accessor.client.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Client#BOAT_MOVE}
* Some types in getters and setters may not be supported properly yet.
*/
public final class BoatMove extends PacketAccessor {
    public BoatMove(Object handle) {
        super(PacketType.Play.Client.BOAT_MOVE, handle);
    }

    public BoatMove() {
        super(PacketType.Play.Client.BOAT_MOVE);
    }

    public boolean getLeft() {
        return this.get(0);
    }

    public void setLeft(boolean value) {
        this.set(0, value);
    }

    public boolean getRight() {
        return this.get(1);
    }

    public void setRight(boolean value) {
        this.set(1, value);
    }
}
