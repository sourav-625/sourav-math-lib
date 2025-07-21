package com.sourav.mathTools;

public class BasicOp {

    public static Number add(Number... inputs) {
        Number sum = 0;
        for (Number e : inputs) {
            sum = sum.doubleValue() + e.doubleValue();
        }
        return sum;
    }

    public static Number sub(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static Number mul(Number... inputs) {
        Number product = 1;
        for(Number num : inputs) {
            product = product.doubleValue() * num.doubleValue();
        }
        return product;
    }

    public static Number div(Number a, Number b) {
        if(b.doubleValue() == 0) throw new ArithmeticException("Attempt to divide by zero");
        return a.doubleValue() / b.doubleValue();
    }

    public static long gcd(Number... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number required");
        }
        long result = Math.abs(numbers[0].longValue());
        for (int i = 1; i < numbers.length; i++) {
            Number n = numbers[i];
            if (n instanceof Double || n instanceof Float) {
                throw new IllegalArgumentException("Decimal numbers not allowed: " + n);
            }
            result = gcd(result, Math.abs(n.longValue()));
        }
        return result;
    }

    public static long gcd(long a, long b) {
        while(b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
