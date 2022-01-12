/*

1. You are given an array(arr) of integers.
2. You have to find the length of the largest subarray with sum 0.

Input :
8
15 -2 2 -8 1 7 10 23


Output :
5


*/

import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		
  HashMap <Integer, Integer> map = new HashMap<>() ; // sum , index
    
  int mlen = 0 ;
  int i =-1 ; 
  int sum = 0 ;
    
  map.put(sum, i ); 

    while(i<arr.length-1){
      i++ ; 
      sum += arr[i] ; 
      if (map.containsKey(sum) == false){
        map.put(sum,i) ; 
      }
      
      else{
        int len =  i - map.get(sum);
        
        if (len > mlen){
          mlen = len ; 
        }
      }
    }
		return mlen ;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
