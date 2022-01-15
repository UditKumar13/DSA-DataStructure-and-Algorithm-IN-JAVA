/*

1. You are given a string str.
2. You have to find the smallest window length that contains all the unique characters of the given string.

Input :
aabcbcdbca

Output :
4
*/

import java.util.*;

public class Main {

	public static int solution(String str){
	
    
    int len = str.length () ; 
    
    HashSet<Character> set = new HashSet<>() ; 
    
    
    // it will add all the unique characters 
    
    for (int i =0 ; i<str.length () ; i++){
      char ch = str.charAt(i) ; 
      set.add(ch) ; 
    }
		
    
    int  i = -1 ;
    int  j =-1 ;
    
    HashMap<Character,Integer> map = new HashMap<>();
    
    while(true){
      boolean f1 =false ;
      boolean f2 = false ; 
      
      // acquire wile it is invalid map.size() < set.size()
      
      
      while(i < str.length () -1 && map.size() < set.size() ){
        i++ ;
        
        char ch = str.charAt(i);
        
        map.put(ch,map.getOrDefault(ch,0) + 1) ;
        
         f1 = true ; 
      }
      
      // collect and release 
      
      while( j<i && map.size() == set.size()){
        int plen = i-j ;
        if (plen < len ) len = plen ; 
        
        j++ ;
        char ch = str.charAt(j);
        if (map.get(ch) == 1){
          map.remove(ch);
        }
        
        else{
          map.put(ch,map.get(ch) -1);
        }
        
        f2 = true ; 
      }
      
      if (f1 == false && f2 == false ){
        break ; 
      }
    }
		return len;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
