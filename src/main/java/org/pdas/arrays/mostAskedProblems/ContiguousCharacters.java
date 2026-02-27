package org.pdas.arrays.mostAskedProblems;

public class ContiguousCharacters {
    /**
     * Given a string A. we need to find out how many contiguous characters 'c' can we get,
     * if we are allowed to do changes at most B times.
     * change is defined as changing the character at a given index in String
     * */

    private static int findMaxContiguous(String A, int B, char C){
        if (B > A.length()) return A.length();

        int n = A.length();
        int left = 0;
        int maxLen = 0;
        int changesUsed = 0;

        for (int right = 0; right < n; right++){
            if (A.charAt(right) != C){
                changesUsed++;
            } while (changesUsed > B){
                if (A.charAt(left) != C){
                    changesUsed--;
                }
                left++;
            }
            maxLen = Math.min(maxLen, (right - left +1));
        }

        return maxLen;
    }
}
