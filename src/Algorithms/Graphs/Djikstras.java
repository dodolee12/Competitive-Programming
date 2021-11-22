package Algorithms.Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Djikstras {
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        System.out.println(Djikstras(graph,0,1));
    }

    //allocate every path as -1
    //process first edge and update path (if a to b + b to c < a to c, then update)
    //if path is updated, then modify pq entry
    //
    public static int Djikstras(int[][] graph, int start, int end){
        int[] paths = new int[graph.length];
        Arrays.fill(paths,Integer.MAX_VALUE/2);
        paths[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] - v2[1]);
        pq.offer(new int[]{start,0});
        for(int i = 0; i < graph.length; ++i){
            if(i == start){
                continue;
            }
            pq.offer(new int[]{i,Integer.MAX_VALUE/2});
        }
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int curnode = edge[0];

            //iterate through edges in graph
            for(int i = 0; i < graph[curnode].length; ++i){
                //check if edge exists
                if(graph[curnode][i] == 0){
                    continue;
                }
                //if new path is better
                //this is linear in normal pq but in fibonnaci heap it is amortized constant
                if(paths[curnode] + graph[curnode][i] < paths[i]){
                    //update pq
                    paths[i] = paths[curnode] + graph[curnode][i];
                    pq.add(new int[]{i,paths[i]});
                }
            }

        }

        return paths[end];
    }
}
