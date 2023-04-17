package dev.thomazz.lucid.accessor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Accessor {
    protected Object handle;

    public <T> T get(int fieldId) {
        return AccessorCache.get(this.handle.getClass(), this.handle, fieldId);
    }

    public <T> void set(int fieldId, T value) {
        AccessorCache.set(this.handle.getClass(), this.handle, fieldId, value);
    }

    protected <T> Class<T> getType(int fieldId) {
        return AccessorCache.type(this.handle.getClass(), fieldId);
    }
}
