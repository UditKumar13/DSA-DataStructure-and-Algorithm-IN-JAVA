/*
1. You are given n space-separated strings, which represents a dictionary of words.
2. You are given another string that represents a sentence.
3. You have to determine if this sentence can be segmented into a space-separated sequence of one or more dictionary words.


Input :
2
pep coding
pepcoding


Output :
true

*/

import java.io.*;
import java.util.*;

public class Main {

	public static boolean solution(String sentence, HashSet<String> dictionary) {
	 
int [] dp = new int [sentence.length()]  ;
    
    for (int i = 0 ; i< dp.length; i++){
      for (int j = 0 ; j<= i ; j++){
        String w2check = sentence.substring(j,i+1) ;
        
        if (dictionary.contains(w2check)){
          if (j>0){
            dp[i] += dp[j-1] ; 
          }
        }
        
        
        else{
          dp[i] +=  1 ; 
        }
      }
    }
    
    
		return dp[sentence.length() -1] > 0 ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dictionary = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			dictionary.add(scn.next());
		}
		String sentence = scn.next();
		System.out.println(solution(sentence, dictionary));
	}

}

