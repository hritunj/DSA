// LC 785l IS GRAPH BIPARTITE?
// https://leetcode.com/problems/is-graph-bipartite/description/
public class Bipartite {
    int[] colors ;
     public boolean isBipartite(int[][] graph) {
        colors = new int[graph.length];
        for(int i =0 ; i<graph.length;i++){
            if(colors[i] ==0 && !dfs(graph, i, 1)){
                return false;
            }
        }
        return true;

    }
    public boolean dfs(int[][] graph , int node, int c){
        colors[node] = c;
        for(int i=0; i< graph[node].length;i++){
            int neig = graph[node][i];
            if(colors[neig] !=0 && colors[neig] ==c){
                return false;
            } 
            if(colors[neig] ==0){
                if( !dfs(graph, neig, 3-c)) return false;
            }
        }
        return true;
    }
}
