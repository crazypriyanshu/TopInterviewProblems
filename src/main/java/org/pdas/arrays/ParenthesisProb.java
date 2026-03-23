package org.pdas.arrays;

import java.util.Stack;

public class ParenthesisProb {
    /**
     * Given string S, find if the brackets are in correct order
     * */
    private static boolean isSafe(String s){
        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()){
            if (c == '('){
                st.push(c);
            }
            if (st.isEmpty() && c == ')'){
                return false;
            } else if (c == ')' && !st.isEmpty()){
                st.pop();
            }
        }
        return st.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String s = "((io(jo)))";
        System.out.println(isSafe(s));
    }
}
