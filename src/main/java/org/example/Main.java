package org.example;

import java.util.*;
// Лабораторна №1
public class Main {
    private static final int LIST_SIZE = 100_000;
    private static final int INSERT_COUNT = 1_000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        fill(arrayList, LIST_SIZE, "ArrayList");
        fill(linkedList, LIST_SIZE, "LinkedList");

        randomAccess(arrayList, "ArrayList");
        randomAccess(linkedList, "LinkedList");

        sequentialAccess(arrayList, "ArrayList");
        sequentialAccess(linkedList, "LinkedList");

        insertAtStart(arrayList, INSERT_COUNT, "ArrayList");
        insertAtStart(linkedList, INSERT_COUNT, "LinkedList");

        insertAtEnd(arrayList, INSERT_COUNT, "ArrayList");
        insertAtEnd(linkedList, INSERT_COUNT, "LinkedList");

        insertAtMiddle(arrayList, INSERT_COUNT, "ArrayList");
        insertAtMiddle(linkedList, INSERT_COUNT, "LinkedList");
    }

    private static void fill(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis(); // отримуємо машинний час
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            list.add(rand.nextInt(count));
        }
        System.out.printf("Fill %s: %s(ms)\n", listType, System.currentTimeMillis() - time); /* отримуємо
        машинний час ще раз і вираховуємо різницю що і є часом виконання*/
    }

    private static void randomAccess(List<Integer> list, String listType) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i); // считуємо кожен елемент структури
        }
        System.out.printf("Random access in %s: %s(ms)\n", listType, System.currentTimeMillis() - time);
    }

    private static void sequentialAccess(List<Integer> list, String listType) {
        long time = System.currentTimeMillis();
        for (Integer i : list) {}
        System.out.printf("Sequential access in %s: %s(ms)\n", listType, System.currentTimeMillis() - time);
    }

    private static void insertAtStart(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(0, i); // додається новий елемент на 0-вий індекс (початок)
        }
        System.out.printf("Insert at start of %s: %s(ms)\n", listType, System.currentTimeMillis() - time);
    }

    private static void insertAtEnd(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(i); // додається новий елемент в кінець
        }
        System.out.printf("Insert at end of %s: %s(ms)\n", listType, System.currentTimeMillis() - time);
    }

    private static void insertAtMiddle(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        int middleIndex = list.size() / 2;
        for (int i = 0; i < count; i++) {
            list.add(middleIndex, i);
        }
        System.out.printf("Insert in the middle of %s: %s(ms)\n", listType, System.currentTimeMillis() - time);
    }
}
