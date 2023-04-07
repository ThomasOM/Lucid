package dev.thomazz.lucid.generator.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.ClassUtils;

@UtilityClass
public class TypeUtils {
    // Only primitives and classes visible to the api are compatible, otherwise use the object class as a parent
    public Class<?> compatibleType(Class<?> originalType) {
        if (ClassUtils.isPrimitiveOrWrapper(originalType)) {
            return originalType;
        }

        if (originalType.getClassLoader() == null || originalType.getClassLoader().equals(ClassLoader.getSystemClassLoader())) {
            return originalType;
        }

        return Object.class;
    }

    // Classes only needs imports if they are actually visible to the api and are not primitives
    public boolean needsImport(Class<?> type) {
        if (ClassUtils.isPrimitiveOrWrapper(type)) {
            return false;
        }

        String name = type.getName();
        return !name.startsWith("java.lang") && name.startsWith("java");
    }
}
