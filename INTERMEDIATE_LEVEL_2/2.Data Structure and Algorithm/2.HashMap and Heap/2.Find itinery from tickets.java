/*
1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
2. You have to find the itinerary in order using the given list of tickets.

Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.

Input :
4
Chennai Banglore 
Bombay Delhi 
Goa Chennai 
Delhi Goa 

Output :
Bombay -> Delhi -> Goa -> Chennai -> Banglore.

*/

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

	 HashMap <String,Boolean> isrc = new HashMap<>() ;  // initiall source finding hashMap

    for (String src : map.keySet()){
      String dest = map.get(src) ;
      
      isrc.put(dest, false) ; // this can't be the intiall source  
      
      if (isrc.containsKey(src) == false){
        isrc.put(src,true);// may be it can be true
      }
    }
    
    String src= "" ;
    
    // finding the initial source 
    
    for (String pot :isrc.keySet()){
      if (isrc.get(pot) == true){
        src = pot ; 
        break ; 
      }
    }
    
    
    // priniting the path  now 
    
    while(true){
      if (map.containsKey(src) == true){
        System.out.print(src + " -> " );
        src = map.get(src); // updating the source to the destination 
      }
      
      else{
        System.out.print(src + ".") ;
        break ; // reached the destination 
      }
    }
    
    
    

	}
}
