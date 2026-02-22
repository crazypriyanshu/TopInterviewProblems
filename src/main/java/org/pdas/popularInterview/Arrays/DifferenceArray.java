package org.pdas.popularInterview.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferenceArray {
    /*
    * Problem statement: We have been given a 2D array: B and number of beggars A
    * B represents ArrayList<Integer> - leftRange, rightRange, donationAmount
    * find the total amount each beggar can have on end of day
    * */

    private static int[] findAmountEachBeggarHasEndOfDay(int numberOfBeggars, ArrayList<ArrayList<Integer>> devoteesList){
        if (numberOfBeggars == 0 || devoteesList == null) return new int[]{};

        int[] pots = new int[numberOfBeggars+1];
        for (ArrayList<Integer> devotee: devoteesList){
            int startIndex = devotee.get(0) -1; // making it 0 index
            int endIndex = devotee.get(1) -1; // making it 0 index
            int donationAmount = devotee.get(2);

            while (startIndex != endIndex+1){
                pots[startIndex] += donationAmount;
                startIndex++;
            }


        }
        return pots;
    }

    static int[] findBeggarAmountEfficient(int numberOfBeggars, ArrayList<ArrayList<Integer>> devoteesList){
        int[] pots = new int[numberOfBeggars+1];
        for (ArrayList<Integer> devotee: devoteesList){
            int startIndex = devotee.get(0) -1; // 0 based indexing
            int endIndex = devotee.get(1) -1;
            int amount = devotee.get(2);

            pots[startIndex] += amount;
            if (endIndex+1 < numberOfBeggars){
                pots[endIndex+1] -= amount;
            }

        }

        int currSum = 0;
        for (int i = 0; i < numberOfBeggars; i++) {
            currSum += pots[i];
            pots[i] = currSum;
        }
        return pots;
    }

    static ArrayList<Integer> row(int... values){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i: values){
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(row(1, 2, 10));
        B.add(row(2, 3, 20));
        B.add(row(2, 5, 25));
        int A = 5;
        int[] res = new int[A];
//        res = findAmountEachBeggarHasEndOfDay(A, B);
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i]);
//        }
        res = findBeggarAmountEfficient(A, B);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }


}
