package dev.thomazz.lucid.accessor.data.conversion;

public interface Converter<T> {
    T fromHandle(Object handle);

    Object toHandle(T object);
}
