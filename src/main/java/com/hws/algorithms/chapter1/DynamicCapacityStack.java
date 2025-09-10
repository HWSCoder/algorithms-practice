package com.hws.algorithms.chapter1;

public class DynamicCapacityStack<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item) {
        if (a.length == size) {
            resize(size * 2);
        }
        a[size] = item;
        size++;
    }

    public Item pop() {
        Item item = a[--size];
        a[size] = null;
        if (size > 0 && size <= a.length/4) {
            resize(a.length/2);
        }
        return item;
    }
}
