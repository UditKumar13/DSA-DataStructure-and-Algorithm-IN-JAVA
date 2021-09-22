import java.io.*;
import java.util.*;

/*
//Longest common subsequnece 
1. You are given a string str1.
2. You are given another string str2.
3. You are required to print the length of longest common subsequence of two strings.
Input : 
abcd
aebd
Output : 
3
*/
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in) ; 
        String s1 = scn.nextLine() ;
        String s2 = scn.nextLine() ; 
        
        int [][] dp = new int [s1.length() + 1][s2.length() + 1] ;
        
        // + 1 extra for the dash last row and last col 
        for (int i =dp.length -2 ; i>=0 ; i--){
            // second last row 
            for (int j =dp[0].length-2 ; j >=0 ; j--){
                // second last col 
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                
                if (c1 == c2){
                    // 1 + lower diagonal 
                    dp[i][j] = 1 + dp [i+1][j+1] ; 
                }
                
                else{
                    // max from the right ele and the bottom ele
                    dp [i][j] = Math.max(dp[i+1][j], dp[i][j+1]);  
                }
            }
        }
        
     System.out.println(dp[0][0]);
    }

}