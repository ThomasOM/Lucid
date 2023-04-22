package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.AccessorCache;
import dev.thomazz.lucid.accessor.data.BlockPosition;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class BlockPositionConverter extends Converter<BlockPosition> {
    private static final Class<?> BLOCK_POSITION_CLASS = MinecraftReflection.getMinecraftClass(
        "core.BlockPosition",
        "BlockPosition"
    );

    private static final Class<?> BASE_BLOCK_POSITION_CLASS = MinecraftReflection.getMinecraftClass(
        "core.BaseBlockPosition",
        "BaseBlockPosition"
    );

    @Override
    public BlockPosition convertFrom(Object handle) throws Exception {
        Class<?> clazz = BlockPositionConverter.BASE_BLOCK_POSITION_CLASS;
        Field xField = this.cache("x", () -> Reflections.getFieldByIndex(clazz, 0));
        Field yField = this.cache("y", () -> Reflections.getFieldByIndex(clazz, 1));
        Field zField = this.cache("z", () -> Reflections.getFieldByIndex(clazz, 2));
        return new BlockPosition((int) xField.get(handle), (int) yField.get(handle), (int) zField.get(handle));
    }

    @Override
    public Object convertTo(BlockPosition pos) throws Exception {
        Class<?> clazz = BlockPositionConverter.BASE_BLOCK_POSITION_CLASS;
        Constructor<?> constructor = this.cache("init", () -> Reflections.getNoArgsConstructor(clazz));
        Object handle = constructor.newInstance();

        Field xField = this.cache("x", () -> Reflections.getFieldByIndex(clazz, 0));
        Field yField = this.cache("y", () -> Reflections.getFieldByIndex(clazz, 1));
        Field zField = this.cache("z", () -> Reflections.getFieldByIndex(clazz, 2));

        xField.set(handle, pos.getX());
        yField.set(handle, pos.getY());
        zField.set(handle, pos.getZ());
        return handle;
    }
}
