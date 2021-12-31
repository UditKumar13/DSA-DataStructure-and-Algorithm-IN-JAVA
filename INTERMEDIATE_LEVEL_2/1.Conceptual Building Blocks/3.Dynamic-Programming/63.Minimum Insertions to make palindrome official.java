/*

1. You are given a string(str).
2. You have to find the minimum number of characters to be inserted to convert it to a palindrome.


Input :
pepperatcoding


Output :
10

*/

import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(String str) {
    int  n  = str.length() ; 
		int [][] dp = new int [n][n] ;
    
    for (int g=0 ; g<dp.length; g++){
      for (int i=0, j = g ; j<dp.length; i++,j++){
        if (g==0){
          dp[i][j] = 1 ; 
        }
        
        
        else{
          if (str.charAt(i) == str.charAt(j)){
            dp[i][j]  = dp[i+1][j-1] + 2 ; 
          }
          
          
          else {
            // c1 != c2
            dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])  ; 
          }
        }
      }
    }

    // str.length() - lps 
    int ans = n -  dp[0][n-1];
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}
}