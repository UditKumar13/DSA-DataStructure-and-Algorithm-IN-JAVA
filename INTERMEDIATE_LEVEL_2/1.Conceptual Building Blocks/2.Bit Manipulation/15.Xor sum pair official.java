import java.io.*;
import java.util.*;
/*
1. You are given an array of integers.
2. You have to find the XOR of sum of all pairs in the array.
Input : 
5
1
5
2
1
2
*/
public class Main {

    public static int solution(int[] arr){
       int ans = 0 ;
       
       for(int val : arr){
           
           ans = ans ^  (2 * val) ;
           
       }
       
       return ans;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
    
}