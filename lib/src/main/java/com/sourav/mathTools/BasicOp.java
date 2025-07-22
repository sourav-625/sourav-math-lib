package com.sourav.mathTools;

public class BasicOp {

    public static Number add(Number... inputs) {
        if (inputs.length < 1)
            throw new IllegalArgumentException("Insufficient arguments");
        Number sum = 0;
        for (Number e : inputs) {
            sum = sum.doubleValue() + e.doubleValue();
            sum = sum.doubleValue() % 1 == 0 ? (long) sum : sum;
        }
        return sum;
    }

    public static Number sub(Number a, Number b) {
        Number diff = a.doubleValue() - b.doubleValue();
        diff = diff.doubleValue() % 1 == 0 ? (long) diff : diff;
        return diff;
    }

    public static Number mul(Number... inputs) {
        if (inputs.length < 1)
            throw new IllegalArgumentException("Insufficient argumnets");
        Number product = 1;
        for (Number num : inputs) {
            product = product.doubleValue() * num.doubleValue();
            product = product.doubleValue() % 1 == 0 ? (long) product : product;
        }
        return product;
    }

    public static Number div(Number a, Number b) {
        if (b.doubleValue() == 0)
            throw new ArithmeticException("Attempt to divide by zero");
        Number quo = a.doubleValue() / b.doubleValue();
        quo = quo.doubleValue() % 1 == 0 ? (long) quo : quo;
        return quo;
    }

    public static long gcd(long... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number required");
        }
        long result = Math.abs(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            long n = numbers[i];
            result = gcd(result, Math.abs(n));
        }
        return result;
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(long... inputs) {
        Number[] ip = new Number[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            ip[i] = inputs[i];
        }
        return mul(ip).longValue() / gcd(inputs);
    }

}
