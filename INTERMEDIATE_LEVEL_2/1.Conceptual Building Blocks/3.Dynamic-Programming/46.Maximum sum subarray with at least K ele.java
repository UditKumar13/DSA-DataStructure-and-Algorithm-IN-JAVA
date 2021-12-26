/*
1. You are given an array(arr) of integers and a number k.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least k elements.

Input:
3
1
2
3
2


Output:
6

*/

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr, int k) {
  
    int [] maxSum = new int [arr.length] ; 
    int csum = arr[0] ;
    
    int ans = Integer.MIN_VALUE   ;
    
    maxSum[0] = csum ; 
    // with the help of kadane's logic, we are able to store the max subarray sum of any element of arr  
    for (int i=1; i<arr.length; i++){
      if (csum >=0){
        csum += arr[i] ; 
      }
      
      else {
        csum = arr[i]  ;
       }
      
      
      if (maxSum[i] < csum){
        maxSum[i] = csum ; 
      }
    }
    
    int exactK = 0 ;
    // variable that store the first  k, size sliding window's sum 
    
    for (int i =0; i<k; i++){
      exactK += arr[i] ; 
    }
    
    if (exactK > ans){
      ans = exactK ; 
    }
    
    for(int i = k ; i< arr.length; i++){

      // updation rule where window slides just by 1 
      exactK += arr[i] - arr[i-k] ; // adding the new ele arr[i]  and subtracting the array ele which lies k steps back from the current index i.
      
      // again check the possibility 
      
      if (ans < exactK){
        ans = exactK ; 
      }
      
      int morethanK = maxSum[i-k] + exactK ;
      
      if (ans < morethanK){
       ans = morethanK ; 
      }
        
      
    }
    
    
    
    return ans;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k));
  }
}