package com.hws.algorithms.chapter2;

public class InsertionSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j-1]); j--) {
                swap(array, j, j-1);
            }
        }
    }
}
