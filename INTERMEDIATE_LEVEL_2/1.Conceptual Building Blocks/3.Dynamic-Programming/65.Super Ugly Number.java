/*

1. You are given an array(arr) of size k which contains prime numbers in ascending order, and an integer N.
2. You have to find Nth super ugly number.
3. Super ugly number is defined as the number whose prime factors are elements of the given array.

Assumption -> 1 is the first super ugly number.

Input :

4
3 5 7 11
13


Output :

45
*/

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] primes, int n) {
   int [] pointers  = new int [primes.length] ;
    
    Arrays.fill (pointers,1) ;
    
    int [] dp = new int [n+1 ] ;
    dp[1] = 1 ;
    
    for (int i=2 ; i<=n; i++){
      int min = Integer.MAX_VALUE ; 
      for (int j=0; j<primes.length; j++){
        min = Math.min(min, primes[j] * dp[pointers[j]]) ; 
      }
      
      dp[i] = min ; 
      
      for (int j = 0 ; j<primes.length; j++){
        if (primes[j] * dp[pointers[j]] == min){
          pointers[j] ++ ; 
        }
      }
      
      
      
    }
return dp[n] ; 
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int k = scn.nextInt();
    int[] primes = new int[k];
    for (int i = 0 ; i < k; i++) {
      primes[i] = scn.nextInt();
    }
    int n = scn.nextInt();
    System.out.println(solution(primes, n));
  }

}
