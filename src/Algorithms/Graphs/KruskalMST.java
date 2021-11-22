package Algorithms.Graphs;

public class KruskalMST {
           /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */

    public static void main(String[] args){
        int[][] graph = new int[][]{
                {0, 10, 6, 5},
                {10,0,0,15},
                {6,0,0,4},
                {0,15,4,0}
        };

        System.out.println(kruskal(graph));
    }

    class FindUnion{
        Map<Integer,Integer> map = new HashMap<>();

        public FindUnion(int size){
            for(int i = 0; i < size; ++i){
                map.put(i,i);
            }
        }

        public int find(int id){
            if(map.get(id) != id){
                int newId = find(map.get(id));
                map.put(id,newId);
            }
            return map.get(id);
        }

        public void union(int num1, int num2){
            int id1 = find(num1);
            int id2 = find(num2);
            map.put(id1,id2);
        }
    }

    //find weight of MST
    public static int kruskal(int[][] graph){

        FindUnion fu = new FindUnion(graph.length);

        //[start,end,edge]
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1,v2) -> v1[2] - v2[2]);

        int MSTweight = 0;

        for(int i = 0; i < graph.length; ++i){
            for(int j = 0; j < graph[i].length; ++j){
                if(graph[i][j] != 0){
                    pq.offer(new int[]{i,j,graph[i][j]});
                }
            }
        }

        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int start = fu.find(edge[0]);
            int end = fu.find(edge[1]);

            if(start != end){
                MSTweight += edge[2];
                fu.union(start,end);
            }
        }

        return MSTweight; //implement
    }
}
