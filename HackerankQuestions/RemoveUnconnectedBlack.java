package org.example.HackerankQuestions;

import java.util.Arrays;

public class RemoveUnconnectedBlack {
    public void removeUnconnectedBlack(int[][] grid){
        int rows = grid.length;
        System.out.println("no of row: "+rows);
        int cols = grid[0].length;
        System.out.println("no of cols: " + cols);
        //print the original grid
//        for(int[] row : grid){
//            System.out.println(Arrays.toString(row));
//        }
        System.out.println("no of cols: "+Arrays.toString(grid[2]));


        boolean[][] visited = new boolean[rows][cols];


        //traverse the top and bottom borders
        for(int j = 0; j < cols; j++){
            deepFirstSearch(0,j,grid,visited);
            deepFirstSearch(rows -1,j,grid,visited);
        }
        //traverse the left and right
        for(int i = 0; i < rows; i++){
            deepFirstSearch(i,0,grid,visited);
            deepFirstSearch(i,cols -1, grid, visited);
        }
        //Remove unconnected black cells
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    grid[i][j] = 0;
                }
            }
        }

    }
    private void deepFirstSearch(int x, int y, int[][] grid, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || grid[x][y] == 0){
            return;
        }
        visited[x][y] = true;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            deepFirstSearch(newX,newY,grid,visited);
        }
    }
    //Example usage:
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };


        RemoveUnconnectedBlack remover = new RemoveUnconnectedBlack();
        remover.removeUnconnectedBlack(grid);

        //print the modified grid
        for(int[] row : grid){
            System.out.println(Arrays.toString(row));
        }

    }
}
