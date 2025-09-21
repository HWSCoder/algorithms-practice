package com.hws.algorithms.chapter2;

public class SelectionSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int localMinIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[localMinIndex])) {
                    localMinIndex = j;
                }
            }
            swap(array, i, localMinIndex);
        }
    }
}
