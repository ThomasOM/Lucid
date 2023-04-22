package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.LevelChunkPacketData;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class LevelChunkPacketDataConverter extends Converter<LevelChunkPacketData> {
    private static final Class<?> CLIENTBOUND_LEVEL_CHUNK_PACKET_DATA_CLASS = MinecraftReflection.getMinecraftClass(
        "network.protocol.game.ClientboundLevelChunkPacketData"
    );

    @Override
    protected LevelChunkPacketData convertFrom(Object handle) throws Exception {
        Field dataField = this.cache("data", () -> Reflections.findField(
            LevelChunkPacketDataConverter.CLIENTBOUND_LEVEL_CHUNK_PACKET_DATA_CLASS,
            field -> byte[].class.equals(field.getType())
        ));

        return new LevelChunkPacketData((byte[]) dataField.get(handle));
    }

    @Override
    protected Object convertTo(LevelChunkPacketData object) throws Exception {
        Class<?> clazz = LevelChunkPacketDataConverter.CLIENTBOUND_LEVEL_CHUNK_PACKET_DATA_CLASS;
        Constructor<?> constructor = this.cache("init", () -> Reflections.getNoArgsConstructor(clazz));
        Object handle = constructor.newInstance();

        Field dataField = this.cache("data", () -> Reflections.findField(clazz,
            field -> byte[].class.equals(field.getType())
        ));

        dataField.set(handle, object.getData());
        return handle;
    }
}
