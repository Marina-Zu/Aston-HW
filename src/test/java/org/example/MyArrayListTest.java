package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList<Integer> arrayList;

    @BeforeEach
    public void setUp() {
        arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(10);
    }

    @Test
    void testMyArrayListSuccessful() {
        MyArrayList<String> list = new MyArrayList<>(5);
        assertTrue(list.length() == 5);
    }

    @Test
    void testMyArrayListFailure() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new MyArrayList<>(0));
        assertEquals("Capacity invalid", exception.getMessage());
    }

    @Test
    void testAddSuccessful() {
        arrayList.add(20);
        assertEquals(20, arrayList.get(3));
    }

    @Test
    void testAddByIndexSuccessful() {
        arrayList.add(0, 20);
        assertEquals(20, arrayList.get(0));
        assertEquals(1, arrayList.get(1));
    }

    @Test
    void testAddWithExpansionCapacity(){
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
        assertEquals(null, arrayList.get(3));
    }

    @Test
    void testClearSuccessful() {
        arrayList.clear();
        assertTrue(arrayList.size() == 0);
    }

    @Test
    void testSizeSuccessful() {
        assertTrue(arrayList.size() == 3);
    }

    @Test
    void testLengthSuccessful() {
        assertTrue(arrayList.length() == 10);
    }
}