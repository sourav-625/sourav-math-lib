package com.sourav.mathTools;

public class BasicOp {

    public static Number add(Number... inputs) {
        if (inputs.length < 1)
            throw new IllegalArgumentException("Insufficient arguments");
        double sum = 0;
        for (Number e : inputs) {
            sum += e.doubleValue();
        }
        if (sum % 1 == 0) {
            if (sum >= Integer.MIN_VALUE && sum <= Integer.MAX_VALUE) {
                return (int) sum;
            } else if (sum >= Long.MIN_VALUE && sum <= Long.MAX_VALUE) {
                return (long) sum;
            }
        }
        return sum;
    }

    public static Number sub(Number a, Number b) {
        double diff = a.doubleValue() - b.doubleValue();
        if (diff % 1 == 0) {
            if (diff >= Integer.MIN_VALUE && diff <= Integer.MAX_VALUE) {
                return (int) diff;
            } else if (diff >= Long.MIN_VALUE && diff <= Long.MAX_VALUE) {
                return (long) diff;
            }
        }
        return diff;
    }

    public static Number mul(Number... inputs) {
        if (inputs.length < 1)
            throw new IllegalArgumentException("Insufficient argumnets");
        double product = 1;
        for (Number num : inputs) {
            product *= num.doubleValue();
        }
        if (product % 1 == 0) {
            if (product >= Integer.MIN_VALUE && product <= Integer.MAX_VALUE) {
                return (int) product;
            } else if (product >= Long.MIN_VALUE && product <= Long.MAX_VALUE) {
                return (long) product;
            }
        }
        return product;
    }

    public static Number div(Number a, Number b) {
        if (b.doubleValue() == 0)
            throw new ArithmeticException("Attempt to divide by zero");
        double quo = a.doubleValue() / b.doubleValue();
        if (quo % 1 == 0) {
            if (quo >= Integer.MIN_VALUE && quo <= Integer.MAX_VALUE) {
                return (int) quo;
            } else if (quo >= Long.MIN_VALUE && quo <= Long.MAX_VALUE) {
                return (long) quo;
            }
        }
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
