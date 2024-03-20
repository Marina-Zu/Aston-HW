package org.example;

public interface List<T> {
    void add(int index, T obj);

    T get(int index);

    void remove(int index);
    void set(int index, T odj);
}
