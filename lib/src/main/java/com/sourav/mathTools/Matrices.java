package com.sourav.mathTools;

public class Matrices {

    public static Number[][] add(Number[][] ar1, Number[][] ar2) throws ArithmeticException {
        if (ar1.length != ar2.length || ar1[0].length != ar2[0].length) {
            throw new ArithmeticException("The size of matrices must be equal.");
        }
        Number[][] result = new Number[ar1.length][ar1[0].length];
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar1[0].length; j++) {
                double temp = ar1[i][j].doubleValue() + ar2[i][j].doubleValue();
                result[i][j] = castSmart(temp);
            }
        }
        return result;
    }

    public static Number[][] sub(Number[][] ar1, Number[][] ar2) throws ArithmeticException {
        if (ar1.length != ar2.length || ar1[0].length != ar2[0].length) {
            throw new ArithmeticException("The size of matrices must be equal.");
        }
        Number[][] result = new Number[ar1.length][ar1[0].length];
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar1[0].length; j++) {
                double temp = ar1[i][j].doubleValue() - ar2[i][j].doubleValue();
                result[i][j] = castSmart(temp);
            }
        }
        return result;
    }

    public static Number[][] mul(Number[][] ar1, Number[][] ar2) throws ArithmeticException {
        if (ar1[0].length != ar2.length) {
            throw new ArithmeticException(
                    "Number of columns in the first matrix must equal number of rows in the second.");
        }
        int rows = ar1.length, cols = ar2[0].length, shared = ar1[0].length;
        Number[][] result = new Number[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double temp = 0;
                for (int k = 0; k < shared; k++) {
                    temp += ar1[i][k].doubleValue() * ar2[k][j].doubleValue();
                }
                result[i][j] = castSmart(temp);
            }
        }
        return result;
    }

    public static Number[][] add(Number[][]... inputs) {
        if (inputs.length <= 1)
            throw new IllegalArgumentException("Insufficient arguments");
        Number[][] result = inputs[0];
        for (int i = 1; i < inputs.length; i++) {
            result = add(result, inputs[i]);
        }
        return result;
    }

    public static Number[][] mul(Number[][]... inputs) {
        if (inputs.length <= 1)
            throw new IllegalArgumentException("Insufficient arguments");
        Number[][] result = inputs[0];
        for (int i = 1; i < inputs.length; i++) {
            result = mul(result, inputs[i]);
        }
        return result;
    }

    //private methods
    
    private static Number castSmart(double value) {
        if (value % 1 == 0) {
            if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
                return (int) value;
            } else if (value >= Long.MIN_VALUE && value <= Long.MAX_VALUE) {
                return (long) value;
            }
        }
        return value;
    }
}