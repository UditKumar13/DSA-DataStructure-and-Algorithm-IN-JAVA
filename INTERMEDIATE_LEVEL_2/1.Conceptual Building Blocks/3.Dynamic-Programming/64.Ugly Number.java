/*
1. You are given a number N.
2. You have to find Nth ugly number.
3. Ugly number is defined as the number whose prime factors are only 2,3 and 5.  
4. First eleven ugly numbers are -> 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15.

Assumption -> 1 is the first ugly number.

Input :
4

Output :

4

*/

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int n) {

    
    int [] dp = new int [n+1] ;
    
    dp[1] = 1 ;
    
    int p2 = 1 ;
    int p3 = 1 ;
    int p5 = 1 ;
    
    
    for (int i=2 ; i<=n; i++){
      
      
      int v2 = 2*dp[p2] ;
      int v3 = 3*dp[p3];
      int v5 = 5*dp[p5];
      
      
      int min = Math.min(v2, Math.min(v3,v5)) ;
      
      
      dp[i] = min ; 
      if (min == v2){
        p2 ++ ; 
      }
      
      
      
      if(min == v3){
        p3++ ; 
      }
      
      
      if (min == v5){
        p5++ ; 
      }
      
      
      
      
      
    }
    

    return dp[n];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }

}