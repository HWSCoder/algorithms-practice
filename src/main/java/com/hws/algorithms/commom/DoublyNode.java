package com.hws.algorithms.commom;

public class DoublyNode<Item> {
    public DoublyNode previous;
    public Item item;
    public DoublyNode next;

    public DoublyNode(Item item) {
        this.item = item;
    }
}
