// LEETCODE- 424 Longest Repeating Character Replacement
// https://leetcode.com/problems/longest-repeating-character-replacement/description/

public class Characterreplacement {
    public int find(int[] f){
        int max = 0;
        for(int i=0; i<f.length;i++){
            if(f[i]>max){
                max = f[i];
                
            }
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        int f[] = new int[256]; // Contains frequency of ASCII values 
        int low =0 , high =0, n =s.length() , res=0,max_count=0;
        for(high=0 ; high<n;high++){
            char c = s.charAt(high);
            f[c]++; // character automatically converted to it's ASCII value
            max_count = Math.max(max_count, f[c]);
            int len = high-low+1;
            int difference = len-max_count;
            while(difference>k){
                f[s.charAt(low)]--;
                low++;
                len = high-low+1;
                max_count = find(f);
                difference= len-max_count;
            }
            len = high -low+1;
            res = Math.max(res, len);

        }
        return res;
    }
}
