package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PasswordGeneratorUtility {
    /* idea is to we should be able to generate password which follows below conditions
    * Length = 8
    * At least 1 digit
    * At least 1 uppercase
    * No 2 consecutive same characters
    * */

    static List<String> passwordGenerator(int len, String chars, int limit){
        List<String> res = new ArrayList<>();
        generatePasswords(len, chars, new StringBuilder(), false, false,false, res,limit);
        return res;
    }

    static void generatePasswords(int len, String chars, StringBuilder path, boolean hasDigit, boolean hasUpper, boolean hasSpecial, List<String> result, int limit){
        // base case
        if (result.size() == limit){
            return;
        }
        int remaining = len - path.length();
        if (!hasDigit && remaining < 1) return;
        if (!hasUpper && remaining < 1) return;
        if (!hasSpecial && remaining < 1) return;

        if (path.length() == len){
            if (hasDigit && hasUpper && hasSpecial){
                result.add(path.toString());
            }
            return;
        }


        for (char c: chars.toCharArray()){
            if (path.length() > 0 && path.charAt(path.length()-1) == c){
                continue;
            }
            path.append(c);
            generatePasswords(len, chars, path, hasDigit || Character.isDigit(c), hasUpper || Character.isUpperCase(c), hasSpecial || !Character.isLetterOrDigit(c), result, limit);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        int len = 8;
        String chars = "01bagAEFlabd@!";
        long startTime = System.nanoTime();
        passwordGenerator(8, chars, 10).stream().forEach(System.out::println);
        System.out.println("Time taken: "+ (System.nanoTime()-startTime)/1000 + " micro secs");
    }
}
