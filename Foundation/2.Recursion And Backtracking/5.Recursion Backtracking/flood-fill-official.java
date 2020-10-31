import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //  #sky never miss
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        //rows and cols
        
        int [][] arr = new int[n][m];
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        //why it is necessary : bcz to avoid stack overflow condition , be sure don;t make 
        // recursion call on that cell which was earlier visied...
        boolean [][] visited = new boolean[n][m];
        floodfill(arr,0,0,"",visited);
        
        
    }

    public static void floodfill(int[][] maze, int row, int col, String taara, boolean[][] visited) {
        // base case 
        
        if (row<0||col<0||row==maze.length||col==maze[0].length||maze[row][col]==1||visited[row][col]==true){
            return;
        }
        
        // reached bottom right
        if (row==maze.length-1 && col==maze[0].length-1){
            System.out.println(taara);
            return;
        }
        //top left down right
        // mark as travelled earlier
        visited[row][col] = true ;
        floodfill(maze,row-1,col,taara+"t",visited);
        floodfill(maze,row,col-1,taara+"l",visited);
        floodfill(maze,row+1,col,taara+"d",visited);
        floodfill(maze,row,col+1,taara+"r",visited);
        visited[row][col]=false; // backtracking for tracking more paths
        
    }
}