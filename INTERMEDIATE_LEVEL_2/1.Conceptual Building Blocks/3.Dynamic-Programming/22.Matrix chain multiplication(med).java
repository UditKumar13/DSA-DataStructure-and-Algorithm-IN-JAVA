import java.io.*;
import java.util.*;
/*
1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.


Input : 
3 n 
1  arr[1]
2
3 arr[n-1]

Output :
6
*/
public class Main {

	public static int mcm(int[] arr){
		//we will use the gap technique 
    
    int [][] dp = new int [arr.length-1][arr.length-1] ; 
    // g : gap 
    for (int g = 0 ; g<dp.length; g++){
      for (int i=0, j =g ; j<dp.length;i++,j++ ){
        if(g==0){
          // gap is 0
          // diagonal ele
          dp[i][j] = 0 ; 
        }
        
        else if(g==1){
          // gap is one
          dp[i][j] = arr[i] * arr[j] * arr[j+1] ; 
        }
        
        else{
          int min  = Integer.MAX_VALUE  ;
          
          for (int k=i ; k<j ; k++){
            int lc  = dp[i][k]; 
            int rc = dp[k+1][j]; 
            int mc =  arr[i] * arr[k+1] * arr[j+1] ;   
            int tc = lc + rc+mc ;
            if (tc < min){
              min = tc ; 
            }
          }
          
          dp[i][j] = min ; 
          
        }
      }
    }
   
    

		return dp[0][dp.length-1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(mcm(arr));
	}

	
}