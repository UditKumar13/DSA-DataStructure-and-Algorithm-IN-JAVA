/*

1. You are given two arrays of integers arr1 and arr2.
2. You have to find the maximum length of subarray that appears in both the given arrays.

Input :

5
5 4 3 2 1
6
7 8 4 3 2 5
Output :
3

*/

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr1, int[] arr2) {
    int [][] dp = new int [arr1.length +1 ][arr2.length+1] ;
    
    for (int i=1; i<dp.length ; i++){
      for(int j=1; j<dp[0].length; j++){
        
      
        
        
      
          int v1 = arr1[i-1] ;
          int v2 = arr2[j-1] ;
          
          if (v1 == v2){
            dp[i][j] = dp[i-1][j-1] + 1 ; // diagonal ele + 1 
          }
          
          
         
            
        
      }
    }
    
    // find max in the dp array 
    
    int ans = 0 ;
    
   for(int i= 0 ; i<dp.length ; i++){
     for(int j=0 ; j<dp[0].length; j++){
       
       ans = Math.max(ans,dp[i][j]); 
     }
   }
return ans ; 
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr1 = new int[n];
    for (int i = 0 ; i < n; i++) {
      arr1[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int[] arr2 = new int[m];
    for (int i = 0 ; i < m; i++) {
      arr2[i] = scn.nextInt();
    }
    System.out.println(solution(arr1, arr2));
  }

}