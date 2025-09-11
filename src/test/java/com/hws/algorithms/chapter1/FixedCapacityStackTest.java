package com.hws.algorithms.chapter1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackTest {

    @Test
    void pushAndSize() {
        FixedCapacityStack<Integer> s = new FixedCapacityStack<>(3);
        assertEquals(0, s.size());
        s.push(1);
        s.push(2);
        assertEquals(2, s.size());
    }

    @Test
    void popOrderAndSize() {
        FixedCapacityStack<String> s = new FixedCapacityStack<>(3);
        s.push("A");
        s.push("B");
        assertEquals("B", s.pop());
        assertEquals("A", s.pop());
        assertEquals(0, s.size());
    }

    @Test
    void popEmptyThrows() {
        FixedCapacityStack<Integer> s = new FixedCapacityStack<>(1);
        assertThrows(RuntimeException.class, s::pop);
    }

    @Test
    void pushOverflowThrows() {
        FixedCapacityStack<Integer> s = new FixedCapacityStack<>(1);
        s.push(42);
        assertThrows(RuntimeException.class, () -> s.push(99));
    }
}
