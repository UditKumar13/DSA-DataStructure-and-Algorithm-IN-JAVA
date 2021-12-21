/*

1. You are given a string.
2. You have to print the count of distinct and non-empty palindromic subsequences in the given string.
3. Two sequences s1 and s2 are distinct if here is some i, for which ith character in s1 and s2 are different.

Input :
bccb
Ouput :
6
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str) {
		
		int len = str.length() ; 
    
    int [][] dp = new int [len][len] ;
    
    int [] prev = new int [len] ; // help to keep track the prev pointer of the current character
    
    HashMap <Character,Integer> map = new HashMap<>() ;
    for(int i=0;i<len; i++){
      char ch = str.charAt(i) ;
      
      if (map.containsKey(ch) == false ){
        prev[i] = -1 ; 
        
      }
      
      else{
        prev[i] = map.get(ch);
      }
      
      map.put(ch,i) ; 
    }
    int [] next = new int [len] ; // help to keep track the next pointer of the current character 
    
    map.clear() ; // to clear the hashmap 
    
    
    // to fill the next array 
    for(int i=len-1;i>=0; i--){
      char ch = str.charAt(i) ;
      
      if (map.containsKey(ch) == false ){
        next[i] = -1 ; 
        
      }
      
      else{
        next[i] = map.get(ch);
      }
      
      map.put(ch,i) ; 
    }
    
    
    // now apply the gap strategy 
    
    for(int g=0; g<len; g++){
      for(int i=0, j = g; j< len; i++,j++){
        if (g==0){ 
          dp[i][j] = 1 ; 
        }
        
        else if(g==1){
          dp[i][j] = 2 ; 
        }
        
        else{
          char sc= str.charAt(i);
          char ec= str.charAt(j);
          
          if(sc != ec){
            dp[i][j] =dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] ; 
          }
          
          else{
            int n = next[i];
            int p = prev[j] ;
            
            if (n>p){
              dp[i][j] = 2*dp[i+1][j-1] + 2 ;  
            }
            
            else if(n == p ){
              dp[i][j] = 2*dp[i+1][j-1] + 1;
            }
            
            else{
              dp[i][j] = 2*dp[i+1][j-1] - dp[n+1][p-1] ; 
            }
            
          }
        }
      }
    }
    
		return dp[0][len-1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}