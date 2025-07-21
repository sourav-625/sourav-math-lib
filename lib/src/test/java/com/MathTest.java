package com;

import org.junit.jupiter.api.Test;

import com.sourav.mathTools.BasicOp;

import static org.junit.jupiter.api.Assertions.*;

public class MathTest {
    @Test
    void Tester() {
        {
            int a = 3;
            int b = 4;
            double c = 4.5;
            double d = 7.5;
            assertEquals(19.0, BasicOp.add(a, b, c, d));
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
    }

}
