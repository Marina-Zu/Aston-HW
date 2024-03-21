package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс MyArrayListTest представляет собой класс для тестирования класса MyArrayList.
 * <p>
 * Он содержит набор методов для проверки корректности работы различных методов класса MyArrayList.
 * </p>
 */
class MyArrayListTest {
    private MyArrayList<Integer> arrayList;

    /**
     * Создает и заполняет список перед каждым тестом.
     */
    @BeforeEach
    public void setUp() {
        arrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++)
            arrayList.add(i);
    }

    /**
     * Проверяет, что конструктор создает список заданной длины.
     */
    @Test
    void testMyArrayListSuccessful() {
        MyArrayList<String> list = new MyArrayList<>(5);
        assertEquals(5, list.length());
    }

    /**
     * Проверяет, что конструктор выбрасывает исключение IndexOutOfBoundsException при недопустимой емкости.
     */
    @Test
    void testMyArrayListFailure() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new MyArrayList<>(0));
        assertEquals("Capacity invalid", exception.getMessage());
    }

    /**
     * Проверяет успешное добавление элементов в список.
     */
    @Test
    void testAddSuccessful() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
            assertEquals(i + 1, list.size());
            assertEquals(i, list.get(i));
        }
    }

    /**
     * Проверяет успешное добавление элемента по указанному индексу.
     */
    @Test
    void testAddByIndexSuccessful() {
        arrayList.add(0, 20);
        assertEquals(20, arrayList.get(0));
        for (int i = 0; i < 10; i++) {
            assertEquals(i, arrayList.get(i + 1));
        }


    }

    /**
     * Проверяет, что список увеличивает свою емкость при необходимости.
     */
    @Test
    void testAddWithExpansionCapacity() {
        int originalLength = arrayList.length();
        for (int i = 0; i < 9; i++) {
            arrayList.add(i);
        }
        assertEquals(originalLength * 2, arrayList.length());
    }

    /**
     * Проверяет, что метод add выбрасывает исключение IndexOutOfBoundsException при недопустимом индексе.
     */
    @Test
    void testAddByIndexFailure() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> arrayList.add(-1, 20));
        assertEquals("Invalid index -1", exception.getMessage());
    }

    /**
     * Проверяет успешное получение элемента по индексу.
     */
    @Test
    void testGetSuccessful() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, arrayList.get(i));
        }
    }

    /**
     * Проверяет успешное удаление элемента по индексу.
     */
    @Test
    void testRemoveSuccessful() {
        arrayList.remove(0);
        for (int i = 0; i < 9; i++) {
            assertEquals(i + 1, arrayList.get(i));
        }
    }

    /**
     * Проверяет успешное замещение элемента по индексу.
     */
    @Test
    void testSetSuccessful() {
        arrayList.set(0, 20);
        assertEquals(20, arrayList.get(0));
        for (int i = 1; i < 10; i++) {
            assertEquals(i, arrayList.get(i));
        }
    }

    /**
     * Проверяет успешную очистку списка.
     */
    @Test
    void testClearSuccessful() {
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

    /**
     * Проверяет успешное получение размера списка.
     */
    @Test
    void testSizeSuccessful() {
        assertEquals(10, arrayList.size());
    }

    /**
     * Проверяет успешное получение длины списка.
     */
    @Test
    void testLengthSuccessful() {
        assertEquals(20, arrayList.length());
    }
}