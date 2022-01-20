/*
1. You are given a string(str) and a number K.
2. You have to find length of the longest substring that has exactly k unique characters.
3. If no such substring exists, print "-1".

Input :
aabcbcdbca
2

Output :
4
*/


import java.util.*;

public class Main {

	public static int solution(String str, int k){
		 
    int ans = 0 ; 
    int  i = -1 ; 
    int j = - 1 ; 
    // use aquire and release strategy
    
    HashMap <Character,Integer> map = new HashMap<>() ;
    
    while(true){
      boolean f1 = false ; 
      boolean f2 =false ; 
      
      // acquire 
      while(i<str.length() -1 ){
        i++ ; 
        f1 = true ; 
        
        char ch = str.charAt(i) ;
        
        map.put(ch,map.getOrDefault(ch,0)+1) ;
        
        if (map.size() < k ){
          continue ; 
        }
        
        else if (map.size() == k){
          int len = i - j  ;
          if (len > ans){
            ans = len ; 
          }
        }
        
        
        else{
          break ; 
        }
      }
      
      // release 
      while(j<i){
        j++ ; 
        f2 = true ; 
        char ch = str.charAt(j) ;
        
        
        if (map.get(ch) == 1){
          map.remove(ch) ; 
        }
        else {
          map.put(ch,map.get(ch)-1);
        }
        
        
        
        
        
        if (map.size() > k ){
          continue ; 
        }
        
        else if (map.size() == k ){
          int len = i - j ;
          
          if (ans < len){
            ans = len ; 
          }
          
          break ; 
        }
      }
      
      
      if (f1 == false && f2 ==false ){
        break ; 
      }
    }

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
