package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.packet.PacketType;

@Deprecated
public final class MapChunkBulk extends PacketAccessor {
    public MapChunkBulk(Object handle) {
        super(PacketType.Play.Server.MAP_CHUNK_BULK, handle);
    }

    public MapChunkBulk() {
        super(PacketType.Play.Server.MAP_CHUNK_BULK);
    }

    public int[] getBulkX() {
        return this.get(0);
    }

    public void setBulkX(int[] value) {
        this.set(0, value);
    }

    public int[] getBulkZ() {
        return this.get(1);
    }

    public void setBulkZ(int[] value) {
        this.set(1, value);
    }

    public Object[] getChunkMaps() {
        return this.get(2);
    }

    public void setChunkMaps(Object[] value) {
        this.set(2, value);
    }

    public boolean getSkyLightSent() {
        return this.get(3);
    }

    public void setSkyLightSent(boolean value) {
        this.set(3, value);
    }
}