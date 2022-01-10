/*
Given an m*n binary matrix mat, return the number of distinct island.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Input:
3 3
1 0 0
0 1 0
1 1 1

Output :
2
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numDistinctIslands(arr));

  }

  
  public static void dfs(int [][] arr, int row, int col){
    arr[row][col] = 0 ; // making it zero first 
    
    if (row-1 >= 0 && arr[row-1][col] == 1){
      psf.append("u") ; // up call 
      
      dfs(arr,row-1,col) ; 
    }
    
    
    if (col+1 < arr[0].length && arr[row][col+1] == 1){
      psf.append("r"); // right
      dfs(arr,row,col+1) ; 
    }
    
    if (row + 1 < arr.length && arr[row+1][col] == 1){
       psf.append("d") ; // down
      
      dfs (arr,row+1, col) ; 
    }
    
    
    if(col-1 >=0 && arr[row][col-1] == 1) {
      psf.append("l") ; // left
      
      dfs(arr,row, col-1) ; 
    }
    
    psf.append("z") ; // this z symbol is special added when we backtrack to always make sure that we generate a unique string  
  }
  
  public static StringBuilder psf = new StringBuilder();
// we have taken the string builder insted of string as adding is done in O(1) in string builder and O(n) in string
  public static int numDistinctIslands(int[][] arr) {
    
    HashSet<String> set = new HashSet<>(); 
    
    for (int i =0 ; i<arr.length;i++){
      for (int j=0 ; j<arr[0].length ; j++){
        if (arr[i][j] == 1){
          psf = new StringBuilder() ; // making a new string builder so that everytime for a new search it starts fresh. 
          psf.append("x") ;
          
          dfs(arr,i,j) ; 
          set.add(psf.toString()) ; 
        }
      }
    }
    
    return set.size() ; // number of distinct islands 
  }
}