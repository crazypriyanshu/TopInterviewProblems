package org.pdas.Strings;

public class ReverseWordsInString {
    /**
     * Given a list of String, you have to reverse it
     * Eg String words = "I love dancing";
     * Output : "dancing love I";
     * */
//    private static String reverseWords(String words){
//        if (words == null || words.length() == 0) return "";
//        if (words.length() == 1) return words;
//        int n = words.length();
//        StringBuilder sb = new StringBuilder();
//
//        int start = n-1;
//
//        while (start >= 0){
//            while (start >= 0 && words.charAt(start) == ' ') start--;
//            if (start < 0) break;
//            int end = start+1;
//            while (start >= 0 && words.charAt(start) != ' ') start--;
//            if (sb.length() > 0) sb.append(" ");
//            sb.append(words.substring(start+1, end));
//        }
//
//        return sb.toString();
//    }

    public static String reverseWords(String s) {
        if (s == null) return null;

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = n - 1;

        while (i >= 0) {
            // 1. Skip spaces to find the end of the next word
            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break; // All words processed

            // 2. Mark the end of the word
            int end = i + 1;

            // 3. Move i back to find the start of the word
            while (i >= 0 && s.charAt(i) != ' ') i--;

            // 4. Extract and append
            if (sb.length() > 0) sb.append(" "); // Add space between words
            sb.append(s.substring(i + 1, end));
        }

        return sb.toString();
    }

    private static void reverse(char[] chars, int start, int end){
        while (start < end){
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }

    }


    public static void main(String[] args) {
        String words = "I love dancing";
        String A = "i am   ";
        System.out.println(reverseWords(A));
    }
}
