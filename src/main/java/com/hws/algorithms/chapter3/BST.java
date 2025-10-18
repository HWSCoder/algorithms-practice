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
}
