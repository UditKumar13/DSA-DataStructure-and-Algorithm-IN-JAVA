/*
1. You are given an array(arr) of positive numbers and two numbers X and Y.
2. You have to find the maximum sum of elements in two non-overlapping subarrays.
3. One subarray must of length X and the other must be of length Y.

Input :
9
0 6 5 2 2 5 1 9 4
1
2

Output :
20


*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr, int x, int y){
	
    
    // case 1 : X and then Y
    // calculating the sum left to right  with gap x 
    
    int [] dp1 = new int [arr.length] ;
    int [] dp2 = new int [arr.length] ;
    
    
    int sum = 0 ; 
    for (int i =0 ; i<dp1.length; i++){
      if (i<x){
        sum += arr[i] ; 
        dp1[i] = sum ; 
      } 
      
      else {
        sum += arr[i] - arr[i-x] ; // subtracting the previous  x distance  one element 
        
        dp1[i] = Math.max(dp1[i-1] , sum ) ;
        
        
        
      }
      
    }
    
    
    
    // right to left in y case  : 
    
    
    sum =0  ;
    
    for(int i =arr.length-1; i>=0 ; i-- ){
      
      
      if ( i + y >= arr.length ){
        sum += arr[i] ;
        dp2[i] = sum ; 
      }
      
      else {
        
        sum += arr[i] - arr[i+y] ; 
        
        dp2[i] = Math.max(dp2[i+1],sum) ;
      }
    }
    
    // calculating the ans for case 1 :
    int ans = 0 ; 
    for (int i = x-1 ; i<arr.length-y; i++){
      ans = Math.max(dp1[i] + dp2[i+1] ,ans);
      
      
    }
    
    
    
    // Case 2 if Y first then X :
    
       dp1 = new int [arr.length] ;
       dp2 = new int [arr.length] ;
    
    
     sum = 0 ; 
    for (int i =0 ; i<dp1.length; i++){
      if (i<y){
        sum += arr[i] ; 
        dp1[i] = sum ; 
      } 
      
      else {
        sum += arr[i] - arr[i-y] ; // subtracting the previous  x distance  one element 
        
        dp1[i] = Math.max(dp1[i-1] , sum ) ;
        
        
        
      }
      
    }
    
    
    
    // right to left in y case  : 
    
    
    sum =0  ;
    
    for(int i =arr.length-1; i>=0 ; i-- ){
      
      
      if ( i + x >= arr.length ){
        sum += arr[i] ;
        dp2[i] = sum ; 
      }
      
      else {
        
        sum += arr[i] - arr[i+x] ; 
        
        dp2[i] = Math.max(dp2[i+1],sum) ;
      }
    }
    
    // calculating the ans for case 1 :
    
    for (int i = y-1 ; i<arr.length-x; i++){
      ans = Math.max(dp1[i] + dp2[i+1] ,ans);
      
      
    }
    
    
    
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(arr,x,y));
	}

}