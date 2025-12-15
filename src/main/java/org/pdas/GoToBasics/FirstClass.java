package org.pdas.GoToBasics;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FirstClass {
    public static void main(String[] args) {
        //System.out.println(Arrays.stream(args).collect(Collectors.joining(" #"))+ " are the arguments");
        String[] pearl= {"chal", "na", "simple", "tha", "na", "ga", "ga"};
        printTest(pearl);

        //System.out.println("this is printed from main class which has a return type of void, \nthis is public method inside FirstClass\n meaning anyone who calls this class can access it and it takes array of strings as input which is nothing but the code inside");
    }

    static void printTest(String[] strings){
//        System.out.println(" -- "+ Arrays.stream(strings).toList());
//        System.out.println(" -- "+ Arrays.stream(strings).map(each -> each.length()).map(each -> Math.pow(each.doubleValue(), 2.0)).toList());
//        System.out.println(" -- "+ Arrays.stream(strings).distinct().collect(Collectors.joining("#")));
//        System.out.println(" == "+ Arrays.stream(strings).filter(each -> each.length() > 3).toList() +" only these have length greater than 3");
//        System.out.println("-- "+ Arrays.stream(strings).filter(each -> each.length() >= 3).peek(each -> each.substring(0, 2)).toList());
        //System.out.println(" == "+ Arrays.stream(strings).peek(each -> updated(each)).collect(Collectors.joining("~~")));
//        forLoopTest();
//        printRectangle();
//        printRectangleOutline(5);
//        rectangleWithCross(9);
        rectangleWithStar(15);


    }

    public static void updated(String string){
        StringBuilder sb = new StringBuilder();
        System.out.println(" adding "+string.substring(0).lastIndexOf("simp"));
        sb.append(string.substring(0,2).lastIndexOf(string));
        System.out.println(sb.toString());
    }

    public static void forLoopTest(){
        for (int i=0; i< 5; i++){
            System.out.print("i="+i);
            for (int j = 0; j < i; j++){
                System.out.print(" j="+j);
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printRectangle(){
        for (int i = 0; i < 5; i++){
            for (int j =0; j < 5; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printRectangleOutline(int n){
        for (int i = 0; i < n; i++){
            for (int j =0; j < n; j++){
//                System.out.print(" ("+i+","+j+") ");
                if ((i == 0 || i == n-1) || (j == 0 || j== n-1)){
                    System.out.print("* ");
//                } else if (i == j) {
//                    System.out.print("* ");
//                } else if (i+j == n) {
//                    System.out.print("* ");

                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
    }

    public static void rectangleWithCross(int n){
        for (int i=0; i < n; i++){
            for (int j=0; j< n; j++){
                if ((i == 0 || i == n-1) || (j == 0 || j == n-1)){
                    System.out.print("* ");
                } else if (i == j) {
                    System.out.print("* ");
                } else if (i+j == n-1) {
                    System.out.print("* ");
                } else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    public static void rectangleWithStar(int n){
        for (int i=0; i < n; i++){
            for (int j=0; j< n; j++){
                if ((i == 0 || i == n-1) || (j == 0 || j == n-1)){
                    System.out.print("* ");
                } else if (i == j) {
                    System.out.print("* ");
                } else if (i+j == n-1) {
                    System.out.print("* ");
                } else if (i == n/2 || j == n/2) {
                    System.out.print("* ");
                } else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}
