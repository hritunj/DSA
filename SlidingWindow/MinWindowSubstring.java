// LEETCODE 76: Minimum Window Substring
// https://leetcode.com/problems/minimum-window-substring/description/

public class MinWindowSubstring {
    public boolean compareFreq(int[] fw, int[] ft){
        for(int i=0;i<256;i++){
            if(ft[i]>fw[i]){
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] fw = new int[256]; // stores freq of window characters
        int[] ft = new int[256]; // stores freq of t characters

        int low=0,high=0, m = s.length() , n= t.length() , res = Integer.MAX_VALUE,  start = -1;
        

        for(int i=0; i<n;i++){
            ft[t.charAt(i)]++;
        }

        for(high=0 ; high<m ; high++){

            fw[s.charAt(high)]++;

            while(compareFreq(fw, ft)){
                int len = high-low+1;
                if(res>len){
                    start = low;
                    res = len;
                }
                fw[s.charAt(low)]--;
                low++;
            }
        }
        if(res==Integer.MAX_VALUE) return "";
        return s.substring(start, res+start);
       
    }
}
