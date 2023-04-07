package dev.thomazz.lucid.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ListWrapper<E> extends ArrayList<E> {
    private final Consumer<E> addConsumer;

    public ListWrapper(List<E> list, Consumer<E> consumer) {
        super(list);
        this.addConsumer = consumer;
    }

    public boolean add(E e) {
        this.addConsumer.accept(e);
        return super.add(e);
    }
}
