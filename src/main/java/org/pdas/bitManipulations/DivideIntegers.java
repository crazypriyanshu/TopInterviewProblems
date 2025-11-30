package org.pdas.bitManipulations;
/**
 * Problem statement : We need to divide 2 integers without using mul, div or mod
 * Divide two integers without using multiplication, division and mod operator.
 * Return the floor of the result of the division.
 * Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
 * NOTE: INT_MAX = 2^31 - 1
 */

public class DivideIntegers {
    public static void main(String[] args) {
        int A, B;
        System.out.println(divideBetterWay(2147483647, 9));

    }

    public static int divideNumbers(int A, int B) {
        int count = 0;

        while (A >= B) {
            if (A == 0 || B == 0) {
                return  count;
            }
            A = A - B;
            count++;
        }
        return count;
    }

    public static int divideBetterWay(int A, int B) {
        int sign = (A < 0)^(B < 0)?-1:1; // if anyone is -ve then -1 else if both are negative and bot are positive then 1
        if (B == 1) {
            return A; // Edge case stating, if B is ever 1 then we save the number of subtraction and just return A
        }
        if (A == Integer.MIN_VALUE){
            A = Integer.MAX_VALUE;
        }

        long x = Math.abs(A);
        long y = Math.abs(B);
        int quotient = 0;

        while (x >= y) {
            x = x - y;
            quotient++;
        }
        return (int) quotient * sign;

    }


}
