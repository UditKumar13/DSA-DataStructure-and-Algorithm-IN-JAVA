/*

You are given an m * n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell. A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Input :
4 4
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0

Output :
3
*/

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);

    int[][] arr = new int[m][n];

    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numEnclaves(arr));

  }

  public static int numEnclaves(int[][] arr) {

    for (int  i=0  ; i < arr.length; i++){
      for (int j=0 ; j<arr[0].length; j++){
        
        // connected to edges 
        if (i==0 || j ==0 || i==arr.length-1 || j == arr[0].length-1){
          if (arr[i][j] == 1){
            // call here 
            dfs(arr,i,j) ; 
          }
        }
      }
    }
    
    
    // calculating now the number of ones : 
    
    int count = 0 ; 
    for (int i =0 ; i< arr.length ; i++){
      for (int j=0 ; j<arr[0].length ; j++){
        if (arr[i][j] == 1){
          count ++ ; 
        }
      }
    }
    
    return count ; 
  }
  
  public static void dfs(int [][] arr, int i, int j){
    if (i<0 || j< 0 || i>= arr.length || j>= arr[0].length || arr[i][j] == 0){
      return ; 
    }
    
    
    arr[i][j] = 0 ;
    
    dfs(arr,i+1,j);
    dfs(arr,i-1,j);
    dfs(arr,i,j+1);
    dfs(arr,i,j-1);
  }

}