package org.example.PriorityQueue;

public class BinarySearch {

    public int search(int[] arr, int key){

        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == key) {
                return mid;
            };

            if(key < mid){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {1,10,20,47,59,65,75,88,99};

        int result = bs.search(nums,89);

        if(result >=0) {
            System.out.println("Key is at index : " + result);
        } else {
            System.out.println("Key NOT found!!!");
        }
    }
}
