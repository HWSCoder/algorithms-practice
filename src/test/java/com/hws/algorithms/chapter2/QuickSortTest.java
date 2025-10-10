package com.hws.algorithms.chapter2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private <T extends Comparable<T>> void assertQuickSort(T[] input, T[] expected) {
        T[] copy = Arrays.copyOf(input, input.length);
        QuickSort<T> sorter = new QuickSort<>();
        sorter.sort(copy);
        assertArrayEquals(expected, copy);
    }

    @Test
    void testAlreadySorted() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        assertQuickSort(input, expected);
    }

    @Test
    void testReverseSorted() {
        Integer[] input = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        assertQuickSort(input, expected);
    }

    @Test
    void testRandomArray() {
        Integer[] input = {7, 2, 9, 1, 5};
        Integer[] expected = {1, 2, 5, 7, 9};
        assertQuickSort(input, expected);
    }

    @Test
    void testWithDuplicates() {
        Integer[] input = {3, 1, 2, 3, 1};
        Integer[] expected = {1, 1, 2, 3, 3};
        assertQuickSort(input, expected);
    }

    @Test
    void testEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        assertQuickSort(input, expected);
    }

    @Test
    void testLargeRandomArray() {
        Random random = new Random();
        Integer[] input = new Integer[1000];
        for (int i = 0; i < input.length; i++) {
            input[i] = random.nextInt(10000);
        }
        Integer[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);

        assertQuickSort(input, expected);
    }
}
