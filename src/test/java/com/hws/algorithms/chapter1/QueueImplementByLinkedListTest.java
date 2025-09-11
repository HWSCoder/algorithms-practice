package com.hws.algorithms.chapter1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueImplementByLinkedListTest {

    @Test
    void testEnqueueAndSize() {
        QueueImplementByLinkedList<Integer> q = new QueueImplementByLinkedList<>();
        assertTrue(q.isEmpty());
        q.enqueue(1);
        q.enqueue(2);
        assertEquals(2, q.size());
        assertFalse(q.isEmpty());
    }

    @Test
    void testDequeueOrder() {
        QueueImplementByLinkedList<String> q = new QueueImplementByLinkedList<>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");

        assertEquals("A", q.dequeue());
        assertEquals("B", q.dequeue());
        assertEquals("C", q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test
    void testPeekDoesNotRemove() {
        QueueImplementByLinkedList<Integer> q = new QueueImplementByLinkedList<>();
        q.enqueue(10);
        q.enqueue(20);

        assertEquals(10, q.peek());
        assertEquals(2, q.size()); // peek 不应改变大小
    }

    @Test
    void testDequeueUntilEmptyResetsLast() {
        QueueImplementByLinkedList<Integer> q = new QueueImplementByLinkedList<>();
        q.enqueue(42);
        assertEquals(42, q.dequeue());
        assertTrue(q.isEmpty());

        // 再次入队应该仍然可用
        q.enqueue(99);
        assertEquals(99, q.peek());
        assertEquals(1, q.size());
    }

    @Test
    void testDequeueFromEmptyThrows() {
        QueueImplementByLinkedList<Double> q = new QueueImplementByLinkedList<>();
        assertThrows(RuntimeException.class, q::dequeue);
    }

    @Test
    void testPeekOnEmptyThrows() {
        QueueImplementByLinkedList<String> q = new QueueImplementByLinkedList<>();
        assertThrows(RuntimeException.class, q::peek);
    }
}
