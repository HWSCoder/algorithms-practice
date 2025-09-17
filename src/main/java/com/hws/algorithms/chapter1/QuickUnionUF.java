package com.hws.algorithms.chapter1;

public class QuickUnionUF {
    private int[] id;
    private int count;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        count = n;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public int find(int p) {
        while(id[p] != p) p = id[p];
        return p;
    }

    public int count() {
        return count;
    }
}
