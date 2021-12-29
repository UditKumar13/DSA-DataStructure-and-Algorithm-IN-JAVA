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

	public static int solution(String s, String t , int si , int ti ) {

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
    char c1 = s.charAt(si);
    char c2 = t.charAt(ti);
    int tw = 0 ; 
    if (c1 != c2){
      tw = solution(s,t,si+1,ti) ; // drop the source char  
    }
    
    
    else {
    int t1 = solution(s,t,si+1, ti) ; // drop the source char
    int t2  = solution(s,t,si+1,ti+1) ; // drop both the source and the target character 
    
    tw = t1 + t2 ; 
      
    }
    

		return tw ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2,0,0));
	}

}