/*
1. You are given an array(arr) of integers. Values may be duplicated.
2. You have to find the length of the largest subarray with contiguous elements.

Note -> The contiguous elements can be in any order(not necessarily in increasing order).

Input :
3
10 12 11

Output :
3

*/

import java.util.*;

public class Main {

	public static int solution(int[] arr) {
	

    int ans = 0 ; 
    for (int i =0; i<arr.length-1 ; i++){
      int min = arr[i];
      int max = arr[i];
     HashSet <Integer> map = new HashSet<>() ;
      
      map.add(arr[i]) ; 
      for (int j=i+1; j<arr.length ; j++){
        if (map.contains(arr[j])){
          break ; 
        }
        
        map.add(arr[j]) ; 
        min =Math.min(min,arr[j]) ; 
        max = Math.max(max,arr[j]); 
       
        // main logic 
        
        if (max - min == j - i){
          int len = j - i + 1 ; 
          if (len > ans ){
             ans = len ; 
          }
        }
        
      }
    }
     

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr. length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
