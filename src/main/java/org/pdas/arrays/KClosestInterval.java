package org.pdas.arrays;

import java.util.PriorityQueue;

public class KClosestInterval {
    /**
     * Given a list of points, out k the closest points from origin
     * int[][] - [[3,2],[1,5],[-1, 2]]
     * k = 2
     * I have to find the k closest points
     * */
    public static int[][] kClosestPoints(int[][] points, int k){
        if (k > points.length) return new int[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> {
            int distanceA = a[0]*a[0] + a[1]*a[1];
            int distanceB = b[0]*b[0] + a[1]*a[1];
            return  (int) (Math.sqrt(distanceA) - Math.sqrt(distanceB));
        });

        for (int[] point: points){
            pq.offer(point);
            if (pq.size() > k){
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()){
            result[i++] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 2}, {-1, 3}, {2, 4}, {7,6}};
        int k = 3;
        var ans = kClosestPoints(points, k);
        for (int[] point: ans){
            System.out.println(point[0]+" : "+point[1]);
        }
    }
}
