package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.ChunkMap;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ChunkMapConverter extends Converter<ChunkMap> {
    private static final Class<?> CHUNK_MAP_CLASS = MinecraftReflection.getMinecraftClass(
        "PacketPlayOutMapChunk$ChunkMap"
    );

    @Override
    protected ChunkMap convertFrom(Object handle) throws Exception {
        Class<?> clazz = ChunkMapConverter.CHUNK_MAP_CLASS;
        Field dataField = this.cache("data", () -> Reflections.getFieldByIndex(clazz, 0));
        Field maskField = this.cache("mask", () -> Reflections.getFieldByIndex(clazz, 1));
        return new ChunkMap((byte[]) dataField.get(handle), (int) maskField.get(dataField));
    }

    @Override
    protected Object convertTo(ChunkMap object) throws Exception {
        Class<?> clazz = ChunkMapConverter.CHUNK_MAP_CLASS;
        Constructor<?> constructor = this.cache("init", () -> Reflections.getNoArgsConstructor(clazz));
        Object handle = constructor.newInstance();

        Field dataField = this.cache("data", () -> Reflections.getFieldByIndex(clazz, 0));
        Field maskField = this.cache("mask", () -> Reflections.getFieldByIndex(clazz, 1));

        dataField.set(handle, object.getData());
        maskField.set(handle, object.getMask());

        return handle;
    }
}
