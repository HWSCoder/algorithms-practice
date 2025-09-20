package com.hws.algorithms.chapter1;

/**
 * Union-Find with Path Compression (template).
 *
 * API:
 * - UF(int n)       // initialize with n objects (0 to n-1)
 * - void union(p,q) // add a connection between p and q
 * - boolean connected(p,q) // are p and q in the same component?
 * - int find(p)     // root of p (with path compression)
 * - int count()     // number of components
 */
public class PathCompressionUF {
    private int[] id; // parent[i] = parent of i
    private int[] size;   // size[i] = number of nodes in tree rooted at i
    private int count;    // number of components

    /**
     * Initialize Union-Find structure with n elements.
     */
    public PathCompressionUF(int n) {
        id = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Returns the number of connected components.
     */
    public int count() {
        return count;
    }

    /**
     * Returns the root of element p, with path compression.
     */
    public int find(int p) {
        while (p != id[p]) {
            // 路径压缩：直接让p指向自己的根节点
            id[p] = find(id[p]);
            p = id[p];
        }
        return p;
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
