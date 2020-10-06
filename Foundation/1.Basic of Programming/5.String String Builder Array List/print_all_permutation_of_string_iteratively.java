import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
		// Nice game going on!
		//input:abc
		
		int l = str.length();
		int size = factorial(l);
		for (int i=0;i<size;i++){
		    StringBuilder sb = new StringBuilder(str);
		    int temp = i;
		    for (int div=l;div>=1;div--){
		        int q = temp/div;
		        int r =temp%div;
		        //remainder is conrolling the permutation output
		        System.out.print(sb.charAt(r));
		        sb.deleteCharAt(r);
		        
		        // updating dividend
		        temp=q;
		        
		        
		    }
		    System.out.println();
		    
		}
		
		
		
	}
	
	public static int factorial(int f){
	    
	    int i=1;
	    for (int fac=2;fac<=f;fac++){
	        i=fac*i;
	    }
	    
	   return i;
	    
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}  

}