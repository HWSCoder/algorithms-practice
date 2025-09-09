package com.hws.algorithms.chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class FixedCapacityStackTest {
    @Test
    public void shouldPushAndPopCorrectly() {
        FixedCapacityStack<String> fixedCapacityStack = new FixedCapacityStack<>(3);
        fixedCapacityStack.push("1");
        fixedCapacityStack.push("2");
        fixedCapacityStack.push("3");

        assertEquals(3, fixedCapacityStack.size());
        assertEquals("3", fixedCapacityStack.pop());
        assertEquals("2", fixedCapacityStack.pop());
        assertEquals("1", fixedCapacityStack.pop());
        assertTrue(fixedCapacityStack.isEmpty());
    }
    @Test
    public void shouldThrowExceptionWhenPushTooManyItems() {
        FixedCapacityStack<String> fixedCapacityStack = new FixedCapacityStack<>(1);
        fixedCapacityStack.push("1");
        assertThrows(RuntimeException.class, () -> {
            fixedCapacityStack.push("2");
        });
    }
    @Test
    public void shouldThrowExceptionWhenPopEmptyStack() {
        FixedCapacityStack<String> fixedCapacityStack = new FixedCapacityStack<>(1);
        assertThrows(RuntimeException.class, fixedCapacityStack::pop);
    }
}
