// LC: MAX POINTS YOU CAN GET FROM CARDS
// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class MaxPointsCard {
     public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum =0 ;
        for(int i=0; i<n;i++) sum+= cardPoints[i];
        int len = n-k;
        int s = 0; int res = Integer.MAX_VALUE;
        int low =0 , high = len-1;
        for(int i=low ; i<=high;i++) s+= cardPoints[i];
        while(high<n){
            res = Math.min(s, res);
            low++; high++;
            if(high==n)break;
            s = s - cardPoints[low-1] + cardPoints[high];
        }
        return sum-res;
    }
}