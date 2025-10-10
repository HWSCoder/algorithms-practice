package com.hws.algorithms.chapter2;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public void sort(T[] array) {
        if (array == null || array.length <= 1) return;
        shuffle(array);
        sort(array, 0, array.length - 1);
    }

    private void shuffle(T[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // 0 <= j <= i
            swap(array, i, j);
        }
    }

    private void sort(T[] array, int lo, int hi) {
        if (lo >= hi) return;
        int pivotIndex = partition(array, lo, hi);
        sort(array, lo, pivotIndex - 1);
        sort(array, pivotIndex + 1, hi);
    }

    private int partition(T[] array, int lo, int hi) {
        T partitionKey = array[lo];
        int i = lo;
        int j = hi+1;
        while(true) {
            while(less(array[++i], partitionKey)) if (i >= hi) break;
            while(less(partitionKey, array[--j])) if (j <= lo) break;
            if (i>=j) break;
            swap(array, i, j);
        }
        swap(array, lo, j);
        return j;
    }
}
