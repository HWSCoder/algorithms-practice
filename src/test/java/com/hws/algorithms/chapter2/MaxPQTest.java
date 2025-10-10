package com.hws.algorithms.chapter2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaxPQTest {

    @Test
    void testInsertAndDelMax() {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(5);
        pq.insert(1);
        pq.insert(8);
        pq.insert(3);
        pq.insert(9);

        assertEquals(5, pq.size());
        assertFalse(pq.isEmpty());

        // 验证从大到小输出
        assertEquals(9, pq.delMax());
        assertEquals(8, pq.delMax());
        assertEquals(5, pq.delMax());
        assertEquals(3, pq.delMax());
        assertEquals(1, pq.delMax());
        assertTrue(pq.isEmpty());
    }

    @Test
    void testDelMaxFromEmptyPQThrowsException() {
        MaxPQ<Integer> pq = new MaxPQ<>(5);
        assertThrows(RuntimeException.class, pq::delMax);
    }

    @Test
    void testSwimMaintainsHeapProperty() {
        MaxPQ<Integer> pq = new MaxPQ<>(5);
        pq.insert(1);
        pq.insert(5);
        pq.insert(3);
        pq.insert(4);
        pq.insert(2);

        // 删除最大值后剩余元素依然按堆序排列
        assertEquals(5, pq.delMax());
        assertEquals(4, pq.delMax());
        assertEquals(3, pq.delMax());
        assertEquals(2, pq.delMax());
        assertEquals(1, pq.delMax());
    }

    @Test
    void testSinkMaintainsHeapAfterDelMax() {
        MaxPQ<Integer> pq = new MaxPQ<>(6);
        pq.insert(10);
        pq.insert(8);
        pq.insert(9);
        pq.insert(3);
        pq.insert(7);
        pq.insert(6);

        assertEquals(10, pq.delMax());
        assertEquals(9, pq.delMax());
        assertEquals(8, pq.delMax());
        assertEquals(7, pq.delMax());
        assertEquals(6, pq.delMax());
        assertEquals(3, pq.delMax());
    }
}
