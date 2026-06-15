package org.pdas.trees.basics;

import java.util.List;

public class BSTClient {
    static class Interval implements Comparable<Interval>{
        int startTime;
        int endTime;
        Interval(int startTime, int endTime){
            if (startTime > endTime) throw new IllegalArgumentException("start time can't be greater than end time");
            this.startTime = startTime;
            this.endTime = endTime;
        }


        @Override
        public int compareTo(Interval o) {
            int cmp = Integer.compare(this.startTime, o.startTime);
            if (cmp != 0){
                return cmp;
            }
            return Integer.compare(this.endTime, o.endTime);
        }
    }
    public static void main(String[] args) {
//        BST<Interval> intervalBST = new BST<>();
//        List<Interval> intervalList = List.of(new Interval(10, 30), new Interval(20, 40), new Interval(2, 17), new Interval(45, 55));
//        for (Interval interval: intervalList){
//            intervalBST.insert(interval);
//        }

        BST<Integer> bst = new BST<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(27);
        bst.insert(2);
        bst.printLevelOrder();
        bst.printInOrder();
        System.out.println();



    }
}
