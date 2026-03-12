package org.pdas.arrays;

public class SearchInSortedMatrix {
    public static int search(int[][] A, int B) {
        int rows = A.length;
        int cols = A[0].length;
        int left = 0;
        int right = cols-1;
        int minCost = Integer.MAX_VALUE;

        while(left < rows && right >= 0){
            if(A[left][right] == B){
                System.out.print("Found"+left+" "+right);
                int ans = ((left+1)*1009)+(right+1);
                minCost = Math.min(ans, minCost);

            } else if(A[left][right] > B){
                right--;
            } else{
                left++;
            }
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int B = 10;
        System.out.println(search(matrix, B));
    }

}
