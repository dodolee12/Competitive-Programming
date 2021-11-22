package Algorithms.Arrays;

public class Quickselect {
    public static void main(String[] args) {
        System.out.println(quickselect(new int[]{2,4,8,10,3},0,4,5));
    }

    public static int quickselect(int[] n, int start, int end, int k){
        int partition = n[end];
        int part = start;
        for(int i = start; i < end; ++i){
            if(n[i] < partition){
                if(part != i){
                    int temp = n[i];
                    n[i] = n[part];
                    n[part] = temp;
                }
                ++part;
            }
        }
        int temp = n[end];
        n[end] = n[part];
        n[part] = temp;
        if(part - start + 1 == k){
            return n[part];
        }
        else if (part - start + 1 > k){
            return quickselect(n,start,part-1,k);
        }
        else{
            return quickselect(n,part+1,end,k - (part - start + 1));
        }
    }
}
