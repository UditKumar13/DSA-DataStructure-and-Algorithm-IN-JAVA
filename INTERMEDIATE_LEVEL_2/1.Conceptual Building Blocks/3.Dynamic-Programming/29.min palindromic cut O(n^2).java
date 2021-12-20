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
    
    
    // Doing  in the 0(n^2)
    
    int [] mpc = new int [s.length()] ;
    mpc[0] = 0 ;
    
    for(int j=1; j<mpc.length; j++){
      
      if (dp[0][j]){
        mpc[j] = 0  ; 
      }
      
      else{
        
      // for the suffix checking whether they are boolean or not 
      int min  = Integer.MAX_VALUE ; 
      for(int i=j; i>=1 ; i--){
        
        
        
        if (dp[i][j]){
          if (mpc[i-1] < min){
            min = mpc[i-1];
          }
        }
      }
      
      mpc[j] = min + 1;  
      
    }
      }
    
  return mpc[mpc.length-1] ; 
  }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}