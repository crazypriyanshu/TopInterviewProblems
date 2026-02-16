package org.pdas.priorityQueues;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {
    /*
    * Design a class that receives a "stream" of integers.
    * At any moment, you must be able to return the median of all elements seen so far.
    *
    * Observation: if number of elements are odd, median in middle element, but if even median is average of middle 2 elements
    * Create 2 priority Queues one for larger half and other for lower half
    * */

    private static double findMedian(int[] arr){
        PriorityQueue<Integer> smallerHalf = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> largerHalf = new PriorityQueue<>();

        if (arr == null) return -1;
        for (int num: arr){
            smallerHalf.offer(num);
            largerHalf.offer(smallerHalf.poll());
            if (smallerHalf.size() < largerHalf.size()){
                smallerHalf.offer(largerHalf.poll());
            }
        }

        // findMedian
        if (smallerHalf.size() > largerHalf.size()){
            return smallerHalf.peek();
        }
        return ((smallerHalf.peek() + largerHalf.peek()))/2.0;

    }

}
