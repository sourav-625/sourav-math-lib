package com;

import org.junit.jupiter.api.Test;

import com.sourav.mathTools.BasicOp;
import com.sourav.mathTools.Matrices;

import static org.junit.jupiter.api.Assertions.*;

public class Tester {
    @Test
    void tester() {
        {
            int a = 3;
            int b = 4;
            double c = 4.5;
            double d = 7.5;
            int e = 0;
            assertEquals(19, BasicOp.add(a, b, c, d));
            assertThrows(ArithmeticException.class, () -> BasicOp.div(a, e));
        }
        {
            int a = 8;
            long b = 4;
            int c = 16;
            assertEquals(4, BasicOp.gcd(a, b, c));
        }
        {
            long a = 24;
            long b = 36;
            assertEquals(12, BasicOp.gcd(a, b));
        }
        {
            long a = 4;
            long b = 6;
            assertEquals(12, BasicOp.lcm(a, b));
        }
        {
            Number[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            Number[][] id = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
            };
            Number[][] r = {
                {2, 2, 3},
                {4, 6, 6},
                {7, 8, 10}
            };
            assertArrayEquals(r, Matrices.add(mat, id));
        }
    }

}
