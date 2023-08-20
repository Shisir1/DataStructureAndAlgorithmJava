package org.example.InterViewQuestions;

public class SortedMatrix {

    public void search(int[][] matrix, int n, int x){
        int i = 0;
        int j = n - 1;

        while(i < n && j >=0){
            if(matrix[i][j] == x){
                System.out.println("Element " + x + " found at matrix " + "(" +i+","+j+")");
                return;
            }
            if(matrix[i][j] > x){
                j--;  //go 1 step left
            } else {
                i++;  //go 1 step down
            }
        }
        System.out.println("Element " + x + " NOT found in given Matrix!!!");
    }
    public static void main(String[] args) {
        int[][] matrix = {
                         {10,20,30,40},
                         {15,25,35,45},
                         {27,29,37,48},
                         {32,33,39,51}
                         };

        SortedMatrix sortedMatrix = new SortedMatrix();
        sortedMatrix.search(matrix,matrix.length,41);
        sortedMatrix.search(matrix,matrix.length,32);
    }
}
