package org.pdas.arrays.javaQ;

public class BookAllocation {
    // given an array of integers A of size N and integer B
    // the college library has N books the ith book has A[i] number of pages
    // you have to allocate books to B number of students so that max number of pages allocated to a student is minimum
    // a book can be allocated to exactly one student
    // each student has to be allocated at least one book
    // allotment should be contiguous order, for example: a student cannot be allocated book 1 and book 3 skipping book 2
    // calculate the return min possible number, return -1 if valid assignment is not possible

    public static int allocateBooks(int[] A, int B){
        int N = A.length;
        if(B > N){
            return -1;
        }
        // calculate the sum of all pages and find the maximum pages in a single book
        int totalPages = 0;
        int maxPages = 0;
        for(int pages: A){
            totalPages += pages;
            maxPages = Math.max(maxPages, pages);
        }

        int low = maxPages;
        int high = totalPages;
        int result = -1;
        while (high < low){
            int mid = low + (high - low)/2;
            if (canAllocate(A, B, mid)){
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return result;
    }

    public static boolean canAllocate(int[] A, int B, int maxPages){
        int studentCount = 1;
        int currentSum = 0;
        for (int i = 0; i < A.length; i++){
            currentSum += A[i];
            // if curr Sum exceeds max pages, allocate to next student
            if (currentSum > maxPages){
                studentCount++;
                currentSum = A[i];
                if (studentCount > B){
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] A = {12, 34, 67, 90};
        int B = 2;
        System.out.println(allocateBooks(A, B));


    }
}
