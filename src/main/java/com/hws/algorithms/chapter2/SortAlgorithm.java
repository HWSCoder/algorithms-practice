package com.hws.algorithms.chapter2;

public interface SortAlgorithm<T extends Comparable<T>> {
    void sort(T[] array);

    default boolean isSorted(T[] array) {
        for (int i= 1; i < array.length; i++) {
            if (array[i].compareTo(array[i-1]) < 0) {
                return false;
            }
        }
        return true;
    }
}
