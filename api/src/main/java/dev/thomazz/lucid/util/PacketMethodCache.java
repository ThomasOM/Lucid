package dev.thomazz.lucid.util;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import lombok.experimental.UtilityClass;
import sun.reflect.ReflectionFactory;

@UtilityClass
public class PacketMethodCache {
    private final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();
    private final Constructor<?> DEFAULT_CONSTRUCTOR;

    private final Map<Class<?>, MethodContainer> TYPE_CONTAINERS = new IdentityHashMap<>();
    private final Map<Class<?>, Constructor<?>> TYPE_CONSTRUCTORS = new IdentityHashMap<>();

    static {
        try {
            DEFAULT_CONSTRUCTOR = Object.class.getDeclaredConstructor();
        } catch (Exception ex) {
            throw new RuntimeException("Could not set up packet method cache", ex);
        }
    }

    public Object get(Class<?> type, Object object, int id) {
        try {
            MethodContainer container = TYPE_CONTAINERS.computeIfAbsent(type, key -> new MethodContainer());
            MethodHandle handle = container.getGetter(id);
            if (handle != null) {
                return handle.invoke(object);
            }

            List<Field> fields = PacketMethodCache.getFields(type);
            Field field = fields.get(id);
            field.setAccessible(true);

            handle = LOOKUP.unreflectGetter(field);
            container.addGetter(id, handle);
            return handle.invoke(object);
        } catch (Throwable ignored) {
            return null;
        }
    }

    public void set(Class<?> type, Object object, int id, Object value) {
        try {
            MethodContainer container = TYPE_CONTAINERS.computeIfAbsent(type, key -> new MethodContainer());
            MethodHandle handle = container.getSetter(id);
            if (handle != null) {
                handle.invoke(object, value);
            }

            List<Field> fields = PacketMethodCache.getFields(type);
            Field field = fields.get(id);
            field.setAccessible(true);

            handle = LOOKUP.unreflectSetter(field);
            container.addSetter(id, handle);
            handle.invoke(object, value);
        } catch (Throwable ignored) {
        }
    }

    public <T> T create(Class<T> clazz) throws Exception {
        Constructor<?> noArgs = TYPE_CONSTRUCTORS.computeIfAbsent(clazz,
                type -> ReflectionFactory.getReflectionFactory()
                        .newConstructorForSerialization(clazz, DEFAULT_CONSTRUCTOR)
        );

        return clazz.cast(noArgs.newInstance());
    }

    private List<Field> getFields(Class<?> clazz) {
        List<Field> declared = new ArrayList<>();

        Class<?> scan = clazz;
        while (scan != null && !Object.class.equals(scan)) {
            declared.addAll(Arrays.asList(scan.getDeclaredFields()));
            scan = scan.getSuperclass();
        }

        return declared;
    }

    private static class MethodContainer {
        private MethodHandle[] getHandles = new MethodHandle[0];
        private MethodHandle[] setHandles = new MethodHandle[0];

        private MethodHandle getGetter(int id) {
            int length = id + 1;
            if (length > this.getHandles.length) {
                return null;
            }
            return this.getHandles[id];
        }

        private void addGetter(int id, MethodHandle handle) {
            int length = id + 1;
            if (length > this.getHandles.length) {
                this.getHandles = new MethodHandle[length];
            }
            this.getHandles[id] = handle;
        }

        private MethodHandle getSetter(int id) {
            int length = id + 1;
            if (length > this.setHandles.length) {
                return null;
            }
            return this.setHandles[id];
        }

        private void addSetter(int id, MethodHandle handle) {
            int length = id + 1;
            if (length > this.setHandles.length) {
                this.setHandles = new MethodHandle[length];
            }
            this.setHandles[id] = handle;
        }
    }
}
