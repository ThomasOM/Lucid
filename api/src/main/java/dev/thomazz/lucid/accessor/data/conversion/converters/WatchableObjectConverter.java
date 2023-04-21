package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.WatchableObject;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;

public class WatchableObjectConverter implements Converter<WatchableObject> {
    private static final Class<?> WATCHABLE_OBJECT_CLASS = MinecraftReflection.getMinecraftClass(
        "network.syncher.DataWatcher$Item",
        "network.syncher.SynchedEntityData$DataItem",
        "DataWatcher$Item",
        "DataWatcher$WatchableObject"
    );

    @Override
    public WatchableObject fromHandle(Object handle) {
        return null;
    }

    @Override
    public Object toHandle(WatchableObject object) {
        return null;
    }
}
