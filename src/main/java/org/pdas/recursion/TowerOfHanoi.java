package org.pdas.recursion;

public class TowerOfHanoi {
    // we have been given 3 towers -> source,  destination, auxiliary
    // we have n objects on source tower (based on the size, max size at bottom)
    //problem is to move n objects from source to destination using auxiliary tower

    public static void tower(int n, char source, char destination, char auxiliary){
        if (n == 1){
            System.out.println(" Move disk from "+ source +" to "+destination);
            return;
        }
        // move top (n-1) disks from source to auxiliary
        tower(n-1, source, auxiliary, destination);
        System.out.println("Moving disks from "+ source+ " to "+ auxiliary);
        // move n-1 disks from auxiliary to destination
        tower(n-1, auxiliary, destination, source);


    }

    public static void main(String[] args) {
        tower(3, 'A', 'C', 'B' );
    }
}
