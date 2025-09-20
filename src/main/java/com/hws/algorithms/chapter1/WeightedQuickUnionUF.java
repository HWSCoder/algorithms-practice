package com.hws.algorithms.chapter1;

/**
 * Weighted Quick-Union implementation of Union-Find (Disjoint Set).
 *
 * API:
 * - UF(int n)       // initialize with n objects (0 to n-1)
 * - void union(p,q) // add a connection between p and q
 * - boolean connected(p,q) // are p and q in the same component?
 * - int find(p)     // root of p
 * - int count()     // number of components
 */
public class WeightedQuickUnionUF {
    private int[] id;  // parent[i] = parent of i
    private int[] size;    // size[i] = number of nodes in tree rooted at i
    private int count;     // number of components

    /**
     * Initialize Union-Find structure with n elements.
     */
    public WeightedQuickUnionUF(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        for (int i = 0; i < n; i++) {
            size[i] = 1;
        }
        count = n;
    }

    /**
     * Returns the number of connected components.
     */
    public int count() {
        return count;
    }

    /**
     * Returns the root of element p.
     */
    public int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }

    /**
     * Returns true if elements p and q are in the same component.
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Merges the component containing p with the component containing q.
     */
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }
}
