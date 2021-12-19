/*

1. You are given a string.
2. You have to find the minimum number of cuts required to convert the given string into palindromic partitions.
3. Partitioning of the string is a palindromic partitioning if every substring of the partition is a palindrome.

Input :
abccbc

Output :
2


*/

import java.io.*;
import java.util.*;

public class Main {

	public static int minPalindromicCut(String s) {
		
    int len = s.length() ;     
    boolean [][] dp = new boolean [len][len] ;
    
    // let us use the gap strategy 
    
    // making the boolean dp 
    for(int g=0; g<len; g++){
      for(int i=0,j=g; j<dp.length ; i++,j++){
        
        if (g == 0 ){
          dp[i][j] = true ; 
        }
        
        else if(g==1){
          // gap is one 
          dp [i][j] = s.charAt(i) == s.charAt(j) ; 
        }
        
        else {
          // gap is more than 2 
          if ( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
            dp[i][j] = true ; 
          }
          
          else {
            dp[i][j] = false ; 
          }
        }
      }
    }
    
    
    // making the min palindromic cut dp 
    
    int [][] mpc = new int [len][len] ;
    
    for (int g=0 ; g<s.length(); g++){
      for(int i=0,j=g ; j<mpc.length; i++,j++){
        
        if (g==0){
          mpc[i][j] = 0 ; 
        }
        
        else if (g==1){
          if (dp[i][j]){
            mpc[i][j] = 0 ; 
          }
          
          else{
            mpc[i][j] = 1 ; 
          }
          
        }
        
        else {
          // more than 2 gap 
          
          
          if (dp[i][j]){
            mpc[i][j] = 0 ;
          }
          
          else{
            int min  = Integer.MAX_VALUE ; 
          for(int  k =i; k<j;k++){
            int left = mpc[i][k] ;
            int right = mpc[k+1][j] ;
            
            if (left + right + 1 < min){
              min = left + right + 1 ; 
            }
            
          } 
          
          
          mpc[i][j] = min ; 
          }
          
          
          
        }
      }
    }
    
		return mpc[0][s.length()-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}