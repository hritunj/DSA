// LC: LEMONADE CHANGE
// https://leetcode.com/problems/lemonade-change/description/
public class LemonadeChange {
     public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int fives = 0 , tens = 0 ;
        for(int i=0;i<n;i++){
            if(bills[i] == 5){
                fives++;
            }
            if(bills[i] == 10){
                if(fives==0) return false;
                fives--;
            }
            if(bills[i]==20){
                boolean cond = tens==0 && fives<3;
                if(fives==0 || cond) return false;
                if(tens==0 && fives>3){
                    fives-=3;
                    continue;
                }
                fives-=1;
                tens--;
            }
        }
        return true;
    }
}
