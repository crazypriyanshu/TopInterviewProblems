package org.pdas.arrays.numbers;

public class PerfectNumber {
    /**
     * find the perfect numbers between 1 to 100,
     * Perfect number is a positive integer which is equal to the sum of its
     * proper positive divisors.
     * For example: 6 is the first perfect number
     * Proper divisors of 6 are 1, 2, 3
     * Sum of its proper divisors = 1 + 2 + 3 = 6.
     * Hence 6 is a perfect number, what is the best way to find
     * */
    private static boolean isPerfect(int num){
        if(num <= 1) return false;

        int sum = 1;
        for (int i = 2; i *i< num; i++) {
            if (num % i == 0){
                sum += i;
                if (i * i != num){
                    sum += num/i;
                }
            }

        }
        return num == sum;
    }

    public static void main(String[] args) {
        int num = 6;
        for (int i = 0; i < 100; i++) {
            if (isPerfect(i)){
                System.out.println("Perfect number: "+i);
            }
        }
    }
}
