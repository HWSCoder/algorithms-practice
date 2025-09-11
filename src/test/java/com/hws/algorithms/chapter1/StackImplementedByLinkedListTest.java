package com.hws.algorithms.chapter1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackImplementedByLinkedListTest {

    @Test
    void testPushAndSize() {
        StackImplementedByLinkedList<Integer> stack = new StackImplementedByLinkedList<>();
        assertEquals(0, stack.size());

        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.size());
    }

    @Test
    void testPopReturnsCorrectItem() {
        StackImplementedByLinkedList<String> stack = new StackImplementedByLinkedList<>();
        stack.push("A");
        stack.push("B");

        String popped = stack.pop();
        assertEquals("B", popped);
        assertEquals(1, stack.size());
    }

    @Test
    void testPopUntilEmpty() {
        StackImplementedByLinkedList<String> stack = new StackImplementedByLinkedList<>();
        stack.push("1");
        stack.push("2");

        assertEquals("2", stack.pop());
        assertEquals("1", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void testPopOnEmptyStackThrowsException() {
        StackImplementedByLinkedList<Integer> stack = new StackImplementedByLinkedList<>();
        assertThrows(RuntimeException.class, stack::pop);
    }

    @Test
    void testPeekReturnsTopElement() {
        StackImplementedByLinkedList<Integer> stack = new StackImplementedByLinkedList<>();
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());  // 栈顶应该是 20
        assertEquals(2, stack.size());   // peek 不会改变栈的大小
    }

    @Test
    void testPeekAfterPop() {
        StackImplementedByLinkedList<String> stack = new StackImplementedByLinkedList<>();
        stack.push("A");
        stack.push("B");
        stack.pop(); // 弹出 "B"

        assertEquals("A", stack.peek()); // peek 应该返回 "A"
        assertEquals(1, stack.size());   // 大小不变
    }

    @Test
    void testPeekOnEmptyStackThrowsException() {
        StackImplementedByLinkedList<Double> stack = new StackImplementedByLinkedList<>();
        assertThrows(RuntimeException.class, stack::peek);
    }
}
