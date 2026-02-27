package org.pdas.arrays.mostAskedProblems;

public class AllocateBooks {
    /**
     *
     * @param A representing the array of pages in i-th book
     * @param B representing number of students
     * Given an array A where A[i] represents number of pages in a book and int B - representing number of students
     * We have to allocate books to B students so that max number of pages allocated should be min
     * Each student has to be allocated at least 1 book
     * Allotment should be in contiguous order
     * Calculate the min possible number
     *
     * */

    private static int allocateBooks(int[] A, int B){
        if (B > A.length) return -1;

        int low = 0;
        int high = 0;

        // we have to allocate  the pages of book so that it the books (& NOT the pages) are distributed evenly
        // we have to maximize or minimize the number of pages each student read

        // B student can read x pages or 1 student can read all the pages
        for (int pages: A){
            low = Math.max(pages, low);
            high += pages;
        }

        // we found 2 limits - low - max of pages which has only 1 book
        // high - total sum of all the pages
        int result = -1;


        while (low <= high){
            int mid = low + (high-low)/2;
            if (isFeasible(A, B, mid)){
                result = mid;
                high = mid-1;
                // trying with higher value
            } else {
                low = mid+1;
            }

        }
        return result;
    }

    /**
     * Method is responsible to find out if the given limit, can we allocate the book to all the student
     * Assumption is min number of student required is 1 and then we loop through array and see if
     * */
    private static boolean isFeasible(int[] A, int numOfStudent, int limit){
        int studentRequired = 1;
        int currSum = 0;
        for (int pages: A){
            if(currSum+pages > limit){
                studentRequired++;
                currSum = pages;
                if (studentRequired > numOfStudent) return false;
            }
            currSum += pages;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] bookPages = {10, 20, 30, 40};
        int student = 3;
        System.out.println("ans: "+allocateBooks(bookPages, student));
    }


}
