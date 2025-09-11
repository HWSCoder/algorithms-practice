package com.hws.algorithms.chapter1;

import com.hws.algorithms.commom.Node;

public class StackImplementedByLinkedList<Item> {
    private int numberOfElements;
    private Node<Item> first;

    public int size() {
        return numberOfElements;
    }
    public Item pop() {
        if (numberOfElements == 0) {
            throw new RuntimeException("Can't pop element from an empty stack");
        }
        Item item = first.item;
        first = first.next;
        numberOfElements--;
        return item;
    }
    public void push(Item item) {
        Node newHeader = new Node(item);
        newHeader.next = first;
        first = newHeader;
        numberOfElements++;
    }

    public Item peek() {
        if (numberOfElements == 0) {
            throw new RuntimeException("Empty stack");
        }
        return first.item;
    }
}
