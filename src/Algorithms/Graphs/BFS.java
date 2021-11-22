package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    static List<Integer> bfs = new ArrayList<>();

    public static void main(String[] args) {
        int[][] graph = new int[][]{{-1, 1, 1, -1}, {-1, -1, -1, 1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}};
        bfs(graph, new boolean[graph.length], 0);
        System.out.println("bfs: " + bfs);
    }

    public static void bfs(int[][] graph, boolean[] visited, int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int node = q.poll();
                //process node here
                bfs.add(node);
                visited[node] = true;
                for(int i = 0; i < graph[node].length; ++i){
                    int weight = graph[node][i];

                    if(weight != -1 && !visited[i]){
                        q.offer(i);
                    }
                }
            }
            //end of this represents one breadth
        }
    }
    //for adjacency list implementation, just iterate through edges and dont need to check for -1
}
