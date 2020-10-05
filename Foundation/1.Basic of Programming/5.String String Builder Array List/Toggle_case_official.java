import java.io.*;
import java.util.*;

public class Main {

	public static String toggleCase(String str){
		//nice game going on 
		StringBuilder sb = new StringBuilder(str);
		
		for (int i=0;i<sb.length();i++){
		    char ch = sb.charAt(i);
		    if (ch>='a' && ch<='z'){
		        //ch is smaller letter 
		        // this operation givesinteger have to typecast 
		        //into char
		        char uch = (char)('A' + ch - 'a');
		        sb.setCharAt(i,uch);
		    }
		    else{
		        char uch = (char)('a' + ch -'A');
		        // ch is capital letter
		        sb.setCharAt(i,uch);
		    }
		}
		// have to make it back a string 
		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}