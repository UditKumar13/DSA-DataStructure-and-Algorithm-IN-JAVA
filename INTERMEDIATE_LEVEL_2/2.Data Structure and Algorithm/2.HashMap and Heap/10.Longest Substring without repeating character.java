/*


1. You are given a string.
2. You have to find the length of the longest substring of the given string that contains all non-repeating characters.

Input :
aabcbcdbca

Output :
4

*/

import java.util.*;

public class Main {

	public static int solution(String str) {
		int ans = 0 ; 
    
    int i =- 1 ; 
    int j = - 1 ;
    
    HashMap <Character, Integer> map = new HashMap <>() ;
    
    while(true){
      boolean f1 = false ; 
      boolean f2 = false ; 
      // acquire
      while (i < str.length() -1 ){
        
        f1 =true ; 
        i ++ ;
        
        char ch = str.charAt(i); 
        
        map.put(ch,map.getOrDefault(ch,0) + 1) ;
        
        if (map.get(ch) == 2){
          break ; // because we don't want unique characters
        }
        
        else {
          int len = i-j ; 
          
          if (len > ans ){
            ans = len ; 
          }
        }
        
      }
      
      
      while (j<i){
        f2 = true ; 
        j++ ; 
        
        char ch = str.charAt(j);
        
        map.put(ch, map.get(ch)-1) ;
        
        if (map.get(ch) ==1){
          break ;  // if the character is only 1 that means it is unique now lets acquire more coming out of this loop
        }
      }
      
      
      if (f1 ==false && f2 ==false ){
        break ; // coming out of the while true loop 
      }
    }
    
    
    
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
