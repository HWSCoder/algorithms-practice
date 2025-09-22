package com.hws.algorithms.chapter2;

public class ShellSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public void sort(T[] array) {
        int n = array.length;
        int h = 1;

        while (h < n/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(array[j], array[j-h]); j -= h) {
                    swap(array, j, j-h);
                }
            }
            h = h/3;
        }
    }
}
