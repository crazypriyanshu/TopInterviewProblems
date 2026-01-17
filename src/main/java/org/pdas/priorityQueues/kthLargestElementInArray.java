package org.pdas.priorityQueues;

import java.util.PriorityQueue;

public class kthLargestElementInArray {
    /*
    * Find the k-th largest element in an unsorted array.
    * (Note: It is the k-th largest in sorted order, not the k-th distinct element).
    *
    * When the use case is top k or bottom k, it hints towards using Priority Queue
    *
    * Idea: We maintain a min heap and keep adding the elements one by one
    * if the heap size exceeds k, poll the smallest
    * as we keep removing smallest - at the end we will get the k-largest elements seen so far
    *
    * The root of min heap will be smallest among k largest elements
    * */

    public static int kthLargest(int[] arr, int k){
        // create min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k+1);
        for (int num: arr){
            minHeap.add(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 1, 3, 7, 2};
        int k = 2;
        System.out.println(kthLargest(arr, k));
    }
}
