package org.pdas.hashing;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
    /*
    * Given a number A, find if it is COLORFUL number or not.
    * If number A is a COLORFUL number return 1 else, return 0.
    * What is a COLORFUL Number: A number can be broken into different consecutive sequence of digits.
    * The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
    * This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
    * */

    public static int isColorful(int A){
        String s = String.valueOf(A);
        Set<Long> productSet = new HashSet<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            long currProduct = 1;

            for (int j = i; j < n; j++) {
                int digit = s.charAt(j)-'0';
                currProduct *= digit;

                if (productSet.contains(currProduct)){
                    return 0;
                }

                productSet.add(currProduct);

            }


        }
        return 1;
    }

    public static void main(String[] args) {
        int A = 236;
        System.out.println(isColorful(A));
    }


}
