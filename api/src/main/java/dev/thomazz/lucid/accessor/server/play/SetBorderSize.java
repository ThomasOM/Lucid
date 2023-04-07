package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#SET_BORDER_SIZE}
* Some types in getters and setters may not be supported properly yet.
*/
public final class SetBorderSize extends PacketAccessor {
    public SetBorderSize(Object handle) {
        super(PacketType.Play.Server.SET_BORDER_SIZE, handle);
    }

    public SetBorderSize() {
        super(PacketType.Play.Server.SET_BORDER_SIZE);
    }

    public double getSize() {
        return this.get(0);
    }

    public void setSize(double value) {
        this.set(0, value);
    }
}
