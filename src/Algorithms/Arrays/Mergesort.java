package Algorithms.Arrays;

import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,5,1,9,2,3,1};
        System.out.println(Arrays.toString(mergesort(arr, 0 ,arr.length - 1)));
    }

    public static int[] mergesort(int[] arr, int start, int end){
        if(start == end){
            return new int[]{arr[start]};
        }
        int mid = start + (end - start)/2;
        int[] left = mergesort(arr,start,mid);
        int[] right = mergesort(arr,mid + 1, end);

        int leftpointer = 0;
        int rightpointer = 0;
        int mergedArrayPointer = 0;
        int[] mergedArray = new int[left.length + right.length];

        while(leftpointer < left.length && rightpointer < right.length){
            if(left[leftpointer] <= right[rightpointer]){
                mergedArray[mergedArrayPointer++] = left[leftpointer++];
            }
            else{
                mergedArray[mergedArrayPointer++] = right[rightpointer++];
            }
        }
        while(leftpointer < left.length){
            mergedArray[mergedArrayPointer++] = left[leftpointer++];
        }
        while(rightpointer < right.length){
            mergedArray[mergedArrayPointer++] = right[rightpointer++];
        }

        return mergedArray;
    }
}
