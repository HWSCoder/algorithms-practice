package com.hws.algorithms.chapter1;

import com.hws.algorithms.commom.Node;

public class QueueImplementByLinkedList<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int numberOfElements;

    public void enqueue(Item item) {
        Node nodeToEnqueue = new Node(item);
        if (isEmpty()) {
            first = nodeToEnqueue;
        } else {
            last.next = nodeToEnqueue;
        }
        last = nodeToEnqueue;
        numberOfElements++;
    }
    public Item dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue");
        }
        Node newFirst = first.next;
        Item item = first.item;
        first = newFirst;
        numberOfElements--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
    public int size() {
        return numberOfElements;
    }
    public boolean isEmpty() {
        return numberOfElements == 0;
    }
    public Item peek() {
        if (numberOfElements == 0) {
            throw new RuntimeException("Empty queue");
        }
        return first.item;
    }
}
