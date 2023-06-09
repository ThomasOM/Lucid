package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#OPEN_WINDOW_HORSE}
* Some types in getters and setters may not be supported properly yet.
*/
public final class OpenWindowHorse extends PacketAccessor {
    public OpenWindowHorse(Object handle) {
        super(PacketType.Play.Server.OPEN_WINDOW_HORSE, handle);
    }

    public OpenWindowHorse() {
        super(PacketType.Play.Server.OPEN_WINDOW_HORSE);
    }

    public int getContainerId() {
        return this.get(0);
    }

    public void setContainerId(int value) {
        this.set(0, value);
    }

    public int getSize() {
        return this.get(1);
    }

    public void setSize(int value) {
        this.set(1, value);
    }

    public int getEntityId() {
        return this.get(2);
    }

    public void setEntityId(int value) {
        this.set(2, value);
    }
}
