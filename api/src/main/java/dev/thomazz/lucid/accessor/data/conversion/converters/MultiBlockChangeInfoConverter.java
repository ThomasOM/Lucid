package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.MultiBlockChangeInfo;
import dev.thomazz.lucid.accessor.data.conversion.Conversions;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.Reflections;
import org.bukkit.Material;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class MultiBlockChangeInfoConverter extends Converter<MultiBlockChangeInfo> {
    private static final Class<?> MULTI_BLOCK_CHANGE_INFO_CLASS = MinecraftReflection.getMinecraftClass(
        "PacketPlayOutMultiBlockChange$MultiBlockChangeInfo"
    );

    @Override
    public MultiBlockChangeInfo convertFrom(Object handle) throws Exception {
        Class<?> clazz = MultiBlockChangeInfoConverter.MULTI_BLOCK_CHANGE_INFO_CLASS;
        Field locationField = this.cache("location", () -> Reflections.getFieldByIndex(clazz, 0));
        Field blockDataField = this.cache("data", () -> Reflections.getFieldByIndex(clazz, 1));

        short location = (short) locationField.get(handle);
        Material material = Conversions.getConverter(Material.class).fromHandle(blockDataField.get(handle));
        return new MultiBlockChangeInfo(location, material);
    }

    @Override
    public Object convertTo(MultiBlockChangeInfo pos) throws Exception {
        Class<?> clazz = MultiBlockChangeInfoConverter.MULTI_BLOCK_CHANGE_INFO_CLASS;
        Constructor<?> constructor = this.cache("init", () -> Reflections.getNoArgsConstructor(clazz));
        Object handle = constructor.newInstance();

        Field locationField = this.cache("location", () -> Reflections.getFieldByIndex(clazz, 0));
        Field blockDataField = this.cache("data", () -> Reflections.getFieldByIndex(clazz, 1));

        locationField.set(handle, pos.getLocation());
        blockDataField.set(handle, Conversions.getConverter(Material.class).toHandle(pos.getMaterial()));
        return handle;
    }
}
