/*
1. You are given a string containing only 0's and 1's.
2. You have to find the length of substring which is having maximum difference of number of 0s and number of 1s i.e (Number of 0's - Number of 1's).
3. If there are all 1's present in the given string, then print '-1'.

Input :
11000010001


Output :
6

*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str) {

    int ans =0 ;
    
    int mssf = 0 ;
    
    int [] dp = new int [str.length()] ;
    
    int count = 0 ; 
    
    for (int i=0 ; i< dp.length ; i++){
      char ch = str.charAt(i) ;
      int val = 0 ; 
      if (ch == '0'){
        val = 1 ; 
      }
      
      else {
        val = -1 ; 
        
        count ++ ; 
      }
      
      mssf = Math.max(mssf + val ,val) ;
      ans = Math.max(ans,mssf) ;
      
      
      
    }
		return count==str.length()?-1:ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str= scn.next();
		System.out.println(solution(str));
	}

}