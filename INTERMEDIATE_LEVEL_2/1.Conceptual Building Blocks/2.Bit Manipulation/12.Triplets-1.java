import java.io.*;
import java.util.*;
/*
1. You are given an array(arr) of N numbers.
2. You have to select three indices i,j,k following this condition -> 
      0 <= i < j <= k < arr.length
3. Two numbers X and Y as defined as :
      X = arr[i] ^ arr[i+1] ^ ... ^ arr[j - 1]
      Y = arr[j] ^ arr[j+1] ^ ... ^ arr[k]
4. You have to print the number of triplets where X is equal to Y.

Input :
3
1 2 3


The trick : X =Y this means, X-Y = 0, i to j=k tak, we should have all xor equal to zero , j can be (i+1 to k )
*/
public class Main {

	public static void solution(int[] arr){
		// we have to take the pointers to maintain the Trick : 
		int num_triplets  = 0 ;
		
		for (int i = 0 ; i<arr.length; i++){
		    int val = arr[i] ; 
		    for(int k = i+1; k<arr.length; k++){
		        val = val ^ arr[k] ;
		        
		        if(val == 0 ){
		            num_triplets += k -i ; 
		        }
		    }
		    
		}
		
		System.out.println(num_triplets); 
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
	
	
}