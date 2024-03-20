package org.example;

/**
 * Интерфейс List представляет собой коллекцию объектов, которые могут быть доступны по индексу.
 * Этот интерфейс определяет основные операции, которые можно выполнять над списком.
 *
 * @param <T> тип объектов, хранящихся в списке
 */
public interface List<T> {
    void add(int index, T obj);

    T get(int index);

    void remove(int index);

    void set(int index, T odj);
}
