package com.hws.algorithms.chapter1;

import com.hws.algorithms.commom.DoublyNode;

public class Dqueue<Item> {
    private DoublyNode<Item> first;
    private DoublyNode<Item> last;
    private int numberOfElement;

    public boolean isEmpty() {
        return numberOfElement == 0;
    }
    public int size() {
        return numberOfElement;
    }
    public void pushLeft(Item item) {
        DoublyNode current = new DoublyNode(item);
        if (isEmpty()) {
            first = current;
            last = current;
        } else {
            first.previous = current;
            current.next = first;
            first = current;
        }
        numberOfElement++;
    }
    public void pushRight(Item item) {
        DoublyNode current = new DoublyNode(item);
        if (isEmpty()) {
            first = current;
            last = current;
        } else {
            last.next = current;
            current.previous = last;
            last = current;
        }
        numberOfElement++;
    }
    public Item popLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Dqueue");
        }
        Item temp = first.item;
        if (numberOfElement == 1) {
            first = null;
            last = null;
            numberOfElement--;
            return temp;
        }
        DoublyNode newFirst = first.next;
        newFirst.previous = null;
        first.next = null;
        first = newFirst;
        numberOfElement--;
        return temp;
    }

    public Item popRight() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Dqueue");
        }
        Item temp = last.item;
        if (numberOfElement == 1) {
            first = null;
            last = null;
            numberOfElement--;
            return temp;
        }
        DoublyNode newLast = last.previous;
        newLast.next = null;
        last.previous = null;
        last = newLast;
        numberOfElement--;
        return temp;
    }
}
