/*

1. You are given two strings S1 and S2.
2. You have to find the number of unique ways in which you can transform S1 to S2.
3. Transformation can be achieved by removing 0 or more characters from S1, such that the sequence formed by the remaining characters of S1 is identical to S2.

Input :
abcccdf
abccdf
Output :
3

*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s, String t , int si , int ti , int [][] dp ) {

    if (si == s.length()){
      if (ti < t.length()){
        return 0 ; 
        // source purra target bacha hai so can't add 
      }
      
      else {
        return 1 ; // there is one way 
      }
    }
    
    
    else if (ti == t.length()){
      return 1 ; // 1 way to delte the all source char 
    }
    
    // have used the concept of memo
    if (dp[si][ti] != -1){
      return dp[si][ti] ; 
    }
    
    
    char c1 = s.charAt(si);
    char c2 = t.charAt(ti);
    int tw = 0 ; 
    if (c1 != c2){
      tw = solution(s,t,si+1,ti, dp) ; // drop the source char  
    }
    
    
    else {
    int t1 = solution(s,t,si+1, ti,dp) ; // drop the source char
    int t2  = solution(s,t,si+1,ti+1,dp) ; // drop both the source and the target character 
    
    tw = t1 + t2 ; 
      
    }
    
    
    dp[si][ti] = tw ;

		return tw ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
    
    // memo method -1 
    
    int [][] dp = new int [s1.length()][s2.length()] ;
    
    for (int i = 0 ; i< s1.length(); i++){
      for (int j = 0 ; j<s2.length(); j ++){
        
        dp[i][j] = -1 ; 
        
      }
    }
		System.out.println(solution(s1, s2,0,0, dp));
	}

}