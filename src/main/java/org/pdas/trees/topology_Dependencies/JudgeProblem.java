package org.pdas.trees.topology_Dependencies;

import java.util.Arrays;

public class JudgeProblem {
    /*
    * In a town of n people (labeled 1 to n), there is a rumor that one of these people is secretly the town judge.
    * If the `town judge` exists, then:
    *   1. The `town judge` trusts nobody.
    *   2. Everybody (except the town judge) trusts the town judge.
    *   There is exactly one person that satisfies properties 1 and 2.
    *
    * Input - int n : number of people and int[] -trust - trust[i] = [a, b] - represents a trusts b
    * Output : find the town judge if it exists, else return -1
    * */


    /*
    * Approach : This means that the town judge out degree -> must be 0 -> because town judge trusts nobody
    * and in degree must be (n-1) {meaning except him everyone trusts him}
    * so, if we maintain the array where we calculate the score
    * */

    public static int findJudge(int[][] trust, int n) {
        // because people are numbered from 1 to n
        int[] netTrustArray = new int[n+1];
        Arrays.fill(netTrustArray, 0);
        for (int i = 0; i < trust.length; i++) {
            int personA = trust[i][0];
            int personB = trust[i][1];
            netTrustArray[personA]--;
            netTrustArray[personB]++;
        }

        for (int i = 1; i < n+1; i++) {
            if (netTrustArray[i] == n-1){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        // simply means 1- trusts 2, 1- trusts 3, 2- trusts 3
        int[][] trustMatrix = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(findJudge(trustMatrix, 3));
    }

    // Problem 2 : Lets say you have been given a 2D array edges:
    // representing graph with n nodes labeled 1 to n), there are exactly n-1 edges
    // find node which sits at the centre
    private static int findCentralNode(int[][] edges){

        // grab the first edge
        int a = edges[0][0];
        int b = edges[0][1];

        // grab second edge
        int c = edges[1][0];
        int d = edges[1][1];

        return (a == c || b == d)? a: b;
    }

}
