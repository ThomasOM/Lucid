package dev.thomazz.lucid.accessor.data.conversion.converters;

import dev.thomazz.lucid.accessor.data.WatchableObject;
import dev.thomazz.lucid.accessor.data.conversion.Converter;
import dev.thomazz.lucid.util.MinecraftReflection;
import dev.thomazz.lucid.util.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class WatchableObjectConverter extends Converter<WatchableObject> {
    private static final Class<?> WATCHABLE_OBJECT_CLASS = MinecraftReflection.getMinecraftClass(
        "network.syncher.DataWatcher$Item",
        "network.syncher.SynchedEntityData$DataItem",
        "DataWatcher$Item",
        "DataWatcher$WatchableObject"
    );

    private static final Class<?> DATA_WATCHER_OBJECT_CLASS = MinecraftReflection.getMinecraftClass(
        "network.syncher.DataWatcherObject",
        "DataWatcherObject"
    );

    private static final Class<?> DATA_WATCHER_REGISTRY_CLASS = MinecraftReflection.getMinecraftClass(
        "network.syncher.DataWatcherRegistry",
        "DataWatcherRegistry"
    );

    @Override
    public WatchableObject convertFrom(Object handle) throws Exception {
        if (WatchableObjectConverter.DATA_WATCHER_OBJECT_CLASS != null) {
            Field dataField = this.cache("data", () -> Reflections.getFieldByIndex(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS, 0));
            Field objectField = this.cache("object", () -> Reflections.getFieldByIndex(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS, 1));

            Object data = dataField.get(handle);
            Field idField = this.cache("id", () -> Reflections.getFieldByIndex(WatchableObjectConverter.DATA_WATCHER_OBJECT_CLASS, 0));
            Field serializerField = this.cache("serializer", () -> Reflections.getFieldByIndex(WatchableObjectConverter.DATA_WATCHER_OBJECT_CLASS, 1));
            Method serializerToId = this.cache("serializerToId", () -> Reflections.findMethod(WatchableObjectConverter.DATA_WATCHER_REGISTRY_CLASS,
                method -> Modifier.isStatic(method.getModifiers()),
                method -> method.getParameterTypes().length == 1,
                method -> method.getParameterTypes()[0].equals(int.class)
            ));

            Object serializer = serializerField.get(data);
            return new WatchableObject((int) serializerToId.invoke(null, serializer), (int) idField.get(data), objectField.get(handle));
        } else {
            Field typeField = this.cache("type", () -> Reflections.getFieldByIndex(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS, 0));
            Field idField = this.cache("id", () -> Reflections.getFieldByIndex(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS, 1));
            Field objectField = this.cache("object", () -> Reflections.getFieldByIndex(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS, 2));
            return new WatchableObject((int) typeField.get(handle), (int) idField.get(handle), objectField.get(handle));
        }
    }

    @Override
    public Object convertTo(WatchableObject object) throws Exception {
        Constructor<?> constructor = this.cache("init", () -> Reflections.getNoArgsConstructor(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS));
        Object handle = constructor.newInstance();

        if (WatchableObjectConverter.DATA_WATCHER_OBJECT_CLASS != null) {
            Field dataField = this.cache("data", () -> Reflections.getFieldByIndex(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS, 0));
            Field objectField = this.cache("object", () -> Reflections.getFieldByIndex(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS, 1));

            Field idField = this.cache("id", () -> Reflections.getFieldByIndex(WatchableObjectConverter.DATA_WATCHER_OBJECT_CLASS, 0));
            Field serializerField = this.cache("serializer", () -> Reflections.getFieldByIndex(WatchableObjectConverter.DATA_WATCHER_OBJECT_CLASS, 1));
            Method idToSerializer = this.cache("idToSerializer", () -> Reflections.findMethod(WatchableObjectConverter.DATA_WATCHER_REGISTRY_CLASS,
                method -> Modifier.isStatic(method.getModifiers()),
                method -> method.getParameterTypes().length == 1,
                method -> method.getParameterTypes()[0].equals(WatchableObjectConverter.DATA_WATCHER_OBJECT_CLASS)
            ));

            Object serializer = idToSerializer.invoke(null, object.getType());

            Constructor<?> dataConstructor = this.cache("initData", () -> Reflections.getNoArgsConstructor(WatchableObjectConverter.DATA_WATCHER_OBJECT_CLASS));
            Object data = dataConstructor.newInstance();
            idField.set(data, object.getId());
            serializerField.set(data, serializer);

            dataField.set(handle, data);
            objectField.set(handle, object.getValue());
        } else {
            Field typeField = this.cache("type", () -> Reflections.getFieldByIndex(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS, 0));
            Field idField = this.cache("id", () -> Reflections.getFieldByIndex(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS, 1));
            Field objectField = this.cache("object", () -> Reflections.getFieldByIndex(WatchableObjectConverter.WATCHABLE_OBJECT_CLASS, 2));

            typeField.set(handle, object.getType());
            idField.set(handle, object.getId());
            objectField.set(handle, object.getValue());
        }

        return handle;
    }
}
