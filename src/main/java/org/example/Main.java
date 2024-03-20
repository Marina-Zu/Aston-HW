package org.example;

/**
 * Главный класс приложения, демонстрирующий использование функций MyArrayList и QuickSort.
 */
public class Main {

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        MyArrayList<Integer> numbers = new MyArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3, 10);
        numbers.add(4);
        numbers.add(5);

        System.out.println("Элемент с индексом 3: " + numbers.get(3));
        System.out.println("Размер списка: " + numbers.size());
        System.out.println("Длина списка: " + numbers.length());

        System.out.println("Iсходный массив " + numbers);
        QuickSort.sort(numbers);
        System.out.println("Отсортированный массив " + numbers);

        numbers.remove(0);
        System.out.println("Размер списка после удаления: " + numbers.size());
        System.out.println("Список после удаления " + numbers);
        System.out.println("Длина списка после удаления: " + numbers.length());

        numbers.remove(0);
        System.out.println("Размер списка после удаления: " + numbers.size());
        System.out.println("Длина списка после удаления: " + numbers.length());

        numbers.clear();
        System.out.println("Размер списка после очистки: " + numbers.size());
        System.out.println("Длина списка после очистки: " + numbers.length());
    }
}