// LC: SUBSTRINGS CONTAINING ALL THREE CHARACTERS
// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
public class SubtringsContainingThreeCharacters {
     public int numberOfSubstrings(String s) {
        int[] f = new int[3];
        int low =0 , high = 0 , res =0 , n= s.length();
        while(high<n){
            f[s.charAt(high) - 'a']++;
            while(f[0]>0 && f[1]>0 && f[2]>0){
                
                res += n - high;
                f[s.charAt(low) - 'a']--;
                low++;
            }
            high++;
        }
        return res;
    }
}
