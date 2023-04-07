package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#UPDATE_TIME}
* Some types in getters and setters may not be supported properly yet.
*/
public final class UpdateTime extends PacketAccessor {
    public UpdateTime(Object handle) {
        super(PacketType.Play.Server.UPDATE_TIME, handle);
    }

    public UpdateTime() {
        super(PacketType.Play.Server.UPDATE_TIME);
    }

    public long getGameTime() {
        return this.get(0);
    }

    public void setGameTime(long value) {
        this.set(0, value);
    }

    public long getDayTime() {
        return this.get(1);
    }

    public void setDayTime(long value) {
        this.set(1, value);
    }
}
