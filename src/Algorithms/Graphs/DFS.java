package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    static List<Integer> dfs = new ArrayList<>();

    public static void main(String[] args) {
        int[][] graph = new int[][]{{-1,1,1,-1},{-1,-1,-1,1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
        dfs(graph, new boolean[graph.length], 0);
        System.out.println("dfs: " + dfs);
    }


    //undirected using adjacency matrix
    public static void dfs(int[][] graph, boolean[] visited, int cur){
        if(visited[cur]){
            return;
        }
        //process node here
        dfs.add(cur);

        visited[cur] = true;
        for(int i = 0; i < graph[cur].length; ++i){
            int weight = graph[cur][i];
            //edge = -1 means edge dosent exist
            if(weight != -1 && !visited[i]){
                dfs(graph,visited,i);
            }
        }
    }
}
