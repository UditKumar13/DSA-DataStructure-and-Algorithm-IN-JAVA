/*
1. You are given an array(arr) of positive numbers and two numbers M and K.
2. You have to find the maximum sum of M non-overlapping subarrays of size K.
3. The size of the given array(arr) is greater than M*K.

Input :

7
2 10 7 18 5 33 0
3
1

Output :
61

*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr, int idx,int m, int k,int [] pSum, int[][] dp){
    
    if (m == 0 ){
      return 0 ; 
    }
    
    
    if (idx >= arr.length){
      return  0 ; 
    }
    
    if (dp[idx][m] != 0 ){
      return dp[idx][m] ; 
    }
		int exclude  = solution(arr,idx+1, m, k, pSum,dp); 
    int include = pSum[idx]+solution(arr,idx+k,m-1,k,pSum,dp) ;
    
    int ans = Math.max(include,exclude) ; 
		dp[idx][m] = ans ; 
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
    
        int m = scn.nextInt();
        int k = scn.nextInt();
    int [] pSum = new int [n] ;
    
    int sum =0 ;
    for (int i=0; i<k ; i++){
      sum += arr[i] ; 
    }
    
    
    pSum[0] = sum ;
    
    for (int i = k, j = 0; i <n ;   j++, i++){
      sum += arr[i] - arr[j]  ;
      pSum[i-k+1] = sum; 
    }
    
    
    
        System.out.println(solution(arr,0, m , k,pSum, new int[arr.length][m+1]));
	}

}