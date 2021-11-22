package Algorithms.Graphs;

import java.util.*;

public class BellmanFord {

    public static void main(String[] args){
        int[][] graph = new int[][] {{0,5,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,0,3,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,0,1},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0}};

        List<int[]> edges = new ArrayList<>();
        for(int i = 0 ;i < graph.length; ++i){
            for(int j = 0; j < graph[0].length; ++j){
                if(graph[i][j] != Integer.MAX_VALUE){
                    edges.add(new int[]{i,j,graph[i][j]});
                }
            }
        }
        negativeCycle(edges.toArray(new int[edges.size()][]),0,graph.length);
    }

    //using bellman ford to check whether there is a negative cycle
    public static boolean negativeCycle(int[][] edgeList, int start, int n){
        int[] dist = bellmanFord(edgeList,start,n);

        for (int[] edge : edgeList) {
            if (!(dist[edge[0]] == Integer.MAX_VALUE) && dist[edge[0]] + edge[2] < dist[edge[1]]) {
                return true;
            }
        }
        System.out.println(Arrays.toString(dist));
        return false;
    }

    //edgelist is list of edges in graph, n is total number of vertices
    //edgelist is [start,end,weight]
    public static int[] bellmanFord(int[][] edgeList, int start, int n){
        //distances from start to
        int[] dist = new int[n];
        for(int i = 0; i < n; ++i){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        //repeat n-1 times
        for(int i = 0; i < n - 1; ++i) {
            for (int[] edge : edgeList) {
                if (!(dist[edge[0]] == Integer.MAX_VALUE) && dist[edge[0]] + edge[2] < dist[edge[1]]) {
                    dist[edge[1]] = dist[edge[0]] + edge[2];
                }
            }
        }

        return dist;
    }
}
