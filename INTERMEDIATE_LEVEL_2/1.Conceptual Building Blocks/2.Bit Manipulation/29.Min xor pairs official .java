import java.io.*;
import java.util.*;
/*
1. You are given an array of distinct integers.
2. You have to print all pairs of integers in the array whose XOR value is minimum.
*/
public class Main {

    public static void solution(int[] arr) {
        // step 1 : sort the array
        
         Arrays.sort(arr);
         
        // step 2 : take the min value amongt the xor pairs of the consecutive numbers
        int min = Integer.MAX_VALUE; // + infinity 
        for (int i = 0 ; i< arr.length -1; i++){
            int xor  = (arr[i] ^ arr [i+1]) ; 
            min = Math.min (min,xor); 
        }
        
        // step 3 : to print those pairs 
        
        for (int i =0 ; i<arr.length-1; i++){
            if ((arr[i] ^ arr[i+1] ) == min ){
                System.out.print(arr[i] + ", " + arr[i+1]);
                System.out.println() ; 
            }
        }
        
        
        
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
        
    }
    
    
}