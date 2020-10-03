import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean isPalindrome(String s){
        
      int i=0;
      int j=s.length();
      
      while(i<j){
          if (s.charAt(i)!=s.charAt(j-1)){
              return false;
          }
          
          i++;
          j--;
      }
        return true;
        
    }

	public static void solution(String str){
		//Nice game going on !
	
		for (int i=0;i<str.length();i++){
		    for (int j =i+1;j<=str.length();j++){
		        String ss = str.substring(i,j);
		        if (isPalindrome(ss)==true){
		            System.out.println(ss);
		        }
		    }
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}