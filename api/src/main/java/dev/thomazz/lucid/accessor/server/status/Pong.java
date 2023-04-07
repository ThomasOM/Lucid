package dev.thomazz.lucid.accessor.server.status;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Status.Server#PONG}
* Some types in getters and setters may not be supported properly yet.
*/
public final class Pong extends PacketAccessor {
    public Pong(Object handle) {
        super(PacketType.Status.Server.PONG, handle);
    }

    public Pong() {
        super(PacketType.Status.Server.PONG);
    }

    public long getTime() {
        return this.get(0);
    }

    public void setTime(long value) {
        this.set(0, value);
    }
}
