package com.hws.algorithms.chapter1;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int size;
    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
        size = 0;
    }
    public void push(Item item) {
        if (size == a.length) {
            throw new RuntimeException("Hit capacity:" + a.length);
        }
        a[size] = item;
        size++;
    }
    public Item pop() {
        if (size == 0) {
            throw new RuntimeException("No more element to pop");
        }
        Item item = a[--size];
        a[size] = null;
        return item;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
}
