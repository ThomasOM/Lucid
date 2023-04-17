package dev.thomazz.lucid.accessor;

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
public class AccessorCache {
    private final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();
    private final Constructor<?> DEFAULT_CONSTRUCTOR;

    private final Map<Class<?>, CacheContainer> TYPE_CONTAINERS = new IdentityHashMap<>();
    private final Map<Class<?>, Constructor<?>> TYPE_CONSTRUCTORS = new IdentityHashMap<>();

    static {
        try {
            DEFAULT_CONSTRUCTOR = Object.class.getDeclaredConstructor();
        } catch (Exception ex) {
            throw new RuntimeException("Could not set up packet method cache", ex);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Class<?> type, Object object, int id) {
        try {
            CacheContainer container = TYPE_CONTAINERS.computeIfAbsent(type, CacheContainer::new);
            MethodHandle handle = container.getGetter(id);
            return (T) handle.invoke(object);
        } catch (Throwable ignored) {
            return null;
        }
    }

    public void set(Class<?> type, Object object, int id, Object value) {
        try {
            CacheContainer container = TYPE_CONTAINERS.computeIfAbsent(type, CacheContainer::new);
            MethodHandle handle = container.getSetter(id);
            handle.invoke(object, value);
        } catch (Throwable ignored) {
        }
    }

    @SuppressWarnings("unchecked")
    public <T> Class<T> type(Class<?> type, int id) {
        try {
            CacheContainer container = TYPE_CONTAINERS.computeIfAbsent(type, CacheContainer::new);
            Field field = container.getField(id);
            return (Class<T>) field.getType();
        } catch (Throwable ignored) {
            return null;
        }
    }

    public <T> T create(Class<T> clazz) {
        try {
            Constructor<?> noArgs = TYPE_CONSTRUCTORS.computeIfAbsent(clazz,
                type -> ReflectionFactory.getReflectionFactory()
                    .newConstructorForSerialization(clazz, DEFAULT_CONSTRUCTOR)
            );

            return clazz.cast(noArgs.newInstance());
        } catch (Exception ex) {
            throw new RuntimeException("Failed to create object: " + clazz.getName(), ex);
        }
    }

    private static class CacheContainer {
        private final MethodHandle[] getHandles;
        private final MethodHandle[] setHandles;
        private final Field[] fields;

        public CacheContainer(Class<?> type) {
            List<Field> fields = this.scanFields(type);
            this.getHandles = new MethodHandle[fields.size()];
            this.setHandles = new MethodHandle[fields.size()];
            this.fields = fields.toArray(new Field[]{});
        }

        private MethodHandle getGetter(int id) throws Exception {
            MethodHandle handle = this.getHandles[id];
            if (handle == null) {
                Field field = this.fields[id];
                field.setAccessible(true);
                handle = LOOKUP.unreflectGetter(field);
                this.getHandles[id] = handle;
            }

            return handle;
        }

        private MethodHandle getSetter(int id) throws Exception {
            MethodHandle handle = this.setHandles[id];
            if (handle == null) {
                Field field = this.fields[id];
                field.setAccessible(true);
                handle = LOOKUP.unreflectSetter(field);
                this.setHandles[id] = handle;
            }

            return handle;
        }

        private Field getField(int id) {
            return this.fields[id];
        }

        private List<Field> scanFields(Class<?> clazz) {
            List<Field> declared = new ArrayList<>();

            Class<?> scan = clazz;
            while (scan != null && !Object.class.equals(scan)) {
                declared.addAll(Arrays.asList(scan.getDeclaredFields()));
                scan = scan.getSuperclass();
            }

            return declared;
        }
    }
}
