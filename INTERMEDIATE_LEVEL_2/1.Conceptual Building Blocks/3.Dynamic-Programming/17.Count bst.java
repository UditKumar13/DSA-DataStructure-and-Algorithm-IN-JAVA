import java.io.*;
import java.util.*;
/*
1. You are given a number n, representing the number of elements.
2. You are required to find the number of Binary Search Trees you can create using the elements.

Input :
4
Output :
14
*/
public class Main{

public static void main(String[] args) throws Exception {
  
  Scanner scn = new Scanner (System.in) ;
  int n = scn.nextInt()  ;
  int [] dp = new int [n+1] ; 
  dp[0] = 1;
  dp[1] = 1;
  
  for (int i = 2 ; i<=n ; i++){
    int l= 0 ;
    int r = i-1 ; 
    
    while(l <= i-1){
      dp[i] += dp[l]* dp[r];
      l++;
      r--;
    }
  }
  System.out.println(dp[n]); 
 }

}