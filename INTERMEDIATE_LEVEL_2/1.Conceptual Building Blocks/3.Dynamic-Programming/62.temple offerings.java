/*

1. Pepcoder is wishing to give offerings to all the temples along a mountain range. 
2. The temples are located in a row at different heights.
3. You have to find the minimum number of offerings such that these conditions are fulfilled - 
    -> If two adjacent temples are at different heights, then the temple which is situated at greater height should receive more offerings.
    -> If two adjacent temples are at the same height, then their offerings relative to each other does not matter.
    
    
Input :
6
1 3 2 5 2 1
Output :
10

*/

import java.io.*;
import java.util.*;

public class Main {
	
	public static int totaloffering(int[] height) {
		int [] larr = new int [height.length] ;
    
    
    // filling the left array 
  larr[0] = 1 ;
    
    for (int i=1; i<larr.length; i++){
      if (height[i] > height[i-1]){
        larr[i] = larr[i-1] + 1 ; 
      }
      
      else {
        larr[i] = 1 ; 
      }
    }
    
    
    // filing the right array 
    
    
    int [] rarr = new int [height.length] ;
    
    rarr[height.length-1] = 1 ;
    
    
    for (int i= rarr.length-2 ; i>=0 ; i--){
      if(height[i] > height[i+1]){
        rarr[i] = rarr[i+1] + 1 ; 
      }
      
      else {
        rarr[i] = 1 ; 
      }
    }
		
    // summation of the maximum value between left and right 
    int ans = 0 ;
    
    for (int i =0 ; i<height.length ; i++){
      ans  += Math.max(larr[i],rarr[i]) ;
      
    }
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int height[] = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = scn.nextInt();
		}
		System.out.println(totaloffering(height));
	}

}