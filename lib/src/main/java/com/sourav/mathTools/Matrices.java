package com.sourav.mathTools;

public class Matrices {

    public static Number[][] add(Number[][] ar1, Number[][] ar2) throws ArithmeticException {
        try {
            Number[][] sum = new Number[ar1.length][ar1[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] = ar1[i][j].doubleValue() + ar2[i][j].doubleValue();
                }
            }
            return sum;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArithmeticException("The size of matrices must be equal.");
        }
    }

    public static Number[][] sub(Number[][] ar1, Number[][] ar2) throws ArithmeticException {
        try {
            Number[][] sum = new Number[ar1.length][ar1[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] = ar1[i][j].doubleValue() - ar2[i][j].doubleValue();
                }
            }
            return sum;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArithmeticException("The size of matrices must be equal.");
        }
    }

    public static Number[][] mul(Number[][] ar1, Number[][] ar2) throws ArithmeticException {
        try {
            Number[][] product = new Number[ar1.length][ar2[0].length];
            for (int i = 0; i < ar1.length; i++) {
                for (int j = 0; j < ar2[0].length; j++) {
                    product[i][j] = 0;
                    for (int k = 0; k < ar2.length; k++) {
                        product[i][j] = product[i][j].doubleValue() + ar1[i][k].doubleValue() * ar2[k][j].doubleValue();
                    }
                }
            }
            return product;
        } catch (IndexOutOfBoundsException e) {
            throw new ArithmeticException(
                    "For multiplication of two consecutive matrices number of columns in first matrix should be equal to number rows in second.");
        }
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

}
