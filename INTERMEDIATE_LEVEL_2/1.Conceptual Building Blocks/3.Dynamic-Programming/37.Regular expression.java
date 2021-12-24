/*
1. You are given two strings S1 and S2. S1 represents a text and S2 represents a pattern.
2. You have to print 'true' if the pattern is matched with the given text, otherwise print 'false'.



Input :
aa
a

Output :
false


*/

import java.io.*;
import java.util.*;

public class Main {

	public static boolean solution(String s, String p) {
		boolean [][] dp = new boolean [p.length()+1][s.length()+1] ;
    
    for(int i= 0 ; i<dp.length; i++){
      for(int j =0 ; j<dp[0].length; j++){
        if (i==0 && j==0){
          dp[i][j] = true ; 
        }
        
        else if(i==0){
          // first row 
          dp[i][j] = false  ; 
        }
        
        else if(j==0){
          // first column
          char ch = p.charAt(i-1) ;  // i will be never zero 
          if(ch == '*'){
            // look 2 rows up 
            
            dp[i][j] = dp[i-2][j] ; 
          }
          
          else {
            dp[i][j] = false ; 
          }
          
        }
        
        
        else {
          // remaining dp 
          
          
          char  pc = p.charAt(i-1) ;
          
          char sc = s.charAt(j-1) ;
          
          if (pc == '*'){
            dp[i][j] = dp[i-2][j] ;
            
            char pslc = p.charAt(i-2) ;
            
            
            if (pslc == '.' || pslc == sc){
              dp [i][j] = dp[i][j] || dp[i][j-1]  ; 
            }
          }
          
          else if(pc =='.'){
            dp[i][j] = dp[i-1][j-1] ; 
          }
          
          else if(pc == sc){
            dp[i][j] = dp[i-1][j-1] ;
          }
          
          else {
            
            dp[i][j] = false ; 
                }
          
          
        }
      }
    }
		
		return dp[p.length()][s.length()];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}