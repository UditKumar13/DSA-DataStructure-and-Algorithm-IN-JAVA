/*
1. You are given an array(arr) of length N, where N is an even number.
2. The elements of the array represent N coins of values arr1,arr1...arrN.
3. You are playing a game against an opponent in an alternative way, where the opponent is equally smart.
4. In this game, a player selects either the first or the last coin from the row in every turn, removes it from the row permanently, and receives the value of the coin.
5. You have to find the maximum possible amount of money you can win if you make the first move.

Input :
4
5
3
7
10

Output :
15

*/

import java.io.*;
import java.util.*;

public class Main {

	public static void optimalStrategy(int[] arr) {
		
    int [][] dp = new int [arr.length][arr.length] ;
    
    // gap straetgy
    // have to choose the extremes every time 
    for (int g=0 ; g<dp.length ; g++){
      for (int i=0 , j=g; j<dp.length ; i++,j++){
        
        if (g==0){
          // only 1 ele
          dp[i][j] = arr[i];
        }
        
        else if (g==1){
          // 2 ele
          dp[i][j] = Math.max(arr[i],arr[j]) ; 
        }
        
        
        else {
          int val1 = arr[i] + Math.min(dp[i+2][j],dp[i+1][j-1]) ;
          
          int val2 = arr[j] + Math.min(dp[i+1][j-1],dp[i][j-2]) ;
          
          // we have taken the min because it was opponent moves , we have chosen the worst for us 
          
          // but our own move is in our own hands, so lets choose the best there 
          
          int val = Math.max(val1,val2);
          dp[i][j] = val ; 
        }
      }
    }
    
	System.out.println( dp[0][arr.length-1]) ; 
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scn.nextInt();
		}
		optimalStrategy(a);
	}

}