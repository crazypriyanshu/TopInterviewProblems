package org.pdas.test;

import java.util.Arrays;
import java.util.HashMap;

public class JP {
    private static int[] twoSum(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int compliment = target-arr[i];
            if (map.containsKey(compliment)){
                return new int[] {map.get(compliment), i};
            }
            map.putIfAbsent(arr[i], i);
        }
        return new int[0];
    }

    private static int countDuplicatesInArray(int[] arr){
        HashMap<Integer, Integer> freqCounter = new HashMap<>();
        int duplicateCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int currElem = arr[i];
            freqCounter.put(currElem, freqCounter.getOrDefault(currElem,0)+1);
            if (freqCounter.get(currElem) == 2){
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
    public static void main(String[] args) {
        int[] arr = {90, 2, 7, 20, 7, 2, 90, 90};
        int target = 25;
        Arrays.stream(twoSum(arr, target)).forEach(System.out::println);
        System.out.println(countDuplicatesInArray(arr));

    }
}