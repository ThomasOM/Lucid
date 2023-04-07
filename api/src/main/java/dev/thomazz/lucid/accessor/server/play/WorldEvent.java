package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#WORLD_EVENT}
* Some types in getters and setters may not be supported properly yet.
*/
public final class WorldEvent extends PacketAccessor {
    public WorldEvent(Object handle) {
        super(PacketType.Play.Server.WORLD_EVENT, handle);
    }

    public WorldEvent() {
        super(PacketType.Play.Server.WORLD_EVENT);
    }

    public int getType() {
        return this.get(0);
    }

    public void setType(int value) {
        this.set(0, value);
    }

    public Object getPos() {
        return this.get(1);
    }

    public void setPos(Object value) {
        this.set(1, value);
    }

    public int getData() {
        return this.get(2);
    }

    public void setData(int value) {
        this.set(2, value);
    }

    public boolean getGlobalEvent() {
        return this.get(3);
    }

    public void setGlobalEvent(boolean value) {
        this.set(3, value);
    }
}