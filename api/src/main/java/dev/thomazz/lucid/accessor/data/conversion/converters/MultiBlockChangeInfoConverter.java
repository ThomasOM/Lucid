package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.AccessorCache;
import dev.thomazz.lucid.accessor.data.MultiBlockChangeInfo;
import dev.thomazz.lucid.accessor.data.conversion.Conversions;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import org.bukkit.block.data.BlockData;

public class MultiBlockChangeInfoConverter implements Converter<MultiBlockChangeInfo> {
    private static final Class<?> MULTI_BLOCK_CHANGE_INFO_CLASS = MinecraftReflection.getMinecraftClass(
        "PacketPlayOutMultiBlockChange$MultiBlockChangeInfo"
    );

    @Override
    public MultiBlockChangeInfo fromHandle(Object handle) {
        short location = AccessorCache.get(MultiBlockChangeInfoConverter.MULTI_BLOCK_CHANGE_INFO_CLASS, handle, 0);
        BlockData data = Conversions.getConverter(BlockData.class)
            .fromHandle(AccessorCache.get(MultiBlockChangeInfoConverter.MULTI_BLOCK_CHANGE_INFO_CLASS, handle, 1));
        return new MultiBlockChangeInfo(location, data);
    }

    @Override
    public Object toHandle(MultiBlockChangeInfo pos) {
        Object handle = AccessorCache.create(MultiBlockChangeInfoConverter.MULTI_BLOCK_CHANGE_INFO_CLASS);
        AccessorCache.set(MultiBlockChangeInfoConverter.MULTI_BLOCK_CHANGE_INFO_CLASS, handle, 0, pos.getLocation());
        Object blockDataHandle = Conversions.getConverter(BlockData.class).toHandle(pos.getBlockData());
        AccessorCache.set(MultiBlockChangeInfoConverter.MULTI_BLOCK_CHANGE_INFO_CLASS, handle, 1, blockDataHandle);
        return handle;
    }
}
