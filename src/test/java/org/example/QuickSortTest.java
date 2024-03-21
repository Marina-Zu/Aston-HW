package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс QuickSortTest представляет собой класс для тестирования сортировки списка с использованием класса QuickSort.
 * <p>
 * Он содержит методы для проверки корректности сортировки списка с использованием QuickSort.
 * </p>
 */
class QuickSortTest {
    private MyArrayList<Integer> arrayList;
    /**
     * Устанавливаем начальное состояние списка перед каждым тестом.
     */
    @BeforeEach
    void setUp() {
        arrayList = new MyArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(4);
    }

    /**
     * Проверяет успешную сортировку списка с использованием QuickSort.
     */
    @Test
    void testSortSuccessful() {
        QuickSort.sort(arrayList);
        assertEquals("[1, 1, 2, 3, 4, 5]", arrayList.toString());
    }

    /**
     * Проверяет успешную сортировку списка с использованием QuickSort и переданным компаратором.
     */
    @Test
    void testSort() {
        QuickSort.sort(arrayList, Comparator.naturalOrder());
        assertEquals("[1, 1, 2, 3, 4, 5]", arrayList.toString());
    }
}