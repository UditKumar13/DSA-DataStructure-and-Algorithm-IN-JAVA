

/*

Question : 

1. You are given a boolean expression with symbols T,F, and operators &,|,^ , where
   T represents True
   F represents False
   & represents boolean AND
   | represents boolean OR
   ^ represents boolean XOR.
2. You have to find the number of ways in which the expression can be parenthesized so that


the value of expression evaluates to true.

Input :
TFT
^&

Output :
2

*/


import java.io.*;
import java.util.*;

public class Main {
  
	public static int solution(String str1, String str2) {
	  int n = str1.length() ;
    
    int [][] dpt = new int [n][n]; // for true 
    int [][] dpf = new int [n][n] ; // for all posibilities of making false 
    
    for (int g=0; g<n;g++){
      for (int i=0 , j= g ; j<n; i++,j++){
        
        // gap is 0
        if (g==0){ 
          
          char ch = str1.charAt(i) ;
          
          if (ch == 'T'){
            dpt[i][j] = 1 ; 
            dpf[i][j] = 0 ; 
          }
          
          else{
            dpt[i][j] = 0 ; 
            dpf[i][j] = 1 ; 
          }
          
          
        }
        
        else{
          // for other gaps rather than 0 
          for (int k=i; k<j;k++){
            char oprt = str2.charAt(k) ;
            int ltc = dpt[i][k] ;
            int rtc = dpt[k+1][j] ; 
            int lfc = dpf[i][k];
            int rfc = dpf[k+1][j];
            
            if (oprt == '&'){
              dpt[i][j]  +=  ltc * rtc ;
              dpf[i][j] += ltc*rfc + lfc*rtc + lfc*rfc ;
            }
            
            else if(oprt == '|'){
              dpt[i][j]  += lfc * rtc + ltc * rtc + ltc*rfc ;
              dpf[i][j] +=  lfc * rfc ;
            }
            
            else{
              // xor 
              dpt[i][j]  += ltc * rfc + lfc * rtc ;
              dpf[i][j] += ltc*rtc + lfc * rfc ;
            }
          }
        }
      }
    }
    
    
    

		return dpt[0][n-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}