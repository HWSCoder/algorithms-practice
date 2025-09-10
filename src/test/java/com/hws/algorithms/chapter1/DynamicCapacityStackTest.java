package com.hws.algorithms.chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicCapacityStackTest {
    @Test
    public void shouldPushAndPopCorrectly() {
        DynamicCapacityStack<String> dynamicCapacityStack = new DynamicCapacityStack<>();
        dynamicCapacityStack.push("1");
        dynamicCapacityStack.push("2");
        dynamicCapacityStack.push("3");

        assertEquals("3", dynamicCapacityStack.pop());
        assertEquals("2", dynamicCapacityStack.pop());
        assertEquals("1", dynamicCapacityStack.pop());
    }
}
