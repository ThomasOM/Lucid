package dev.thomazz.lucid.packet;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public abstract class PacketIterable implements Iterable<PacketType> {
    private final List<PacketType> types = new ArrayList<>();

    PacketIterable() {
        try {
            for (Field field : this.getClass().getFields()) {
                if (Modifier.isStatic(field.getModifiers()) && PacketType.class.isAssignableFrom(field.getType())) {
                    PacketType type = (PacketType) field.get(null);
                    this.types.add(type);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Could not load packet iterable!", ex);
        }
    }

    public Iterator<PacketType> iterator() {
        return this.types.iterator();
    }

    public Stream<PacketType> stream() {
        return this.types.stream();
    }
}
