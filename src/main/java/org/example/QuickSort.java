package org.example;

import java.util.Comparator;

/**
 * @param <T> тип элементов в массиве
 * @author Marina Zu
 * Класс для сортировки массива с использованием алгоритма QuickSort
 */
public class QuickSort<T> {
    /**
     * Сортирует массив с использованием алгоритма быстрой сортировки, если элементы реализуют интерфейс Comparable.
     * Элементы сравниваются с помощью метода compareTo()
     *
     * @param arrayList массив, который нужно отсортировать
     * @param <T>       тип элементов массива
     */
    public static <T extends Comparable<T>> void sort(MyArrayList<T> arrayList) {
        sort(arrayList, null);
    }

    /**
     * Сортирует массив с использованием алгоритма быстрой сортировки.
     * Элементы сравниваются с помощью метода compareTo() (если элементы реализуют интерфейс Comparable)
     * или с помощью предоставленного компаратора.
     *
     * @param arrayList  массив, который нужно отсортировать
     * @param comparator компаратор для сравнения элементов массива (может быть null)
     * @param <T>        тип элементов массива
     */
    public static <T> void sort(MyArrayList<T> arrayList, Comparator<T> comparator) {
        quickSort(arrayList, 0, arrayList.size() - 1, comparator);
    }

    private static <T> void quickSort(MyArrayList<T> arrayList, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(arrayList, low, high, comparator);
            quickSort(arrayList, low, pivotIndex - 1, comparator);
            quickSort(arrayList, pivotIndex + 1, high, comparator);
        }
    }

    private static <T> int partition(MyArrayList<T> arrayList, int low, int high, Comparator<T> comparator) {
        T pivot = arrayList.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if ((comparator == null && ((Comparable<T>) arrayList.get(j)).compareTo(pivot) < 0) ||
                    (comparator != null && comparator.compare(arrayList.get(j), pivot) < 0)) {
                i++;
                swap(arrayList, i, j);
            }
        }
        swap(arrayList, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(MyArrayList<T> arrayList, int i, int j) {
        T temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }
}
