package org.pdas.trees;

import java.util.TreeSet;

public class ExamRoom {
    /**
     * There is an exam room with n seats in a single row labeled from 0 - n-1. When student enters the room, they must sit in the seat that maximizes the distance between to the closest person. if there are multiple such seats, they sit in the seat with lowest number, if no one in the room, then student sits at seat number 0.
     *
     * Design a class:
     *
     * ExamRoom(int n) - initializes the object of the exam room with number of seats n.
     *
     * int seat() : return the label of the seat at which next student will sit
     *
     * void leave(int p): indicates the student sitting at seat p will leave the room. it is guaranteed that there will be a student sitting at seat p
     * */


    private int N;
    private TreeSet<Integer> seated;

    public ExamRoom(int N){
        this.N = N;
        this.seated = new TreeSet<>();
    }

    public int seat(){
        if (seated.isEmpty()){
            seated.add(0);
            return 0;
        }

        int maxDistance = seated.first();
        int seatToTake = 0;
        Integer prev= null;
        for (int seat: seated){
            if (prev != null){
                int distance = (seat-prev)/2;
                if (distance > maxDistance){
                    maxDistance = distance;
                    seatToTake = prev + distance;
                }
            }
            prev = seat;
        }

        if (N-1-seated.last() > maxDistance){
            seatToTake = N-1;
        }
        seated.add(seatToTake);
        return seatToTake;
    }

    public void remove(int p){
        seated.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        examRoom.seat(); // 0
        examRoom.seat(); // 9
        examRoom.seat(); // 4
        examRoom.seat(); // 2

        examRoom.remove(4);
        examRoom.seat();
    }
}

