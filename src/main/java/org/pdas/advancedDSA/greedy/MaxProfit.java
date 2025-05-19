package org.pdas.advancedDSA.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxProfit {
    // Problem statement : Job scheduling : Given n tasks to complete
    /* 1. Deadlines are assigned for each task = on the day or before we can do that task
    * 2. payments are assigned to each task
    * 3. On a give day we can perform only one task, and we can perform maximum one task in a day
    * WE have to find the max payment we can get
    * Input : List<Pair<int, int, String>> data
                * int -> deadline
                * int -> payment
                * string -> task name
    * Using greedy algorithm , find the max payment we can get
    * Eg :
    *   deadline:   1       3       2       1       3
    *   payment:    19      100     27      25      30
    *   taskName:   a       b       c       d       e
    *
    * means :
    *   on day 1 : task 'a' and task 'd' can be completed on day 1, so we should add the task having max payment to a minHeap
    *   on day 2 : task 'c' can be done and only one task , so we add this to minHeap
    *   on day 3 : task 'e' and 'b' can be completed, but here we also remove the min payment task in minHeap and add the latest one and continue replacing
    *
    * */
    /*
    * Solution :
    * Step 1: Sort the List based on the deadline in ascending order
    *   Eg :
     *   deadline:   1       2       2       3       3
     *   payment:    19      25     27      100      30
     *   taskName:   a       d       c       b       e
    * Step 2: Create a minHeap of size : max(deadline)
    * Step 3: loop through the input
    *       if day > minHeap.size() -> there is an empty slot, insert the payment
    *       elseif pay > minHeap.getMin() -> i can remove the min payment and replace this
    * Step 4: while minHeap.size() > 0
    *       ans = ans + minHeap.getMin();
    *       minHeap.deleteMin();
    *
    * */

    static class Job {
        private int deadline;
        private int payment;
        private String taskName;
        Job(int deadline, int payment, String taskName){
            this.deadline = deadline;
            this.taskName = taskName;
            this.payment = payment;
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job(1, 19, "a"),
                new Job(3, 100, "b"),
                new Job(2, 27, "c"),
                new Job(1, 25, "d"),
                new Job(3, 30, "e"),
                new Job(1, 19, "g")
        );

        int ans = findMaxProfit(jobs);
        System.out.println("Max profit : "+ ans);

    }

    public static int findMaxProfit(List<Job> jobs) {
        // sort the jobs by deadline ascending order
        jobs.sort( (j1, j2) -> {
            if (j1.deadline == j2.deadline) {
                return j2.payment - j1.payment;
            }
            return j1.deadline - j2.deadline;
        });

        // create a priority queue
        PriorityQueue<Job> minHeap = new PriorityQueue<>(Comparator.comparingInt(j -> j.payment));
        int maxPayment = 0;
        // start processing
        for (Job job: jobs){
            if (minHeap.size() < job.deadline){
                // we have a slot
                minHeap.offer(job);
                maxPayment += job.payment;
            } else if (!minHeap.isEmpty() && minHeap.peek().payment < job.payment){
                // our heap minHeap value payment is less than the incoming payment
                maxPayment -= minHeap.poll().payment;
                minHeap.offer(job);
                maxPayment += job.payment;
            }
        }
        return maxPayment;

    }

}
