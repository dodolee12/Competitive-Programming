package Algorithms.Graphs;
import java.util.Arrays;

public class FloydWarshall {

    public static void main(String[] args){
        int[][] graph = new int[][] {{0,5,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,0,3,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,0,1},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,0}};

        int[][] distances = floydWarshall(graph,graph.length);
        for(int[] distance: distances){
            System.out.println(Arrays.toString(distance));
        }
    }

    //adjacency list input
    public static int[][] floydWarshall(int[][] graph, int n){
        int[][] distances = new int[n][n];
        //asumming all graphs are 0 for self and Integer.MAX_VALUE for no edge
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                distances[i][j] = graph[i][j];
            }
        }

        //dp[k][i][j] is shortest distance from i to j through k
        for(int k = 0; k < n; ++k){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    if(distances[i][k] != Integer.MAX_VALUE &&
                            distances[k][j] != Integer.MAX_VALUE){
                        distances[i][j] = Math.min(distances[i][j],distances[i][k] + distances[k][j]);
                    }
                }
            }
        }

        return distances;
    }
}
