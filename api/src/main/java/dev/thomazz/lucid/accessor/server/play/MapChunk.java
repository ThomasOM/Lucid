package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

@Deprecated
public final class MapChunk extends PacketAccessor {
    public MapChunk(Object handle) {
        super(PacketType.Play.Server.MAP_CHUNK, handle);
    }

    public MapChunk() {
        super(PacketType.Play.Server.MAP_CHUNK);
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

    public Object getChunkMap() {
        return this.get(2);
    }

    public void setChunkMap(Object value) {
        this.set(2, value);
    }

    public boolean getGroundUpContinuous() {
        return this.get(3);
    }

    public void setGroundUpContinuous(boolean value) {
        this.set(3, value);
    }
}
