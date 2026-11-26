// LC: FRACTIONAL KNAPSACK
// https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

import java.util.Arrays;

public class FractionaKnapsack {
    class Item {
        int value, weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
     public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        Item[] items = new Item[val.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(val[i], wt[i]);
        }
         Arrays.sort(items, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        });
        int curr = 0;
        double res = 0;
        for(int i=0;i<items.length;i++){
            if(curr==capacity)break;
            Item it = items[i];
            if(it.weight + curr > capacity){
                int w = capacity-curr;
                res += ((double) it.value/it.weight)*w;
                break;
            }
            res+= it.value;
            curr+= it.weight;
        }
        return res;
    }
}
