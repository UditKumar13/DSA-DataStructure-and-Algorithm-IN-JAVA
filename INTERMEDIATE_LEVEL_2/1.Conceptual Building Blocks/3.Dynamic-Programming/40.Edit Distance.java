/*

1. You are given two strings s1 and s2.
2. You have to find the minimum number of operations needed to convert s1 to s2.
   Operations allowed are - 
   Insert - You can insert any character in s1.
   Remove - You can remove any character in s1.
   Replace - You can replace any character in s1 with any other character.
   
   Input:
   pepperatcoding
   pepcoding

   Output:
   5
*/

import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(String str1, String str2) {
		// edit distance 
    
    int [][] dp = new int [str1.length()+1][str2.length()+1] ; 
    
    for (int i = 0; i<dp.length; i++){
      for(int j=0;j<dp[0].length; j++){
        
        if(i==0 && j==0){
          dp[i][j] = 0 ;
        }
        
        else if(i==0){
          // first row 
          dp[i][j] = dp[i][j-1] + 1 ; 
        }
        
        else if(j==0){
          // first column 
          dp[i][j] = dp[i-1][j] + 1 ; 
        }
        
        
        else {
          char lc1 = str1.charAt(i-1);
          char lc2 = str2.charAt(j-1);
          
          if (lc1 == lc2){
            // last char matched
            // check diagonally
            
            dp[i][j] = dp[i-1][j-1] ; 
          }
          
          
          else {
           dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j])) + 1 ; 
          }
          
          
        }
      }
    }
    
    
    

		return dp[str1.length()][str2.length()];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}