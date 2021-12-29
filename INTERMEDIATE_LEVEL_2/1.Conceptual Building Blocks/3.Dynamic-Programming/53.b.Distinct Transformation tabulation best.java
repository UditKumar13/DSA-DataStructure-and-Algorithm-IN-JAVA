/*

1. You are given two strings S1 and S2.
2. You have to find the number of unique ways in which you can transform S1 to S2.
3. Transformation can be achieved by removing 0 or more characters from S1, such that the sequence formed by the remaining characters of S1 is identical to S2.

Input :
abcccdf
abccdf
Output :
3

*/


// tabulation method 


import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s, String t){
    
    // tabulation method 
    int [][] dp = new int [t.length()+1][s.length()+1] ;
    
    
    for (int i = dp.length-1; i>=0; i--){
      for (int j= dp[0].length-1 ; j>=0 ; j--){
        
        
        if (i==dp.length-1 && j == dp[0].length-1){
          dp[i][j] = 1 ;           
        }
        else if (i== dp.length-1){
          // last row 
          dp[i][j] = 1;  
        }
        
        else if (j == dp[0].length-1){
          dp[i][j] = 0 ; 
        }
        
        
        else {
          char c1 = t.charAt(i) ;
          char c2 = s.charAt(j) ;
          
          if (c1 != c2){
            dp[i][j] = dp[i][j+1] ; 
          }
          
          
          else{
            dp[i][j] = dp[i+1][j+1] + dp[i][j+1] ; 
          }
        }
      }
    }
      
    return dp[0][0] ; 
  }
  

	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
    

    
    
		System.out.println(solution(s1, s2));
	}

}