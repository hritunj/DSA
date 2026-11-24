// LEETCODE 11 - CONTAINER WITH MOST WATER
// https://leetcode.com/problems/container-with-most-water/description/

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while(l<r){
            int w = r-l;
            int h = Math.min(height[l] , height[r]);
            int curr = w*h;
            max = Math.max(curr,max);
            
            if(height[l] > height[r]){
                r--;
            }else {
                l++;
            }
             
            
        }
        return max;
    }
}
