package org.pdas.dp.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NCitiesProblem {
    /**
     * Robin wants to travel a country which has N cities connected by N-1 bi-directional roads.
     * The cities and roads of the country are weird as they give A[v] coins on visiting the city v
     * and it cost coins equal to length of a road on visiting the road.
     * He will select any two cities X and Y (X may also be equal to Y),
     * and travel from X to Y via simple path(visiting a road at most once) such that he lefts with maximum coins at the end.
     * Return the maximum coins he can have, since the answer could be large return answer % 109 + 7.
     * Note: The number of coins with him can't be negative at any point of time.
     * */
    static final long MOD = 1000000007;
    static long maxOverAll = 0;
    public static int solve(int[] A, int[][] B) {

        int n = A.length; // tot cities
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i <= n ; i++){
            adjList.add(new ArrayList<>());
        }

        for (int[] edge: B){
            adjList.get(edge[0]-1).add(new int[] {edge[1]-1, edge[2]});
            adjList.get(edge[1]-1).add(new int[]{edge[1]-1, edge[2]});
        }

        dfs(0, -1, A, adjList);
        return (int) (maxOverAll%MOD);


    }

    private static long dfs(int source, int destination, int[] A, ArrayList<ArrayList<int[]>> adj){
        long best = 0;
        long secondBest = 0;
        for (int[] edge: adj.get(source)){
            int v = edge[0];
            int weight = edge[1];
            if (source == v) continue;
            long fromChild = dfs(v, source, A, adj)-weight;
            if (fromChild > best){
                secondBest = best;
                best = fromChild;
            } else if (fromChild > secondBest) {
                secondBest = fromChild;
            }
        }

        maxOverAll = Math.max(maxOverAll, A[source] + best + secondBest)%MOD;
        return (A[source] + best)%MOD;
    }

    public static int lenOfMaxSubstring(String A){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        for(char c: A.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,  right);
                left = right;
            }
            right++;
            map.put(c, right);
            maxLen = Math.max(maxLen, right-left);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] A = {6, 3, 2, 5, 0};
        int[][] B = {
                {1, 2, 10},
                {2, 3, 3},
                {2, 4, 1},
                {1, 5, 1}
        };
        // System.out.println(solve(A, B));
        String a = "dadbc";
        System.out.println(lenOfMaxSubstring(a));

    }
}
