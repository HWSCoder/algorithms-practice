package com.hws.algorithms.chapter1;

/**
 * Quick-Find implementation of Union-Find (disjoint set).
 *
 * API:
 * - UF(int n)       // initialize with n objects (0 to n-1)
 * - void union(p,q) // add a connection between p and q
 * - boolean connected(p,q) // are p and q in the same component?
 * - int find(p)     // component id for p
 * - int count()     // number of components
 */
public class QuickFindUF {
    private int[] id;   // id[i] = component identifier of i
    private int count;  // number of components

    /**
     * Initialize Union-Find structure with n elements.
     * Each element is in its own component initially.
     */
    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
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
     * Returns the component id of element p.
     */
    public int find(int p) {
        return id[p];
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
        if (connected(p, q)) {
            return;
        }
        int pId = id[p];
        int qId = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }
}
