package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#SERVER_DIFFICULTY}
* Some types in getters and setters may not be supported properly yet.
*/
public final class ServerDifficulty extends PacketAccessor {
    public ServerDifficulty(Object handle) {
        super(PacketType.Play.Server.SERVER_DIFFICULTY, handle);
    }

    public ServerDifficulty() {
        super(PacketType.Play.Server.SERVER_DIFFICULTY);
    }

    public Object getDifficulty() {
        return this.get(0);
    }

    public void setDifficulty(Object value) {
        this.set(0, value);
    }

    public boolean getLocked() {
        return this.get(1);
    }

    public void setLocked(boolean value) {
        this.set(1, value);
    }
}
