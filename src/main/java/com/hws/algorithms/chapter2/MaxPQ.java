package com.hws.algorithms.chapter2;

public class MaxPQ<T extends Comparable<T>> {
    private T[] pq;   // binary heap, 1-indexed
    private int n;    // number of elements in pq

    public MaxPQ(int capacity) {
        pq = (T[]) new Comparable[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(T item) {
        pq[++n] = item;
        swim(n);
    }

    public T delMax() {
        if (isEmpty()) throw new RuntimeException("Heap underflow");
        T max = pq[1];
        exch(1, n);
        pq[n] = null;
        n--;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while(2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (less(j, k)) break;
            exch(j, k);
            k = j;
        }
    }

    private void exch(int i, int j) {
        T t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}
