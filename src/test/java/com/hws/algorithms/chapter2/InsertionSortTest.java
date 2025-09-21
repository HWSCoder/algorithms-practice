package com.hws.algorithms.chapter2;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void testAlreadySorted() {
        Integer[] input = {1, 2, 3, 4, 5};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(input);
        assertTrue(sorter.isSorted(input));
    }

    @Test
    void testReverseSorted() {
        Integer[] input = {5, 4, 3, 2, 1};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(input);
        assertTrue(sorter.isSorted(input));
    }

    @Test
    void testRandomArray() {
        Integer[] input = {7, 2, 9, 1, 5};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(input);
        assertTrue(sorter.isSorted(input));
    }

    @Test
    void testWithDuplicates() {
        Integer[] input = {3, 1, 2, 3, 1};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(input);
        assertTrue(sorter.isSorted(input));
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 3}, input);
    }

    @Test
    void testEmptyArray() {
        Integer[] input = {};
        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(input);
        assertTrue(sorter.isSorted(input));
    }

    @Test
    void testLargeRandomArray() {
        Random random = new Random();
        Integer[] input = new Integer[1000];
        for (int i = 0; i < input.length; i++) {
            input[i] = random.nextInt(10000);
        }

        InsertionSort<Integer> sorter = new InsertionSort<>();
        sorter.sort(input);

        assertTrue(sorter.isSorted(input), "Array should be sorted");
    }
}
