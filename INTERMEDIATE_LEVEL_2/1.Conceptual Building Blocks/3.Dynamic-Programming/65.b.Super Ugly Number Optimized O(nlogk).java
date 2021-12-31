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
  
  
  public static class Pair implements Comparable<Pair>{
    int prime ; 
    int pointer  ; 
    int value ;
    
    
    Pair (int prime, int pointer, int value){
      this.prime = prime;
      this.pointer = pointer ; 
      
      this. value = value ; 
      
    }
    
    public int compareTo (Pair o){
      return this.value - o.value ; 
      // making priority queue based on the min value  
    }
  }

  public static int solution(int[] primes, int n) {
int [] dp = new int [n+1]  ;
    
    PriorityQueue<Pair> pq = new PriorityQueue<>() ;
    
   for(int i=0 ; i<primes.length; i++){
     pq.add(new Pair(primes[i], 1, primes[i])) ;  // prime pointer value 
     
   } // initially 
    
    
    dp[1] = 1 ;
    
    for (int i=2 ; i<=n ; i++){
      Pair rp = pq.remove() ;  // log k time operation 
      // check condition very crucial 
      
      
      if( dp[i-1] != rp.value){
        dp[i] = rp.value;
        i++ ; 
      }
      
      pq.add(new Pair(rp.prime, rp.pointer+1 , rp.prime * dp[rp.pointer + 1])) ;  // log k
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
