package dev.thomazz.lucid.util;

import lombok.experimental.UtilityClass;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Predicate;

@UtilityClass
public class Reflections {
    private final Constructor<?> DEFAULT_CONSTRUCTOR;

    static {
        try {
            DEFAULT_CONSTRUCTOR = Object.class.getDeclaredConstructor();
        } catch (Exception ex) {
            throw new RuntimeException("Could not set up packet method cache", ex);
        }
    }

    public Field getFieldByIndex(Class<?> clazz, int index) {
        int i = 0;
        for (Field field : clazz.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                if (i++ == index) {
                    field.setAccessible(true);
                    return field;
                }
            }
        }

        throw new RuntimeException("Could not find method in class " + clazz.getName() + "!");
    }

    public Field getFieldByClassNames(Class<?> clazz, String... simpleNames) throws NoSuchFieldException {
        for (String name : simpleNames) {
            for (Field field : clazz.getDeclaredFields()) {
                String typeSimpleName = field.getType().getSimpleName();
                if (name.equals(typeSimpleName)) {
                    field.setAccessible(true);
                    return field;
                }
            }
        }

        throw new NoSuchFieldException("Could not find field in class " + clazz.getName() + " with names " + Arrays.toString(simpleNames));
    }

    public Field getFieldByType(Class<?> clazz, Class<?> type) throws NoSuchFieldException {
        for (Field field : clazz.getDeclaredFields()) {
            Class<?> foundType = field.getType();
            if (type.isAssignableFrom(foundType)) {
                field.setAccessible(true);
                return field;
            }
        }

        throw new NoSuchFieldException("Could not find field in class " + clazz.getName() + " with type " + type.getName());
    }

    public Field getFieldByName(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals(fieldName)) {
                field.setAccessible(true);
                return field;
            }
        }

        throw new NoSuchFieldException("Could not find field in class " + clazz.getName() + " with name " + fieldName);
    }

    @SafeVarargs
    public Method findMethod(Class<?> clazz, Predicate<Method>... conditions) {
        outer:
        for (Method method : clazz.getDeclaredMethods()) {
            for (Predicate<Method> condition : conditions) {
                if (!condition.test(method)) {
                    continue outer;
                }
            }

            method.setAccessible(true);
            return method;
        }

        throw new RuntimeException("Could not find method in class " + clazz.getName() + "!");
    }

    @SafeVarargs
    @SuppressWarnings("unchecked")
    public <T> Constructor<T> findConstructor(Class<?> clazz, Predicate<Constructor<?>>... conditions) {
        outer:
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            for (Predicate<Constructor<?>> condition : conditions) {
                if (!condition.test(constructor)) {
                    continue outer;
                }
            }

            constructor.setAccessible(true);
            return (Constructor<T>) constructor;
        }

        throw new RuntimeException("Could not find method in class " + clazz.getName() + "!");
    }

    @SafeVarargs
    public Field findField(Class<?> clazz, Predicate<Field>... conditions) {
        outer:
        for (Field field : clazz.getDeclaredFields()) {
            for (Predicate<Field> condition : conditions) {
                if (!condition.test(field)) {
                    continue outer;
                }
            }

            field.setAccessible(true);
            return field;
        }

        throw new RuntimeException("Could not find method in class " + clazz.getName() + "!");
    }

    public Constructor<?> getNoArgsConstructor(Class<?> clazz) {
        try {
            return ReflectionFactory.getReflectionFactory()
                .newConstructorForSerialization(clazz, Reflections.DEFAULT_CONSTRUCTOR);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to create object: " + clazz.getName(), ex);
        }
    }
}


