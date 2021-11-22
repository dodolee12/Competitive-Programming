package DataStructures;

import java.util.*;

public class FindUnion {
    //id -> object, object can be anything you want to store, just make sure object has access to label
    Map<Integer,Integer> map = new HashMap<>();

    //make set with initial elements
    public void makeSet(int[] elements){
        for(int i = 0; i < elements.length; ++i){
            map.put(i,i);
        }
    }

    //find the set with index/label k
    public int find(int k){
        if(map.get(k) != k){
            //path compression
            map.put(k,find(map.get(k)));
        }

        return map.get(k);
    }

    //union two items by id/label
    public void union(int a, int b){
        int a_set = find(a);
        int b_set = find(b);

        map.put(a_set,b_set);
    }
}
