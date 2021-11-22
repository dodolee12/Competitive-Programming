package Algorithms.Arrays;

public class Binarysearch {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        System.out.println(binarySearch(arr, 2)); // iteratively
        System.out.println(binarySearch(arr, 2, 0, arr.length - 1)); // recursively
    }

    //Iteratively
    public static boolean binarySearch(int[] arr, int val){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;  //not (start + end)/2 because of possible overflow
            if(arr[mid] == val){
                return true;
            }
            else if(arr[mid] < val){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return false;
    }

    //recursively (end is inclusive)
    public static boolean binarySearch(int[] arr, int val, int start, int end){
        if(start > end){
            return false;
        }
        int mid = start + (end - start)/2;
        if(arr[mid] == val){
            return true;
        }
        else if(arr[mid] < val){
            return binarySearch(arr,val,mid + 1, end);
        }
        else{
            return binarySearch(arr,val,start, mid - 1);
        }
    }
}
