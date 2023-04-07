package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

/**
* Accessor class generated by script for packet type {@link PacketType.Play.Server#LEVEL_CHUNK_WITH_LIGHT}
* Some types in getters and setters may not be supported properly yet.
*/
public final class LevelChunkWithLight extends PacketAccessor {
    public LevelChunkWithLight(Object handle) {
        super(PacketType.Play.Server.LEVEL_CHUNK_WITH_LIGHT, handle);
    }

    public LevelChunkWithLight() {
        super(PacketType.Play.Server.LEVEL_CHUNK_WITH_LIGHT);
    }

    public int getX() {
        return this.get(0);
    }

    public void setX(int value) {
        this.set(0, value);
    }

    public int getZ() {
        return this.get(1);
    }

    public void setZ(int value) {
        this.set(1, value);
    }

    public Object getChunkData() {
        return this.get(2);
    }

    public void setChunkData(Object value) {
        this.set(2, value);
    }

    public Object getLightData() {
        return this.get(3);
    }

    public void setLightData(Object value) {
        this.set(3, value);
    }
}