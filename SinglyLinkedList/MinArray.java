package org.example.SinglyLinkedList;

public class MinArray {

    public int findMinimum(int[] arr){
        //edge
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Invalid input");
        }
        int min = arr[0];  //min holds the minimum of array
        for (int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;

    }
    public static void main(String[] args) {
        int[] arr = {5,9,3,15,0,2};
        MinArray minArray = new MinArray();
        System.out.println("Minimum element in an Array is : " + minArray.findMinimum(arr));
    }
}