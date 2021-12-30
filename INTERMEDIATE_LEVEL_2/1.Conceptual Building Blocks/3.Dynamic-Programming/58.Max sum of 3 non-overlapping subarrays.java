/*
1. You are given an array(arr) of positive numbers and a number K.
2. You have to find the maximum sum of elements in three non-overlapping subarrays.
3. Also, you have to print indices representing the starting position of every subarray.
4. If there are multiple answers, print the lexicographically smallest one.

Input :

8
1 2 1 2 6 7 5 1 
2

Output :
23 0 3 5 


*/


import java.io.*;
import java.util.*;

public class Main {

	public static void solution(int[] arr, int k){
    
    int n  = arr.length ; 
		int [] left = new int [n];
    int [] right = new int [n] ;
    int [] pSum = new int [n] ;
    
    int sum =0 ; 
    
    
    
    for (int i=0 ; i<n ; i++){
      if (i==0){
        pSum[i] = arr[i] ; 
      }
      
      else {
        pSum[i] = pSum[i-1] + arr[i] ; 
      }
    }
    
    
    for (int i = 0 ; i<n ; i++){
      
      if (i<k){
        
        sum += arr[i] ;
        left[i] = sum ; 
      }
      
      
      else {
        
        sum += arr[i] - arr[i-k] ;
        
        left[i] = Math.max(left[i-1],sum) ; 
      }
    }
    
    sum = 0 ;
    
    for (int i=n-1 ; i>=0 ; i--){
      
      
      if (i+k >= n ){
        sum += arr[i] ;
        right [i] = sum ; 
      }
      
      else {
        sum += arr[i] - arr[i+k];
        right[i] = Math.max(right[i+1], sum ); 
      }
    }
    
      int maxSum = 0 ;
      int lsum = 0 ;
      int rsum = 0 ;
    
      int spmsa = -1;
    
    
    
    for (int i = k ; i<= n-2 * k ; i++){
      
      
      // maxSum =  Math.max(left[i-1] + right[i+k] + pSum[i+k-1] - pSum[i-1],maxSum); 
      
      if (maxSum < left[i-1] + right[i+k] + pSum[i+k-1] - pSum[i-1]){
        maxSum = left[i-1] + right[i+k] + pSum[i+k-1] - pSum[i-1] ; 
        
        spmsa = i ; 
        lsum = left[i-1] ;
        rsum = right[i+k] ; 
      }
    }
    
    System.out.print(maxSum + " ") ; 
		
    for (int i = k -1 ; i<spmsa ; i++){
      if (pSum[i] - (i-k == -1?0:pSum[i-k] )== lsum){
        System.out.print((i-k +1) + " ") ;
        break ; 
        
      }
    }
    
    System.out.print(spmsa + " ") ;
    
    for (int  i = spmsa + (2*k) -1 ; i<n  ; i++){
      if (pSum[i] - pSum[i-k] == rsum ){
        System.out.print((i-k+1) + " ") ;
        break ; 
      }
    }
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}
