/*

1. You are given a string.
2. You have to print the count of distinct and non-empty subsequences of the given string. 

Note -> String contains only lowercase letters.

Input : 
abc

Ouput : 
7

*/


import java.util.*;
import java.io.*; 
public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
      int len = str.length() ;
      
      long [] dp = new long [len + 1] ;
      
      dp [0] = 1 ; // for empty subsequence
      
      HashMap<Character,Integer> lo = new HashMap<>() ; 
      for (int i = 1 ; i<dp.length ; i++){
        
        dp[i] = 2 * dp[i-1] ;
        
        char ch = str.charAt(i-1) ;
        
        if (lo.containsKey(ch)){
          int j = lo.get(ch);
          
          dp[i] =dp[i] - dp[j-1] ;
        }
        
        lo.put(ch,i) ; 
      }
      
        
System.out.println(dp[str.length()]-1) ; 
    }
}

