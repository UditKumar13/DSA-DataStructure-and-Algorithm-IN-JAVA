import java.io.*;
import java.util.*;

public class Main {

	public static String solution(String str){
		// Nice game going on !
		//input:pepCODinG
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		
		for (int i=1;i<str.length();i++){
		    char cur=str.charAt(i);
		    char prev=str.charAt(i-1);
		    int diff = cur-prev;
		    sb.append(diff);
		    sb.append(str.charAt(i));
		}
		

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}