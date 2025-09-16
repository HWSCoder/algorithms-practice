package com.hws.algorithms.chapter1;

import com.hws.algorithms.commom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Exercise1338Josephus {

    /**
     * Solve the Josephus problem (0-indexed).
     *
     * @param n total number of people in the circle
     * @param m every m-th person will be eliminated
     * @return the position of the last remaining person (0-indexed)
     */
    public static int josephus(int n, int m) {
        // TODO: implement your solution here
        Queue<Integer> queue= new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            int i = queue.poll();
            count++;
            if (count < m) {
                queue.add(i);
            } else {
                count = 0;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        // Example 1
        int survivor1 = josephus(7, 2);
        System.out.println("Survivor position (n=7, m=2): " + survivor1);
        // Expected (0-indexed): 6

        // Example 2
        int survivor2 = josephus(10, 3);
        System.out.println("Survivor position (n=10, m=3): " + survivor2);
        // Expected (0-indexed): 3

        // Example 3
        int survivor3 = josephus(3, 5);
        System.out.println("Survivor position (n=3, m=5): " + survivor3);
        // Expected (0-indexed): 0
    }
}
