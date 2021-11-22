package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Topologicalsort {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{-1,-1,-1,-1,-1,-1},
                                    {-1,-1,-1,-1,-1,-1},
                                    {-1,-1,-1,1,-1,-1}, //2->3
                                    {-1,1,-1,-1,-1,-1}, //3->1
                                    {1,1,-1,-1,-1,-1}, //4->0,1
                                    {1,-1,1,-1,-1,-1}, //5->0,2
                                    };

        System.out.println(topsort(graph));
    }

    public static List<Integer> topsort(int[][] graph){
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i < graph.length; ++i){
            dfs(graph,list,i,visited);
        }
        Collections.reverse(list);
        return list;
    }

    private static void dfs(int[][] graph, List<Integer> list, int cur, boolean[] visited){
        if(visited[cur]){
            return;
        }
        visited[cur] = true;
        for(int i = 0; i < graph[cur].length; ++i){
            if(graph[cur][i] != -1){
                dfs(graph,list,i,visited);
            }
        }
        list.add(cur);
    }
}
