package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс MyArrayListTest представляет собой класс для тестирования класса MyArrayList
 * <p>
 *
 * @author Зудкина Марина
 */
class MyArrayListTest {
    private MyArrayList<Integer> arrayList;

    /**
     * Создаем и заполняем список
     */
    @BeforeEach
    public void setUp() {
        arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(10);
    }

    /**
     * Проверяем, что метод создается список заданной длины
     */
    @Test
    void testMyArrayListSuccessful() {
        MyArrayList<String> list = new MyArrayList<>(5);
        assertEquals(5, list.length());
    }

    /**
     * Проверяем, что метод создается список заданной длины
     */
    @Test
    void testMyArrayListFailure() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new MyArrayList<>(0));
        assertEquals("Capacity invalid", exception.getMessage());
    }

    @Test
    void testAddSuccessful() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
            assertEquals(i + 1, list.size());
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void testAddByIndexSuccessful() {
        arrayList.add(0, 20);
        assertEquals(20, arrayList.get(0));
        assertEquals(1, arrayList.get(1));
    }

    @Test
    void testAddWithExpansionCapacity() {
        int originalLength = arrayList.length();
        for (int i = 0; i < 7; i++) {
            arrayList.add(i);
        }
        assertEquals(originalLength * 2, arrayList.length());
    }

    @Test
    void testAddByIndexFailure() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> arrayList.add(-1, 20));
        assertEquals("Invalid index -1", exception.getMessage());
    }

    /**
     * Проверяем, что метод get возвращает ожидаемое значение
     */
    @Test
    void testGetSuccessful() {
        assertEquals(10, arrayList.get(2));
    }

    @Test
    void testRemoveSuccessful() {
        arrayList.remove(0);
        assertEquals(5, arrayList.get(0));
    }


    @Test
    void testSetSuccessful() {
        arrayList.set(0, 20);
        assertEquals(20, arrayList.get(0));
        assertNull(arrayList.get(3));
    }

    @Test
    void testClearSuccessful() {
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    @Test
    void testSizeSuccessful() {
        assertEquals(3, arrayList.size());
    }

    @Test
    void testLengthSuccessful() {
        assertEquals(10, arrayList.length());
    }
}