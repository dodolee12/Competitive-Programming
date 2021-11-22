package Algorithms.Graphs;
import java.util.*;

public class NumberOfConnectedComponentsUndirected {

    public int numberOfConnectedComponents(int[][] graph){
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0; i < graph.length; ++i){
            if(!visited.contains(i)){
                dfs(graph,visited,i);
                ++count;
            }
        }
        return count;
    }

    private void dfs(int[][] graph, Set<Integer> visited, int cur){
        if(visited.contains(cur)){
            return;
        }
        visited.add(cur);
        for(int i = 0; i < graph.length; ++i){
            if(graph[cur][i] != 0){
                dfs(graph,visited,i);
            }
        }
    }
}
