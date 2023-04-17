package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.AccessorCache;
import dev.thomazz.lucid.accessor.data.BlockPosition;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;

public class BlockPositionConverter implements Converter<BlockPosition> {
    private static final Class<?> BLOCKPOSITION_CLASS = MinecraftReflection.getMinecraftClass(
        "core.BlockPosition",
        "BlockPosition"
    );

    @Override
    public BlockPosition fromHandle(Object handle) {
        int x = AccessorCache.get(BlockPositionConverter.BLOCKPOSITION_CLASS, handle, 0);
        int y = AccessorCache.get(BlockPositionConverter.BLOCKPOSITION_CLASS, handle, 1);
        int z = AccessorCache.get(BlockPositionConverter.BLOCKPOSITION_CLASS, handle, 2);
        return new BlockPosition(x, y, z);
    }

    @Override
    public Object toHandle(BlockPosition pos) {
        Object handle = AccessorCache.create(BlockPositionConverter.BLOCKPOSITION_CLASS);
        AccessorCache.set(BlockPositionConverter.BLOCKPOSITION_CLASS, handle, 0, pos.getX());
        AccessorCache.set(BlockPositionConverter.BLOCKPOSITION_CLASS, handle, 1, pos.getY());
        AccessorCache.set(BlockPositionConverter.BLOCKPOSITION_CLASS, handle, 2, pos.getZ());
        return handle;
    }
}
