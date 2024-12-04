package org.pdas.arrays;

public class BracketCharacterReplacer {
    public static String replaceCharacterInBracket(String input, char targetCharacter, char replacingCharacter){
        StringBuilder result = new StringBuilder();
        boolean inBracket = false;

        for (int i=0; i < input.length(); i++){
            char currPositionCharacter = input.charAt(i);
            if (currPositionCharacter == '['){
                inBracket = true;
                result.append(currPositionCharacter);
            } else if (currPositionCharacter == ']') {
                inBracket = false;
                result.append(currPositionCharacter);
            } else if (inBracket && currPositionCharacter == targetCharacter) {
                result.append(replacingCharacter);
            } else {
                result.append(currPositionCharacter);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello [a] world, [b] are good.";
        char target = 'a';
        char replaceWith = 'z';
        System.out.println(replaceCharacterInBracket(input, target, replaceWith));
    }
}
