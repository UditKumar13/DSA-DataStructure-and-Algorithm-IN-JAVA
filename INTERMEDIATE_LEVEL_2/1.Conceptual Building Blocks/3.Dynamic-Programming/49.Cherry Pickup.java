/*

1. You are given a number N, which represents the rows and columns of a 2-D matrix.
2. Matrix contains only three values - 
   a. Cell is empty.
   b. Cell contains a cherry.
   c. Cell contains a thorn and you can not pass through this cell.
3. You have to find the maximum number of cherries that you can collect following these rules :
   a. You have to start from (0,0) and travel till (N-1,N-1) by moving right or down, 
    one step at a time.
   b. After reaching (N-1,N-1), you have to come back to (0,0) by moving left or up, 
    one step at a time.   

Note -> If there is no valid path between the top-left cell and bottom-right cell, then no cherries can be collected.


Input :
3
0 
1 
-1
1 
0
-1
1 
1  
1

Output :
5

*/


import java.io.*;
import java.util.*;

public class Main {

	public static int cp(int r1, int c1, int r2, int[][] arr, int[][][] dp) {
		int c2 = r1 + c1 - r2 ; 
    
    
    if (r1>= arr.length || r2>= arr.length || c2>= arr[0].length || c1>= arr[0].length || arr[r1][c1] == -1 || arr[r2][c2] == -1){
      return Integer.MIN_VALUE ; 
    }
    
    if (r1 ==arr.length -1 && c1 == arr[0].length -1){
      return arr[r1][c1] ; 
    }
    
    if (dp[r1][c1][r2] !=0){
      return dp[r1][c1][r2] ; 
    }
    
    
    int cherries = 0 ;
    
    if (r1==r2 && c1==c2){
     cherries+= arr[r1][c1] ;  
    }
    
    else{
      cherries += arr[r1][c1] + arr[r2][c2] ;
      
      
    }
    
    int f1 = cp(r1,c1+1,r2,arr,dp); // h h 
    int f2 = cp(r1+1,c1,r2,arr,dp); // v,h
    int f3= cp(r1+1,c1,r2+1,arr,dp); // v,v
    int f4= cp(r1,c1+1,r2+1,arr,dp) ; // h,v
    
    cherries += Math.max(Math.max(f1,f2), Math.max(f3,f4));
    
    dp[r1][c1][r2] = cherries ;
    
    
		return cherries;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0 ; j < n; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		int ans = Math.max(0,cp(0, 0, 0, arr, new int[n][n][n]));
		System.out.println(ans);
	}

}