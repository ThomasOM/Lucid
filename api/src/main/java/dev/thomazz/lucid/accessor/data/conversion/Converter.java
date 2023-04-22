package dev.thomazz.lucid.accessor.data.conversion;

import java.lang.reflect.AccessibleObject;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class Converter<T> {
    private final Map<String, AccessibleObject> reflectionCache = new HashMap<>();

    @SuppressWarnings("unchecked")
    protected final <V extends AccessibleObject> V cache(String key, Supplier<V> supplier) {
        return (V) this.reflectionCache.computeIfAbsent(key, val -> supplier.get());
    }

    public final T fromHandle(Object handle) {
        try {
            return this.convertFrom(handle);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to convert from handle!", ex);
        }
    }

    public final Object toHandle(T object) {
        try {
            return this.convertTo(object);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to convert to handle!", ex);
        }
    }

    protected abstract T convertFrom(Object handle) throws Exception;

    protected abstract Object convertTo(T object) throws Exception;

}
