/*
1. You are given a string str.
2. You are required to print the count of palindromic subsequences in string str.

Input :
ccbbgd

Output :
8
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

      Scanner scn = new Scanner (System.in) ;
      String str = scn.nextLine() ; 
      int len  = str.length() ; 
      int [][] dp = new int [len][len] ;
      
      // gap strategy 
      
      for(int g=0 ; g<len ; g++){
        for(int i=0,j = g; j<dp.length ; i++,j++){
          
          if(g==0){
            dp[i][j] = 1; 
          }
          
          else if(g==1){
             dp[i][j] = str.charAt(i) == str.charAt(j) ? 3:2; 
          }
          
          else{
            
            if(str.charAt(i) == str.charAt(j)){
              // 1 == 4
              dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1; 
            }
            
            
            
            else{
              dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1]; 
              
            }
          }
        }
      }
      
      System.out.println(dp[0][dp.length-1]) ; 
    }

}

