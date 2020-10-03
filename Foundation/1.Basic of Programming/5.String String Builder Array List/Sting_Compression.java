import java.io.*;
import java.util.*;

public class Main {

	public static String compression1(String str){
		// Nice game going on 
		
		//first char converted into string 
		String taara = str.charAt(0) + "" ;
		
		
	
		
		for (int i=1;i<str.length();i++){
		    
		   char cur = str.charAt(i)  ;
		   char prev =str.charAt(i-1)  ;
		    if (cur!=prev){
		        taara+=cur;
		    }
		}

		return taara;
	}

	public static String compression2(String str){
		// Nice game going on !
		String taara = str.charAt(0) + "";
		int count=1;
		for (int i=1;i<str.length();i++){
		   
		    char cur = str.charAt(i);
		    char prev = str.charAt(i-1);
		    
		    if (cur==prev){
		        count++;
		    }
		      if( i==str.length()-1 && cur==prev ){
		        taara+=count;
		    }
		    
		     else if(cur!=prev && count>1){
		        taara = taara+count+cur;
		        count=1;
		    }
		    
		   else if(count==1 && cur!=prev){
		        taara=taara+cur;
		        count=1;
		    }
		    
		   
		}
		

		return taara;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}