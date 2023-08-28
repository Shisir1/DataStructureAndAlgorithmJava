package org.example.InterViewQuestions;

public class LeetCode35SearchInsertPosition {

    public int searchInsert(int[] arr, int target){

        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if(target < arr[mid]){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        LeetCode35SearchInsertPosition sip = new LeetCode35SearchInsertPosition();
        int[] arr = {1,10,20,47,59,65,75,88,99};

        int result_index = sip.searchInsert(arr, 89);

        System.out.println(result_index);
    }
}
