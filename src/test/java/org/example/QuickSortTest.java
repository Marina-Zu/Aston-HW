package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс QuickSortTest представляет собой класс для тестирования класса QuickSort
 * <p>
 *
 * @author Зудкина Марина
 */
class QuickSortTest {
    private MyArrayList<Integer> arrayList;

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

    @Test
    void testSortSuccessful() {
        QuickSort.sort(arrayList);
        assertEquals("[1, 1, 2, 3, 4, 5]", arrayList.toString());
    }

    @Test
    void testSort() {
        QuickSort.sort(arrayList, Comparator.naturalOrder());
        assertEquals("[1, 1, 2, 3, 4, 5]", arrayList.toString());
    }
}