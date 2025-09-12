package com.hws.algorithms.chapter1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DqueueTest {

    @Test
    void testPushLeftAndSize() {
        Dqueue<Integer> dq = new Dqueue<>();
        assertTrue(dq.isEmpty());
        dq.pushLeft(1);
        dq.pushLeft(2);
        assertEquals(2, dq.size());
    }

    @Test
    void testPushRightAndSize() {
        Dqueue<String> dq = new Dqueue<>();
        dq.pushRight("A");
        dq.pushRight("B");
        assertEquals(2, dq.size());
    }

    @Test
    void testPopLeftOrder() {
        Dqueue<Integer> dq = new Dqueue<>();
        dq.pushRight(1);
        dq.pushRight(2);
        dq.pushRight(3);

        assertEquals(1, dq.popLeft());
        assertEquals(2, dq.popLeft());
        assertEquals(3, dq.popLeft());
        assertTrue(dq.isEmpty());
    }

    @Test
    void testPopRightOrder() {
        Dqueue<String> dq = new Dqueue<>();
        dq.pushLeft("A");
        dq.pushLeft("B");
        dq.pushLeft("C");

        assertEquals("A", dq.popRight());
        assertEquals("B", dq.popRight());
        assertEquals("C", dq.popRight());
        assertTrue(dq.isEmpty());
    }

    @Test
    void testMixedOperations() {
        Dqueue<Integer> dq = new Dqueue<>();
        dq.pushLeft(1);  // [1]
        dq.pushRight(2); // [1,2]
        dq.pushLeft(3);  // [3,1,2]
        dq.pushRight(4); // [3,1,2,4]

        assertEquals(3, dq.popLeft());  // [1,2,4]
        assertEquals(4, dq.popRight()); // [1,2]
        assertEquals(1, dq.popLeft());  // [2]
        assertEquals(2, dq.popRight()); // []
        assertTrue(dq.isEmpty());
    }

    @Test
    void testPopLeftOnEmptyThrows() {
        Dqueue<Integer> dq = new Dqueue<>();
        assertThrows(RuntimeException.class, dq::popLeft);
    }

    @Test
    void testPopRightOnEmptyThrows() {
        Dqueue<Integer> dq = new Dqueue<>();
        assertThrows(RuntimeException.class, dq::popRight);
    }
}
