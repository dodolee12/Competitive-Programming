package Algorithms.Graphs;
import java.util.*;

public class DetectCycleUndirected {

    //assumes entire graph is connected
    //if not then just iterate through every element
    public boolean detectCycle(int[][] graph){
        return helper(graph,new HashSet<>(), 0,0);
    }
    private boolean helper(int[][] graph, Set<Integer> visited, int cur, int prev){
        if(visited.contains(cur)){
            return true;
        }
        visited.add(cur);
        for(int i = 0; i < graph[cur].length; ++i){
            if(graph[cur][i] != 0 && i != prev && helper(graph,visited,i,cur)){
                return true;
            }
        }
        return false;
    }
}
