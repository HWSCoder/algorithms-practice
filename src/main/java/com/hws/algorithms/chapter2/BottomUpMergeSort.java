package com.hws.algorithms.chapter2;

public class BottomUpMergeSort<T extends Comparable<T>> extends AbstractSort<T> {
    private T[] aux;

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int n = array.length;
        aux = (T[]) new Comparable[n];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo = lo + 2*sz) {
                merge(array, lo, lo + sz - 1, Math.min(lo + 2*sz-1, n - 1));
            }
        }

    }

    private void merge(T[] array, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (less(aux[i], aux[j])) array[k] = aux[i++];
            else array[k] = aux[j++];
        }
    }
}
