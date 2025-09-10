package com.hws.algorithms.chapter1;

import com.hws.algorithms.Node;

public class LinkedListBasic {
    public static int size(Node node) {
        int size = 0;
        Node current = node;
        while(current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    public static Node insertAtHead(Node header, Node nodeToInsert) {
        if (header == null) {
            return nodeToInsert;
        }
        nodeToInsert.next = header;
        return nodeToInsert;
    }
    public static Node appendAtTail(Node header, Node nodeToAppend) {
        if (header == null) {
            return nodeToAppend;
        }
        Node current = header;
        while (current.next != null) {
            current = current.next;
        }
        current.next = nodeToAppend;
        return header;
    }
}
