package org.pdas.arrays.numbers;

public class PrimeNumbers {
    /**
     * Given a range find all the prime numbers, eg 500 - print all primes between 1 - 500
     *
     * */
    private static void primeNumbers(int range){
        boolean isNotPrime[] = new boolean[range+1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int num = 2; num*num <= range ; num++) {
            if (!isNotPrime[num]){
                for (int i = num*num; i < range; i += num) {
                    isNotPrime[i] = true;
                }
            }
        }
        System.out.println("Prime numbers :");
        for (int i = 2; i < range; i++) {
            if (!isNotPrime[i]){
                System.out.println(i+ " ");
            }
        }
    }

    public static void main(String[] args) {
        primeNumbers(500);
    }
}
