package org.example.SortingAlgorithm;

public class MergeSort {

    public void printArray(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void sort(int[] arr, int[] temp, int low, int high){
        if(low < high){ //base case
            int mid = low + (high - low) / 2; //takes care of int overflow condition -> (low + high) / 2

            //traversing left side of array
            sort(arr,temp,low,mid);
            //traversing right side of array
            sort(arr,temp,mid+1,high);
            //merge two sub-arrays
            merge(arr,temp,low,mid,high);

        }
    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for(int i = low; i <= high; i++){
            temp[i] = arr[i];
        }
        int i = low; //traverse left sorted sub-array
        int j = mid + 1; //traverse right sorted sub-array
        int k = low; //will merge both arrays into original array (arr)

        while (i <= mid && j<= high){ //either left or right sub-array gets exhausted
            if(temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid){
            arr[k] = temp[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9,5,2,4,3,-1};
        MergeSort ms = new MergeSort();
        System.out.print("original array -> ");
        ms.printArray(arr);

        ms.sort(arr,new int[arr.length], 0,arr.length - 1);
        System.out.print("Sorted array using Merge Sort -> ");
        ms.printArray(arr);
    }
}
