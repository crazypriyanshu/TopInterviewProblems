package org.pdas.arrays;

import java.util.PriorityQueue;

// use heap based approach to find the kth largest effectively
public class kthLargestProblem {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i: nums){
            heap.add(i);
            if (heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();

    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 8, 2, 1, 9};
        int k = 3;
        System.out.println(findKthLargest(nums, k));
    }
}
