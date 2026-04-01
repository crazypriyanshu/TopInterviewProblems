//package org.pdas.Strings;
//
//import java.util.Arrays;
//
//public class TransferCost {
//    /**
//     * Given an array of length n where we have indexes of stations to charge the drone.
//     * You have been given a target. If let's say we have to transfer an item from 0 to target
//     * we can move only 10 units of distance from drone. If you don't have station, you need to walk.
//     * Find the cost of walking for a given target and stations
//     * */
//    private static int findCost(int[] stations, int target){
//        Arrays.sort(stations);
//        int currPosition = 0;
//        int walkingCost = 0;
//        int flightRange = 10;
//
//        while (currPosition <= target){
//            int maxReach = currPosition+flightRange;
//            if (maxReach >= target){
//                break;
//            }
//
//            int bestStation = findFurtherStationInRange(stations, currPosition, maxReach);
//            if (bestStation != -1){
//                currPosition = bestStation;
//            } else {
//
//            }
//        }
//
//
//    }
//
//    private static int findNextImmediateStation(int[] stations, int maxReach){
//        int idx = Arrays.binarySearch(stations, maxReach);
//        if (idx >= 0){
//            return stations[idx];
//        }
//    }
//
//    private static int findFurtherStationInRange(int[] stations, int currPosition, int maxReach){
//        int idx = Arrays.binarySearch(stations, maxReach);
//        if (idx > 0) return stations[idx];
//
//        int insertionPoint = -(idx+1);
//        int bestIndex = insertionPoint-1;
//        if (bestIndex >= 0 && stations[bestIndex] > currPosition) {
//            return stations[bestIndex];
//        }
//        return -1;
//    }
//
//
//    public static void main(String[] args) {
//        int[] stations= {3, 7, 12};
//        int target = 8;
//        System.out.println(findCost(stations, target));
//    }
//}
