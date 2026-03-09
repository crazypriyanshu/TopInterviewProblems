package org.pdas.stacks;

import java.util.Stack;

public class ValidParenthesis {
    /**
     * You are given a String, you have to check if that string has valid parenthesis
     * Eg. - s = "[{(}]" ans: false - not a valid parenthesis, because '(' is not closed
     * */
    private static boolean isValidParenthesis(String s){
        if (s == null || s.isEmpty()) return false;
        Stack<Character> stack = new Stack<>();

        for (char ch: s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else {
                if (!stack.isEmpty()){
                    char top = stack.pop();
                    if ( (ch == ')' && top == '(' )|| ( (ch == '}' && top == '{') )|| ((ch == ']' && top == '['))){
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "[]{{(())}}";
        System.out.println(isValidParenthesis(s));
    }
}
