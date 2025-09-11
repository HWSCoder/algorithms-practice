package com.hws.algorithms.chapter1;

import com.hws.algorithms.commom.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasicTest {

    @Test
    void testSizeEmptyList() {
        assertEquals(0, LinkedListBasic.size(null));
    }

    @Test
    void testSizeNonEmptyList() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        assertEquals(2, LinkedListBasic.size(n1));
    }

    @Test
    void testInsertAtHead() {
        Node n1 = new Node(1);
        Node newHead = new Node(0);

        Node head = LinkedListBasic.insertAtHead(n1, newHead);

        assertEquals(0, head.item);
        assertEquals(1, head.next.item);
    }

    @Test
    void testAppendAtTail() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;

        Node n3 = new Node(3);
        Node head = LinkedListBasic.appendAtTail(n1, n3);

        assertEquals(1, head.item);
        assertEquals(2, head.next.item);
        assertEquals(3, head.next.next.item);
    }

    @Test
    void testAppendAtTailEmptyList() {
        Node n1 = new Node(1);
        Node head = LinkedListBasic.appendAtTail(null, n1);

        assertEquals(1, head.item);
        assertNull(head.next);
    }
}
