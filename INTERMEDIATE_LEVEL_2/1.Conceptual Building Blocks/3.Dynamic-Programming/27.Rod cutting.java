/*

1. You are given an integer N, which represents the length of a rod, and an array of integers, which represents the prices of rod pieces of length varying from 1 to 
     N.
2. You have to find the maximum value that can be obtained by selling the rod.
3. You can sell it in pieces or as a whole.


Input :
8
1   
5   
8   
9  
10 
17  
17  
20

Ouptput :
22

*/



import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] prices) {
    int [] np = new int [prices.length+1];
    
    for(int i=0;i<prices.length;i++){
      np[i+1] = prices [i] ;  
    }
    
    int [] dp = new int [np.length] ;
    
    dp [0] = 0 ; 
    dp[1]  = np[1] ;
    
    
    for (int i=2;i<np.length ; i++ ){
      dp[i] = np[i] ;
      
      int li = 1 ;
      int ri = i-1 ;
      
      while(li <=ri){
        
        
        if(dp[li] + dp[ri] > dp[i]){
          dp[i] = dp[li] + dp[ri] ; 
        }
        
        li++;
        ri-- ; 
      }
    }
    
    

    return dp[dp.length-1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] prices = new int[n];
    for (int i = 0; i < n; i++) {
      prices[i] = scn.nextInt();
    }
    System.out.println(solution(prices));
  }

}