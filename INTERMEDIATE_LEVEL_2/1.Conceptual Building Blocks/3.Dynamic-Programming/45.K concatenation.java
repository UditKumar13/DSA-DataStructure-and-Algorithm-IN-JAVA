/*

1. You are given an array(arr1) of integers and an integer k.
2. Another array(arr2) is formed by concatenating K copies of arr1.
   For example, if arr1 = {1,2} and k = 3, then arr2 = {1,2,1,2,1,2}.
3. You have to find the maximum subarray sum in arr2.

Input :
3
1
2
3
3
Output :
18
*/

import java.io.*;
import java.util.*;

public class Main {
  
  
  public static int kadane(int [] arr){
      
      int csum  = arr[0] ;
      int osum = arr[0] ; 
      
      for(int i =1; i<arr.length; i++){
        
        
        if(csum >=0 ){
          csum += arr[i] ; 
        }
        
        else {
          csum = arr[i];
        }
        
        
        if(osum < csum ){
          osum = csum ; 
        }
      }
      
    return osum ; 
    }
  
  
  
    public static int kadaneOfTwo(int [] arr){
      // make a duplicate array of double the length 
      int [] narr = new int [2* arr.length] ; 
      for(int i=0 ; i<arr.length ; i++){
        narr[i] = arr[i] ; 
      }
      
      for(int uk=0; uk<arr.length ;uk++){
        narr[uk + arr.length] = arr[uk] ; 
      }
      
      // now we will applly the kadane of this new array 
      
      return kadane(narr) ;
      
    }

  public static long solution(int[] arr, int k, long sum) {
    
    if (k==1){
      return kadane(arr) ; 
    }
    
    else if (sum<0){
      return kadaneOfTwo(arr) ; 
    }
    
    else {
      return kadaneOfTwo(arr) + (k-2)*sum ; 
      
    }
    
    

    
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
      sum += arr[i];
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k, sum));
  }

}