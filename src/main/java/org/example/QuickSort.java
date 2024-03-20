package org.example;

import java.util.Comparator;

public class QuickSort<T> {
    public static <T extends Comparable<T>> void sort(MyArrayList<T> arrayList) {
        sort(arrayList, null);
    }

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
            if  ((comparator == null && ((Comparable<T>) arrayList.get(j)).compareTo(pivot) < 0) ||
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
