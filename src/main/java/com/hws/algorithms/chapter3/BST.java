package com.hws.algorithms.chapter3;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size; // 以该节点为根的子树节点总数

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null) return new Node(key, val, 1);
        int comparator = key.compareTo(node.key);
        if (comparator == 0) node.val = val;
        else if (comparator > 0) node.right = put(node.right, key, val);
        else node.left = put(node.left, key, val);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node node, Key key) {
        if (node == null) return null;
        int comparator = key.compareTo(node.key);
        if (comparator < 0) return get(node.left, key);
        else if (comparator > 0) return get(node.right, key);
        return node.val;
    }

    public Key min() {
        return min(root);
    }

    private Key min(Node node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node.key;
    }

    public Key max() {
        return max(root);
    }
    private Key max(Node node) {
        if (node == null) return null;
        while (node.right != null) {
            node = node. right;
        }
        return node.key;
    }

    // ---------- 进阶功能 ----------

    /** 返回 <= key 的最大键 (floor) */
    public Key floor(Key key) {
        Node t = floor(root, key);
        return t == null ? null : t.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;
        int comparator = key.compareTo(node.key);
        if (comparator < 0) return floor(node.left, key);
        if (comparator == 0) return node;
        Node t = floor(node.right, key);
        if (t != null) return t;
        else return node;
    }

    /** 返回 >= key 的最小键 (ceiling) */
    public Key ceiling(Key key) {
        Node t = ceiling(root, key);
        return t == null ? null : t.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int comparator = key.compareTo(node.key);
        if (comparator > 0) return ceiling(node.right, key);
        if (comparator == 0) return node;
        Node t = ceiling(node.left, key);
        if (t != null) return t;
        return node;
    }

    /** 返回比 key 小的节点个数 */
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null) return 0;
        int comparator = key.compareTo(node.key);
        if (comparator == 0) return size(node.left);
        else if (comparator > 0) return 1 + size(node.left) + rank(node.right, key);
        else return rank(node.left, key);
    }

    /** 返回排名为 k 的键（第 k 小） */
    public Key select(int k) {
        Node t = select(root, k);
        return t == null ? null : t.key;
    }

    public Node select(Node node, int k) {
        if (node == null) return null;
        int lessCount = size(node.left);
        if (lessCount > k) return select(node.left, k);
        else if (lessCount < k) return select(node.right, k - lessCount - 1);
        else return node;
    }

    /** 删除最小键 */
    public void deleteMin() {
        // TODO: implement recursively
    }

    /** 删除最大键 */
    public void deleteMax() {
        // TODO: implement recursively
    }

    /** 删除指定键 */
    public void delete(Key key) {
        // TODO: implement recursively (Hibbard deletion)
    }
}
