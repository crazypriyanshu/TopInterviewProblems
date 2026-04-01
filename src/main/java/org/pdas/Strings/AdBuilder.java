package org.pdas.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class AdBuilder {
    /**
     * Given a set of text in the form of paragraph : String[][] [["This", "is", "good"],["We", "should" , "test", "it"]]
     * You have been given a width w , within that width you have to arrange all the sentences of paragraph
     * You need to have a padding of "*".repeat(width)
     * Eg: String[][] [["This", "is", "good."],["We", "should" , "test", "it", "all"]]
     * width = 10
     * Then output it like :
     *                      **********
     *                      * This is*
     *                      * good.  *
     *                      * We     *
     *                      * should *
     *                      * test it*
     *                      * all    *
     *                      **********
     * */
    public static String[] createAdTemplate(String[][] paragraph, int width){
        if(width < 3) return new String[]{"Invalid Width"};
        if (paragraph == null) return new String[]{"Invalid input"};

        ArrayList<String> res = new ArrayList<>();
        String border = "*".repeat(width);
        res.add(border);

        int numberOfLines = paragraph.length;
        int padding = width-2;

        for (String[] sentence: paragraph){
            StringBuilder currentLine = new StringBuilder();
            for (String word: sentence){
                currentLine.append(" "+word);
            }
            if (currentLine.length() < padding){
                addAValidLine(currentLine.toString(), width, res);
            } else{
                // break the current line
                // 2 * and 1 space
                int innerWidth = width-3;
                String textToBreak = currentLine.toString().trim();
                int index = 0;
                while (index < textToBreak.length()){
                    int end = Math.min(index+innerWidth, textToBreak.length());
                    String chunk = textToBreak.substring(index, end);
                    addAValidLine(chunk, width, res);
                    index += innerWidth;
                }

            }

        }
        res.add(border);

        return res.toArray(String[]::new);

    }

    private static void addAValidLine(String validInput, int width, ArrayList<String> res){
        StringBuffer sb = new StringBuffer();
        sb.append("*");
        if (validInput.length() <= width-3){
            boolean isEndOfLine = (width-3 != validInput.length());
            sb.append(" "+validInput+(isEndOfLine ? ".":"")+" ".repeat(isEndOfLine ? width-4-validInput.length() :width-3-validInput.length())+"*");

        }
        res.add(sb.toString());
    }

    public static void main(String[] args) {
        String[][] para = {{"I", "am", "a", "good"},{"This ", "is", "amazing"}, {"Golf ", "is", "amazing!", "self", "triumph", "sole"}};
        int width = 15;
        Arrays.stream(createAdTemplate(para, width)).forEach(System.out::println);


    }
}
