/*

1. You are given an array(arr) of integers.
2. You have to find the count of arithmetic slices in the given array.
3. Arithmetic slice is defined as the sub-array having all its elements in A.P and the length of sub-array should be greater than or equal to 3

Input :
4
1
2
3
4

Output :
3
*/


import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		int [] dp = new int [arr.length] ;
    dp[0] = 0 ;
    dp[1] = 0 ;
    for (int i=2; i<arr.length; i++){
      int curr = i ;
      int prev = i-1 ;
      int preprev= i-2 ; 
      
      int sum = 0 ;
      
      if (arr[curr] - arr[prev] == arr [prev] - arr[ preprev]){
        sum += 1 + dp[i-1]; 
      }
      
      dp [i] = sum ;  
      
      
      
      
    }
		
    int ans = 0  ;
    for (int val : dp){
      ans += val ; 
    }
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}

