package org.pdas.arrays;

public class CalculateUniqueBuses {
    public static int[] calculateUniqueBuses(int N, int[] busesStartingAt){
        // bus starting At = [1, 1, 2, 5]
        int[] busFreq = new int[N+1];
        for (int startStop: busesStartingAt){
            if (startStop <= N){
                busFreq[startStop]++;
            }
        }

        int[] res = new int[N+1];
        for (int i=1; i <= N; i++){
            if (busFreq[i] == 0) continue;
            for (int j=i; j <= N; j++){
                // mark all multiples of i
                res[j] += busFreq[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] busStartingPoints = {1, 1, 3, 5};
        int N = 7;
        calculateUniqueBuses(N, busStartingPoints);

    }
}
