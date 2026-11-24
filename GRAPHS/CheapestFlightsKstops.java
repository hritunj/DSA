// LC: CHEAPEST FLIGHT IN K STOPS
// https://leetcode.com/problems/cheapest-flights-within-k-stops/

import java.util.Arrays;

public class CheapestFlightsKstops {
     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] res = new int[n];
        Arrays.fill(res, 100000000);
        res[src] = 0;
        for(int i=0;i<k+1;i++){
            int[] temp = res.clone();
            for(int j=0;j<flights.length;j++){
                int s = flights[j][0];
                int d = flights[j][1];
                int w = flights[j][2];
                if(res[s]!=100000000 && temp[d] > res[s]+w) {
                    temp[d] = res[s] + w;
                }
            }
            res =temp;
        }
        return res[dst] == 100000000 ? -1: res[dst];
    }
}
