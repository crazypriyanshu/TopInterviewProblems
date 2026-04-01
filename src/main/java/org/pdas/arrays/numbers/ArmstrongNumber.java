package org.pdas.arrays.numbers;

public class ArmstrongNumber {
    /**
     *  Print all Armstrong number between 1 to 1000.
     * An Armstrong number is a n-digit number that is equal to the sum of nth
     * power of its digits. For example,
     * 6 = 61 = 6
     * 371 = 33 + 73 + 13 = 371
     * */
    private static boolean isArmstrongNumber(int num){
        int originalNumber = num;

        int digitInNum = 0;
        int temp = num;
        while (temp > 0){
            digitInNum++;
            temp = temp/10;
        }

        int sum = 0;
        temp = originalNumber;

        while (temp > 0){
            int digit = temp%10;
            int powerOfDigit = 1;
            for (int i = 0; i < digitInNum; i++) {
                powerOfDigit *= digit;
            }

            sum += powerOfDigit;
            temp = temp/10;
        }
        return sum == originalNumber;

            

    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if (isArmstrongNumber(i)){
                System.out.println(" "+ i);
            }

        }
    }

}
