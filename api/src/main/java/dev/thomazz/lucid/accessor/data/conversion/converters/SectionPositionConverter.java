package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.AccessorCache;
import dev.thomazz.lucid.accessor.data.SectionPosition;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;

public class SectionPositionConverter implements Converter<SectionPosition> {
    private static final Class<?> SECTIONPOSITION_CLASS = MinecraftReflection.getMinecraftClass(
        "core.SectionPosition",
        "SectionPosition"
    );

    @Override
    public SectionPosition fromHandle(Object handle) {
        int x = AccessorCache.get(SectionPositionConverter.SECTIONPOSITION_CLASS, handle, 0);
        int y = AccessorCache.get(SectionPositionConverter.SECTIONPOSITION_CLASS, handle, 1);
        int z = AccessorCache.get(SectionPositionConverter.SECTIONPOSITION_CLASS, handle, 2);
        return new SectionPosition(x, y, z);
    }

    @Override
    public Object toHandle(SectionPosition pos) {
        Object handle = AccessorCache.create(SectionPositionConverter.SECTIONPOSITION_CLASS);
        AccessorCache.set(SectionPositionConverter.SECTIONPOSITION_CLASS, handle, 0, pos.getX());
        AccessorCache.set(SectionPositionConverter.SECTIONPOSITION_CLASS, handle, 1, pos.getY());
        AccessorCache.set(SectionPositionConverter.SECTIONPOSITION_CLASS, handle, 2, pos.getZ());
        return handle;
    }
}
