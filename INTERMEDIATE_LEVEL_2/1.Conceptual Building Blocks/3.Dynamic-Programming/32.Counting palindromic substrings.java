/*
1. You are given a string str.
2. You are required to print the count of palindromic substrings in string str.


Input :
abccbc

Output :
9

*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
      Scanner scn= new Scanner (System.in) ;
      
      String str = scn.nextLine() ;
      int len = str.length() ; 
      
      boolean [][] dp = new boolean [len][len] ;
      int cps = 0 ; // count pali substrings
      for (int g=0; g<len; g++){
        for(int i=0, j =g; j<dp.length; i++,j++){
          
          
          if (g==0){
             dp[i][j] = true ;             
          }
          
          else if(g==1){
            dp[i][j] = str.charAt(i) == str.charAt(j); 
          }
          
          else{
            
            if (str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true ){
              dp[i][j] = true ; 
            }
            
            else{
              dp[i][j] = false ; 
            }
          }
          
          
        if (dp[i][j]){
          cps ++ ; 
        }
        }
        
      }
      
      
      
      
      System.out.println(cps) ; 
    }

}