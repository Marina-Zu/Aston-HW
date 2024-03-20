package org.example;

import java.util.Arrays;

/**
 * Класс MyArrayList представляет собой список, реализованный в виде массива.
 * Он предоставляет методы для добавления, удаления, получения и замены элементов в списке,
 * а также для сортировки и очистки списка.
 * <p>
 * Этот класс не является потокобезопасным.
 *
 * @param <T> тип элементов в списке
 * @author Зудкина Марина
 */
public class MyArrayList<T> implements List<T> {
    /**
     * Фиксированный первоначальный размер массива
     */
    private final int ARRAY_CAPACITY = 10;
    /**
     * Количество свободных ячеек,
     * при недостатке которых происходит увеличение размера массива в 2 раза
     */
    private final int RESERVE_SIZE = 2;
    private T[] array;
    /**
     * Размер массива
     */
    private int size = 0;

    /**
     * Конструктор по умолчанию
     */
    public MyArrayList() {
        array = (T[]) new Object[ARRAY_CAPACITY];
    }

    /**
     * Конструктор с заданной длиной массива
     *
     * @param capacity первоначальный размер массива
     */
    public MyArrayList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity invalid");
        array = (T[]) new Object[capacity];
    }

    /**
     * Добавление элемента
     *
     * @param element значение элемента
     */
    public void add(T element) {
        expansionCapacity();
        array[size++] = element;
    }

    /**
     * Добавление элемента по индексу
     *
     * @param element значение элемента
     * @param index индекс места вставки элемента
     */
    public void add(int index, T element) {
        checkIndex(index);
        expansionCapacity();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    /**
     * Возвращение элемента по индексу
     *
     * @param index индекс возвращаемого элемента
     * @return T тип возвращаемого значения
     */
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * Удаление элемента по индексу
     *
     * @param index индекс удаляемого элемента
     */
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = null;
        reductionCapacity();
    }

    /**
     * Замена элемента по индексу
     *
     * @param element значение элемента
     * @param index индекс места замены элемента
     */
    public void set(int index, T element) {
        checkIndex(index);
        array[index] = element;
    }

    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
        array = Arrays.copyOf(array, ARRAY_CAPACITY);
    }

    /**
     * Размер массива
     *
     * @return возвращает размер заполненного массива
     */
    public int size() {
        return size;
    }

    /**
     * Длина массива
     *
     * @return возвращает длину массива
     */
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
