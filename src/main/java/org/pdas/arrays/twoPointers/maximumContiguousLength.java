package org.pdas.arrays.twoPointers;

public class maximumContiguousLength {
    private static int maxLen(String s, int maxChangesAllowed, char ch){
        int left = 0;
        int right = 0;
        int changesDone = 0;
        int n = s.length();
        int maxLength = 0;

        while (right < n){
            if (ch != s.charAt(right)){
                changesDone++;
            }
            while (changesDone > maxChangesAllowed){
                left++;
                if (ch != s.charAt(left)){
                    changesDone--;
                }
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;


    }

    public static void main(String[] args) {
        String s = "alpha";
        char ch = 'p';
        int B = 3;
        System.out.println(maxLen(s, B, ch));
    }

}
