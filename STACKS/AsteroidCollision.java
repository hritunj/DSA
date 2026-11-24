
// LC: ASTEROID COLLISION
// https://leetcode.com/problems/asteroid-collision/description/
import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            boolean alive= true;
            if (s.isEmpty()) {
                s.push(asteroids[i]);
                continue;
            }
            while (alive&& !s.isEmpty() && s.peek()>0 && asteroids[i]<0) {
                int p = s.pop();
                if(p>-asteroids[i]){
                    s.push(p);
                    alive = false;
                }
                else if(p==-asteroids[i]){
                    alive = false;
                }
                // else p dies so continue
            }
            if(alive) s.push(asteroids[i]);
        }
        int[] res = new int[s.size()];
        while(!s.isEmpty()){
            res[s.size()-1] = s.pop();
        }
       return res;
        
    }
}
