/*

1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.


Input :
aabcbcdbca

Output :
24

*/


import java.util.*;

public class Main {

	public static int solution(String str) {
		int ans = 0 ; 
		
    
    int  i = -1 ;
    
    int j  = -1 ;
    
    HashMap <Character,Integer> map = new HashMap <>() ; 
    
    
    while(true){
      boolean f1 =false ; 
      boolean f2 = false ; 
      
      while (i<str.length() -1 ){
        i++ ;
        f1 = true ; 
        char ch = str.charAt(i)  ;
        
        map.put(ch,map.getOrDefault(ch,0) + 1 ) ;
        
        if (map.get(ch) == 2){
          // not ananya
          break ; 
        }
        
        else {
          ans += i- j ;
          
        }
      }
      
      
      while (j<i){
        j++ ; 
        f2 = true ; 
        char ch = str.charAt(j);
        
        map.put(ch,map.get(ch)-1);
        
        if (map.get(ch) == 1){
          // unique
          ans += i - j ; 
          break;
        }
      }
      
      
      if (f1 == false && f2 ==false ){
        break ; 
      }
    }
		return ans ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
