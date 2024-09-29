package org.example.SortingAlgorithm;

public class QuickSortPartitionMethod {

    public int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low;
        int j = low;
        System.out.println("\nPivot index before Sorting -> " + (high -1 + " (element -> " + pivot + ")"));

        /**
         * low to j -1 -> smaller & equal to pivot
         * j to i - 1 -> greater elements to pivot
         * i to high -> yet to be traversed
         */
        while (i <= high){
            if (arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j - 1;
    }

    private void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {9,-3,5,2,6,8,-6,1,3};

        QuickSortPartitionMethod qspm = new QuickSortPartitionMethod();
        System.out.print("Original Array -> ");
        qspm.printArray(arr);


        int pivot_index = qspm.partition(arr,0,arr.length -1);
        System.out.print("\nPivot Index after Sorting -> " + pivot_index);
        System.out.print("\nAfter Quick Sort Partition Method -> ");
        qspm.printArray(arr);

    }
}
