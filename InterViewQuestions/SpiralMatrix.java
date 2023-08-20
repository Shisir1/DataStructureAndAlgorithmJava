package org.example.InterViewQuestions;


public class SpiralMatrix {

    public void spiralPrint(int[][] matrix, int rowLen, int colLen){
        int i,row=0,col=0;
        while (row < rowLen && col < colLen){
            for (i=col; i < colLen; i++){   // left to right traversal
                System.out.print(matrix[row][i] + ",");
            }
            row++;
            for (i =row; i < rowLen; i++){  // top to bottom traversal
                System.out.print(matrix[i][colLen -1] + ",");
            }
            colLen--;
            if(row < rowLen){
                for(i = colLen -1; i >= col; i--){  // right to left traversal

                        System.out.print(matrix[rowLen -1][i] + ",");
                }
                rowLen--;
            }
            if(col < colLen){
                for (i=rowLen -1; i >= row; i--){   // bottom to top traversal
                        System.out.print(matrix[i][col] + ",");
                }
                col++;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralPrint(matrix,matrix.length,matrix[0].length);
    }
}
