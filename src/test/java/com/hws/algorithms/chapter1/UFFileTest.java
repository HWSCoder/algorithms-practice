package com.hws.algorithms.chapter1;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UFFileTest {

    @Test
    void testTinyUFWithQuickFind() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/test/resources/tinyUF.txt"));

        int n = scanner.nextInt();
        QuickFindUF uf = new QuickFindUF(n);

        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            uf.union(p, q);
        }

        // tinyUF.txt should result in 2 components
        assertEquals(2, uf.count());
    }

    @Test
    void testMediumUFWithQuickFind() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/test/resources/mediumUF.txt"));

        int n = scanner.nextInt();
        QuickFindUF uf = new QuickFindUF(n);

        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            uf.union(p, q);
        }

        // tinyUF.txt should result in 2 components
        assertEquals(3, uf.count());
    }
    @Test
    void testLargeUFWithQuickFind() throws FileNotFoundException {
        File file = new File("download large file from website and save to local");
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        QuickFindUF uf = new QuickFindUF(n);

        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            uf.union(p, q);
        }

        // tinyUF.txt should result in 2 components
        assertEquals(6, uf.count());
    }
}
