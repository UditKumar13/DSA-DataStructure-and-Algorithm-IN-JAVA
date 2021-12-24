/*
1. You are given a string str.
2. You have to find the length of longest subsequence which is appearing twice in the string.
3. Every ith character in both the subsequences must have different indices in the original string.
Input :
abcdgh
Output:
0
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str){
int len  = str.length() + 1  ; 
int [][] dp = new int [len][len] ;
    
for(int i= dp.length-1 ; i>=0; i--){
  for(int j= dp[0].length-1; j>=0;j--){
    
    
    if(i==dp.length-1 && j==dp[0].length-1){
      dp[i][j] = 0 ;  
    }
    
    else if(i==dp.length-1){
      
      // last row 
      dp[i][j] = 0 ; 
    }
    
    
    else if(j==dp[0].length-1){
      // last column 
      dp[i][j] = 0 ; 
    }
    
    
    
    else {
      char c1 = str.charAt(i);
      char c2 = str.charAt(j);
      
      
      if (c1 == c2 && i!=j){
        
        // character is matching with the different index
        dp[i][j] = dp[i+1][j+1] + 1 ; 
      }
      
      else{
        dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
      }
    }
    
    
  }
}
    
    
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}

