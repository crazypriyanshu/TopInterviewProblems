package org.pdas.GoToBasics;

public class StarPatternGenerator {
    private static int size = 0;
    private static int centre = 0;
    public StarPatternGenerator(int size){
        if (size < 0){
            throw new IllegalArgumentException("size must be greater thn 0");
        }
        this.size = size;
        this.centre = size/2;
    }

    public int getSize() {
        return size;
    }

    public int getCentre() {
        return centre;
    }

    private static boolean printRectangularStar(int i, int j) {
        boolean isBorder = (i == 0 || i == size-1 || j == 0 || j == size - 1);
        boolean isDiagonal = (i == j || i+j == size-1);
        boolean isCenter = false;
        if (size % 2 == 0){
            isCenter = (i == centre || j == centre);
        } else {
            isCenter = (i == centre || j == centre-1 || i == centre-1 || j == centre);
        }
        return isBorder || isCenter || isDiagonal;

    }

    public static void printPattern(){
        System.out.println("\n Printing pattern for -- "+size+ " ----");
        for (int i = 0; i< size-1; i++){
            for (int j = 0; j < size-1; j++){
                if (printRectangularStar(i,j)){
                    System.out.print("* ");
                } else{
                    System.out.print("  ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StarPatternGenerator starPatternGenerator = new StarPatternGenerator(6);
//        printPattern();
        new StarPatternGenerator(7).printPattern();
    }
}
