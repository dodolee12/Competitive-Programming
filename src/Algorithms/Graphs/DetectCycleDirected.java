package Algorithms.Graphs;
import java.util.*;

public class DetectCycleDirected {

    public boolean detectCycle(int[][] graph){
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for(int i = 0; i < graph.length; ++i){
            if(!visited.contains(i) && dfs(graph,visited,recursionStack,i)){
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int[][] graph, Set<Integer> visited, Set<Integer> recursionStack, int cur){
        if(recursionStack.contains(cur)){
            return true;
        }
        if(visited.contains(cur)){
            return false;
        }
        visited.add(cur);
        recursionStack.add(cur);
        for(int i = 0; i < graph[cur].length; ++i){
            if(graph[cur][i] != 0 && dfs(graph,visited,recursionStack,cur)){
                return true;
            }
        }
        recursionStack.remove(cur);
        return false;
    }
}
