/*

1. You are given three strings - s1, s2 and s3.
2. You have to find whether s3 is formed by interleaving of s1 and s2.
3. s3 is interleaving if it contains all characters of s1 and s2, and order of all characters in individual string is preserved.


Input :
aabcc
dbbca
aadbbcbcac


Output :
true

*/

import java.io.*;
import java.util.*;


// Approach 2 : Tabulation approach 

public class Main {
  
  // tabulation method
  public static boolean solution2(  String s1, String s2,String s3){
    
    boolean [][] dp = new boolean [s1.length()+1][s2.length()+1] ;
    
    for (int i=0; i<dp.length; i++){
      for (int j = 0;j<dp[0].length;j++){
        
        if (i==0  && j==0){
          dp[i][j] = true ; 
        }
        
        
        else if (i==0){
          dp[i][j] = s2.charAt(j-1) == s3.charAt(i+j-1) ? dp[i][j-1] : false ;
        }
        
        else if (j==0){
          dp[i][j] = s1.charAt(i-1) == s3.charAt(i+j-1) ? dp[i-1][j] : false ; 
        }
        
        else {
          if (s1.charAt(i-1) == s3.charAt(i+j-1)){
            dp[i][j] = dp[i-1][j];
          }
          
          if (!dp[i][j] && s2.charAt(j-1) == s3.charAt(i+j-1) ){
            dp[i][j] = dp[i][j-1] ; 
          }
        }
      }
    }
    return dp[dp.length-1][dp[0].length-1] ; 
  }

  public static boolean solution(String s1, String s2, String s3,int i, int j ,Boolean [][] dp ) {
    if (i == s1.length () && j == s2.length()){
      return true ; 
    }
    
    
    if (dp[i][j] != null){
      return dp[i][j] ; 
    }
    
    
    
    if (i<s1.length () && s1.charAt(i) == s3.charAt(i+j)){
      boolean f1 = solution (s1,s2,s3,i+1,j,dp) ; 
      dp[i][j] = f1 ; 
      if (f1 == true){
        return true ; 
      }
    }
    
    
    if (j<s2.length() && s2.charAt(j) == s3.charAt(i+j)){
      boolean f2 = solution(s1,s2,s3,i,j+1,dp) ;
      dp[i][j] = f2; 
      if (f2 == true){
        return true ; 
      }
      
      
    }
    
    return false ; 
  
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();
    
    if (s1.length() + s2.length() != s3.length()){
      System.out.print("false") ; 
      return ; 
    }
    
    System.out.println(solution2(s1, s2, s3));
  }

}