/*
1. You are given two strings S1 and S2.
2. You have to make these two strings equal by deleting characters. You can delete characters from any of the two strings.
3. The cost of deleting a character from any string is the ASCII value of that character.
4. You have to find the minimum ASCII sum of deleted characters.

Input :
sea
eat

Output :
231
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2) {
  
    int [][] dp = new int [s1.length()+1][s2.length()+1];
    
    for(int i=dp.length-1; i>=0;i--){
      for(int j=dp[0].length-1; j>= 0 ; j--){
        
        
        if(i==dp.length-1 && j==dp[0].length-1){
          // last ele
          
          dp[i][j]  = 0 ; 
        }
        
        else if(i==dp.length-1){
          // last row 
          
          dp[i][j] = (int)s2.charAt(j) + dp[i][j+1] ;  
        }
        
        
        else if(j==dp[0].length-1){
          // last column 
          
          dp[i][j] = (int)s1.charAt(i) + dp[i+1][j] ;
        }
        
        
        else {
          if (s1.charAt(i) == s2.charAt(j)){
            // c1 == c2 
            dp[i][j] =   dp[i+1][j+1];
          }
          
          else{
            dp[i][j] = Math.min ((int)s1.charAt(i) +dp[i+1][j] , (int)s2.charAt(j) + dp[i][j+1] );
          }
        }
      }
    }
    
    

		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}