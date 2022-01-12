/*
1. You are given an array(arr) of integers and a number K.
2. You have to find the count of distinct numbers in all windows of size k.

Input :
7
1 2 1 3 4 2 3        
4

Output :
3 4 4 3
*/

import java.util.*;

public class Main {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		
    ArrayList<Integer> list = new ArrayList<>() ; // arr ele, freq
    
    HashMap <Integer, Integer> map = new HashMap<>() ; 
    int i = 0 ; 
    while(i <= k-2){
      int of =  map.getOrDefault(arr[i], 0) ; 
      map.put(arr[i], of + 1) ;
      i++ ; 
    }
    
    i-- ;
    int j = -1 ; 
    
    while(i<arr.length-1){
      i++ ; 
      
      map.put(arr[i] , map.getOrDefault(arr[i],0) + 1) ;  // acquire
      list.add(map.size()); // work of cal distinct 
      
      // release 
      j++ ;
      int freq = map.get(arr[j]);
      
      if (freq == 1){
        map.remove(arr[j]);
      }
      
      else {
        map.put(arr[j], freq-1);
      }
    }

		return list;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}
