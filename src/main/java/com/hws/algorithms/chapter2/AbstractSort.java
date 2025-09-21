package com.hws.algorithms.chapter2;

public abstract class AbstractSort<T extends Comparable<T>> implements SortAlgorithm<T> {
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
    protected void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    protected  void show(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
