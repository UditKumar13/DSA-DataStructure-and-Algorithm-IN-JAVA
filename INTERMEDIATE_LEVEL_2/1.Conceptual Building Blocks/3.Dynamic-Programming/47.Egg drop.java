/*

This is the question which was asked by Rahul tyagi in msit. 

1. You are given two integers N and K. N represents the number of eggs and K represents the number of floors in a building.
2. You have to find the minimum number of attempts you need in order to find the critical floor in the worst case while using the best strategy.
3. The critical floor is defined as the lowest floor from which you drop an egg and it doesn't break. 
4. There are certain which you have to follow -
   a. All eggs are identical.
   b. An egg that survives a fall can be used again.
   c. A broken egg can't be used again.
   d. If the egg doesn't break at a certain floor, it will not break at any floor below.
   e. If the egg breaks at a certain floor, it will break at any floor above.
   
Input :
3
10

Output :
4
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int eggDrop(int n, int k){
		int [][] dp = new int [n+1][k+1] ;
    
    for(int e=1; e<dp.length; e++){
      for (int f=1; f<dp[0].length; f++){
        if (e==1){
          dp[e][f] = f ; 
        }
        
        else if(f==1){
          dp[e][f] = 1; 
        }
        
        
        else {
          int min = Integer.MAX_VALUE ; 
          
          
          for (int mf=f-1, pf=0 ; mf >= 0 ; mf--, pf++){
            int v1 = dp[e][mf] ; // egg survive 
            int v2 = dp[e-1][pf] ; // egg breaks
            
            
            int val = Math.max (v1,v2);
            
            min = Math.min (val,min); 
          }
          
          
          dp[e][f] = min +1 ; 
          
        }
      }
    }

		return dp[n][k];
	} 

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//n -> number of eggs and k -> number of floors
		int n = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(eggDrop(n,k));
	}
	
}





