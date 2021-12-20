/*

1. You are given a string str.
2. You are required to print the length of longest palindromic subsequence of string str.

 Input :
 abcgackbc
 
 Output :
 5
 
 
*/

import java.io.*;
import java.util.*;

public class Main {

   public static int mps (String uk){
     int len = uk.length() ; 
     
     // let us use the dp appraoch 
     
     int [][] dp = new int [len][len] ;
     
     
     for (int g=0;g<len;g++){
       for(int i=0,j=g; j<dp.length; i++,j++){
         if (g==0){
           dp[i][j] = 1 ; 
         }
         
         else if(g==1){
           if (uk.charAt(i) == uk.charAt(j)){
             dp[i][j] = 2 ; 
           }
           else{
             dp[i][j]  = 1 ; 
           }
         }
         
         else{
           // if the gap is greater than 2
           if (uk.charAt(i) == uk.charAt(j)){
             dp[i][j] = 2 + dp[i+1][j-1] ; 
           }
           
           else{
             dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]) ; 
           }
         }
       }
     }
     
     return dp[0][len-1] ; 
   }
  
  
    public static void main(String[] args) throws Exception {
      
      Scanner scn = new Scanner(System.in) ;
      String str = scn.nextLine() ; 
      int ans  = mps(str);
      
      System.out.println(ans);
    }

}