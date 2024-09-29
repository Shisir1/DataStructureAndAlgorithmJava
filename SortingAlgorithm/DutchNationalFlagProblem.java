package org.example.SortingAlgorithm;

import java.util.Arrays;

public class DutchNationalFlagProblem {

    public void threeNumberSort(int[] arr){
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while (i <= k){
            if(arr[i] == 0){
                swap(arr,i,j);
                System.out.println("found 0 swapping with j -> " + Arrays.toString(arr));
                i++;
                j++;
            } else if(arr[i] == 1){
                i++;
                System.out.println("found 1 skipping swap -> " + Arrays.toString(arr));
            } else if(arr[i] == 2){
                swap(arr,i,k);
                System.out.println("found 2 swapping with k -> " + Arrays.toString(arr));
                k--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void printArray(int arr[]){

        for(int i = 0;  i < arr.length - 1; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        DutchNationalFlagProblem dnfp = new DutchNationalFlagProblem();

        int[] arr = new int[] {2,0,2,2,0,1,1};
        System.out.print("Original Array -> ");
        dnfp.printArray(arr);

        System.out.print("\nSorted 0s,1s,and 2s(Dutch National Flag Problem) -> ");
        dnfp.threeNumberSort(arr);
        dnfp.printArray(arr);
    }
}
