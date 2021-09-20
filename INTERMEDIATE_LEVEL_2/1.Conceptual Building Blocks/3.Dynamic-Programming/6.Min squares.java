import java.io.*;
import java.util.*;
/*
Input : 35 
Output : 3
*/
public class Main {

	public static int solution(int n){
		int [] dp = new int [n+1] ;
        dp[0] = 0 ;
        dp[1] = 1 ; 
        for (int val= 2; val<=n ; val++){
            int min = Integer.MAX_VALUE ; 
            // already calculated : ac
            for (int ac = 1 ; ac *ac  <=val ; ac++){
                int rem = val - ac * ac ;
                if (dp[rem] < min){
                    min = dp [rem] ; 
                }
            }
            
            dp [val] = min + 1 ;
            
        }
        return dp[n];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}


	
}