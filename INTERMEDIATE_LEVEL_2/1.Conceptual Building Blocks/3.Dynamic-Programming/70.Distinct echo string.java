/*
https://leetcode.com/problems/distinct-echo-substrings/

Distinct echo substring

Input :

Output :

*/


import java.io.* ;
import java.util.*; 
class Solution {
  
  long [] hash ;
  
  long [] pow ;
  
  long r =256 ;
  
  long mod = (long)1e9+7 ;
  
  
  public void process (String text, int n ){
    hash = new long [n] ;
    
    pow  = new long [n] ;
    pow [0] =1 ;
    
    for (int i = 1 ; i<n ; i++){
      hash[i] = (hash[i-1] * r + text.charAt(i)) % mod ;
      pow[i] = (pow[i-1] * r ) % mod;
      
    }
  }
  
  
  public long calc(int l, int r){
    long hv =  (hash[r] - hash[l] * pow[r-1] % mod + mod) %mod ;
    
    return hv ; 
  } 
    
  public int distinctEchoSubstrings(String text) {
 int n = text.length()  ;
    
    process(text,n);
    
    HashSet<Long> set = new HashSet<>() ;
    
    for(int len=1 ; len<= n/2; len++){
      int count = 0 ;
      
      for(int l=0, r =len;  r<n ; l++,r++){
        if (text.charAt(l) == text.charAt(r)){
          count ++ ; 
        }
        
        else {
          count = 0 ; 
        }
        
        if (count == len ){
           long hv =  calc(l,r);
          
          set.add(hv) ; 
          
          count -- ; // first char remove 
        }
      }
    }
    
    return set.size() ; 
  }
}