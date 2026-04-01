package org.pdas.arrays.numbers;

public class StrongNumber {
    /**
     * Check the given number is Strong number or not.
     * Strong number is a special number whose sum of factorial of digits is equal
     * to the original number.
     * For example: 145 is strong number. Since, 1! + 4! + 5! = 145
     * */
    private static boolean isStrongNumber(int num){
        if (num < 0) return false;
        int f = num;

        // store all the factorials from 0- 9
        int[] factorials = new int[10];
        factorials[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorials[i] = factorials[i-1]*i;
        }
        int sum = 0;

        while (num > 0){
            int lastDigit = num%10;
            sum += factorials[lastDigit];
            num = num/10;
        }

        return f == sum;
    }

    public static void main(String[] args) {
        int num = 145;
        System.out.println(isStrongNumber(num));
    }
}
