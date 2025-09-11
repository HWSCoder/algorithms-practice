package com.hws.algorithms.chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackImplementedByLinkedListTest {

    @Test
    public void testPushAndSize() {
        StackImplementedByLinkedList<Integer> stack = new StackImplementedByLinkedList<>();
        assertEquals(0, stack.size());

        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.size());
    }

    @Test
    public void testPopReturnsCorrectItem() {
        StackImplementedByLinkedList<String> stack = new StackImplementedByLinkedList<>();
        stack.push("A");
        stack.push("B");

        String popped = stack.pop();
        assertEquals("B", popped);
        assertEquals(1, stack.size());
    }

    @Test
    public void testPopUntilEmpty() {
        StackImplementedByLinkedList<String> stack = new StackImplementedByLinkedList<>();
        stack.push("1");
        stack.push("2");

        assertEquals("2", stack.pop());
        assertEquals("1", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPopOnEmptyStackThrowsException() {
        StackImplementedByLinkedList<Integer> stack = new StackImplementedByLinkedList<>();
        assertThrows(RuntimeException.class, stack::pop);
    }
}

