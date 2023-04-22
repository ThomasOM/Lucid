package dev.thomazz.lucid.accessor.server.play;

import dev.thomazz.lucid.accessor.PacketAccessor;
import dev.thomazz.lucid.accessor.data.ChunkMap;
import dev.thomazz.lucid.accessor.data.conversion.Conversions;
import dev.thomazz.lucid.packet.PacketType;
import dev.thomazz.lucid.version.MinecraftVersion;

import java.util.BitSet;

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

    public ChunkMap getChunkMap() {
        return Conversions.getConverter(ChunkMap.class).fromHandle(this.get(2));
    }

    public void setChunkMap(ChunkMap value) {
        this.set(2, Conversions.getConverter(ChunkMap.class).toHandle(value));
    }

    public int getMask() {
        return this.get(2);
    }

    public void setMask(int value) {
        this.set(2, value);
    }

    public int getBitSet() {
        return this.get(2);
    }

    public void setBitSet(BitSet value) {
        this.set(2, value);
    }

    public byte[] getData() {
        return this.get(this.getDataFieldIndex());
    }

    public void setData(byte[] value) {
        this.set(this.getDataFieldIndex(), value);
    }

    public boolean getGroundUpContinuous() {
        return this.get(3);
    }

    public void setGroundUpContinuous(boolean value) {
        this.set(3, value);
    }

    private int getDataFieldIndex() {
        int index = 3;

        if (MinecraftVersion.current().equalsOrAbove(MinecraftVersion.V1_14)) {
            index = 4;
        } else if (MinecraftVersion.current().equalsOrAbove(MinecraftVersion.V1_15)) {
            index = 5;
        }

        return index;
    }
}
