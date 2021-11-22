package DataStructures;

public class FenwickTree {
    int[] tree;

    public FenwickTree(int size){
        tree = new int[size];
    }

    //sums from 0 to index
    public int sum(int index){
        int sum = 0;
        while(index > 0){
            sum += tree[index];
            index -= Integer.lowestOneBit(index);
        }
        return sum;
    }

    //increase index i by amount
    public void update(int index, int amount){
        while(index < tree.length){
            tree[index] += amount;
            index += Integer.lowestOneBit(index);
        }
    }

    public int rangesum(int i, int j){
        return sum(j) - sum(i-1);
    }
}
