import java.io.*;
import java.util.*;

/*
1. You are given N number of words.
2. You are given M puzzles in the form of M strings.
3. For a given puzzle, a word is valid if both the following conditions are confirmed - 
    Condition 1 -> Word contains the first letter of puzzle.
    Condition 2 -> For each letter in word, that letter should be present in puzzle.
4. You have to print the number of valid words corresponding to a puzzle.
*/
public class Main {

	public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		HashMap <Character, ArrayList<Integer>> map = new HashMap <>() ;
		//  hashmap to map the character to the respective word which only have that character 
		for(int uk= 0 ; uk<26; uk++){
		    map.put( (char)( uk + 'a'),new ArrayList<>());
		}
		
	
		for(String word : words ){
		    int word_mask = 0 ;
		    
		    for(char ch : word.toCharArray()){
		        // now selecting each char in a word 
		        int bit = ch -'a' ;
		        word_mask =( word_mask | (1 << bit) ) ; 
		        
		        //making the word mask for the particular word when this for loop gets over 
		    }
		    	// for the uniqueness , we have to use the HashSet
		HashSet<Character>unique = new HashSet<>() ; 
		
		    for(char ch : word.toCharArray()){
		        
		  if (unique.contains(ch)){
		      continue ; 
		  }
		  unique.add(ch) ; 
		     map.get(ch).add(word_mask);  
		     // adding mask to the hashmap so that all words's mask get added in the arraylist , a particular char have a word which contains this char
		    }
		}
		
		ArrayList <Integer> res = new ArrayList<>() ; 
		for(String puzzle : puzzles ){
		    int puzzle_mask = 0 ;
		    
		    for(char ch : puzzle.toCharArray()){
		        // now selecting each char in a word 
		        int bit = ch -'a' ;
		        puzzle_mask =( puzzle_mask | (1 << bit) ) ; 
		        
		        //making the puzzle mask for the particular word when this for loop gets over 
		    }
		    
		   char fch = puzzle.charAt(0);
		   
		   ArrayList <Integer> wordToCheck = map.get(fch);
		   int count = 0 ; 
		   for(int wmask : wordToCheck){
		       if((puzzle_mask & wmask) == wmask ){
		           count ++; 
		       }
		   }
		   
		   res.add(count);
		   
		   
		}
		
		return res ; 
		
	
	 }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int m = scn.nextInt();
		String[] puzzles = new String[m];
		for(int i = 0 ; i < m ;i++) {
			puzzles[i] = scn.next();
		}
		ArrayList<Integer> ans = findNumOfValidWords(words,puzzles);
		for(int i=0; i<ans.size(); i++) {
			System.out.println(puzzles[i] + " -> " + ans.get(i));
		}
	}
	
}