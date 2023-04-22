package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.ChunkCoord;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ChunkCoordConverter extends Converter<ChunkCoord> {
    private static final Class<?> CHUNK_COORD_CLASS = MinecraftReflection.getMinecraftClass(
        "ChunkCoordIntPair"
    );

    @Override
    public ChunkCoord convertFrom(Object handle) throws Exception {
        Class<?> clazz = ChunkCoordConverter.CHUNK_COORD_CLASS;
        Field xField = this.cache("x", () -> Reflections.getFieldByIndex(clazz, 0));
        Field zField = this.cache("z", () -> Reflections.getFieldByIndex(clazz, 1));
        return new ChunkCoord((int) xField.get(handle), (int) zField.get(handle));
    }

    @Override
    public Object convertTo(ChunkCoord coord) throws Exception {
        Class<?> clazz = ChunkCoordConverter.CHUNK_COORD_CLASS;
        Constructor<?> constructor = this.cache("init", () -> Reflections.getNoArgsConstructor(clazz));
        Object handle = constructor.newInstance();

        Field xField = this.cache("x", () -> Reflections.getFieldByIndex(clazz, 0));
        Field zField = this.cache("z", () -> Reflections.getFieldByIndex(clazz, 1));

        xField.set(handle, coord.getX());
        zField.set(handle, coord.getZ());
        return handle;
    }
}
