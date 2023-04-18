package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.AccessorCache;
import dev.thomazz.lucid.accessor.data.ChunkCoord;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;

public class ChunkCoordConverter implements Converter<ChunkCoord> {
    private static final Class<?> CHUNKCOORD_CLASS = MinecraftReflection.getMinecraftClass(
        "ChunkCoordIntPair"
    );

    @Override
    public ChunkCoord fromHandle(Object handle) {
        int x = AccessorCache.get(ChunkCoordConverter.CHUNKCOORD_CLASS, handle, 0);
        int z = AccessorCache.get(ChunkCoordConverter.CHUNKCOORD_CLASS, handle, 1);
        return new ChunkCoord(x, z);
    }

    @Override
    public Object toHandle(ChunkCoord coord) {
        Object handle = AccessorCache.create(ChunkCoordConverter.CHUNKCOORD_CLASS);
        AccessorCache.set(ChunkCoordConverter.CHUNKCOORD_CLASS, handle, 0, coord.getX());
        AccessorCache.set(ChunkCoordConverter.CHUNKCOORD_CLASS, handle, 1, coord.getZ());
        return handle;
    }
}
