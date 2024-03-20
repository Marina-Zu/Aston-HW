package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> implements List<T> {
    private final int ARRAY_CAPACITY = 10;
    private final int RESERVE_SIZE = 2;
    private T[] array;
    private int size = 0;

    public MyArrayList() {
        array = (T[]) new Object[ARRAY_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity invalid");
        array = (T[]) new Object[capacity];
    }

    public void add(T element) {
        expansionCapacity();
        array[size++] = element;
    }

    public void add(int index, T element) {
        checkIndex(index);
        expansionCapacity();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;
        reductionCapacity();
    }

    public void set(int index, T element) {
        checkIndex(index);
        array[index] = element;
    }

    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
        array = Arrays.copyOf(array, ARRAY_CAPACITY);
    }

    public int size() {
        return size;
    }

    public int length() {
        return array.length;
    }

    private void checkIndex(int index) {
        if (index > size || index < 0)
            throw new IllegalArgumentException("Invalid index " + index);
    }

    private void expansionCapacity() {
        if (array.length - RESERVE_SIZE == size)
            array = Arrays.copyOf(array, array.length * 2);
    }

    private void reductionCapacity() {
        if (array.length - RESERVE_SIZE > size * 2)
            array = Arrays.copyOf(array, array.length / 2 + 1);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
