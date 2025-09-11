package com.hws.algorithms.chapter1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DynamicCapacityStackTest {

    @Test
    void testPushAndPop() {
        DynamicCapacityStack<Integer> stack = new DynamicCapacityStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
    }
}
