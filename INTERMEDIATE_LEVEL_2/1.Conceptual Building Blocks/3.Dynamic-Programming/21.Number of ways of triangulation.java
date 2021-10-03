import java.io.*;
import java.util.*;
/*
1. You are given a number N, which represents the number of sides in a polygon.
2. You have to find the total number of ways in which the given polygon can be triangulated.

Input : 
5

Output :
5

*/
public class Main {

	public static int solution(int n){
		n = n-2 ;
    // for this question 
    
    int [] dp = new int [n+1] ;
    dp[0] = 1 ;
    dp[1] = 1 ;
    for (int i =2 ;i<=n; i++ ){
      int l =0 ; 
      int r = i-1 ; 
      while(l<=i-1){
        dp[i] += dp[l] * dp[r] ; 
        l++ ; 
        r-- ; 
      }
    }
		
		return dp[n];
	 }
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}