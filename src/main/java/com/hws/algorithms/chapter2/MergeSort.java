package com.hws.algorithms.chapter2;

public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {
    private T[] aux;  // auxiliary array for merges

    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        aux = (T[]) new Comparable[array.length];
        sort(array, 0, array.length-1);
    }

    private void sort(T[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(array, lo, mid);
        sort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    private void merge(T[] array, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <=hi; k++) {
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
