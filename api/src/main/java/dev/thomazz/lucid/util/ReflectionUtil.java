package dev.thomazz.lucid.util;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Predicate;

@UtilityClass
public class ReflectionUtil {
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

            return field;
        }

        throw new RuntimeException("Could not find method in class " + clazz.getName() + "!");
    }

    @SuppressWarnings("unchecked")
    public <T> T invokeMethod(Method method, Object object, Object... params) {
        try {
            return (T) method.invoke(object, params);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T invokeConstructor(Constructor<?> constructor, Object... params) {
        try {
            return (T) constructor.newInstance(params);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}


