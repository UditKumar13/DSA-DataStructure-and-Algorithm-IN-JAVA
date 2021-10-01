import java.io.*;
import java.util.*;
/*
1. You are given a number n, representing the number of opening brackets ( and closing brackets )
2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
e.g.
for 1, answer is 1 -> ()
for 2, answer is 2 -> ()(), (())
for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))

Input :
4

Output :
14
*/
public class Main{

public static void main(String[] args) throws Exception {
  
  Scanner scn  = new Scanner (System.in);
  int n = scn.nextInt() ; 
  
  int [] dp = new int [n+1] ; 
  dp[0] =1 ; 
  dp[1] = 1 ;
  
  for(int i =2; i<=n ; i++){
    int inside = i-1; 
      int outside = 0 ;
    while (inside>=0){
      dp[i] += dp[inside] *dp [outside] ;
      inside -- ;
      outside ++ ; 
    }
  }
  System.out.println(dp[n]) ; 
   
 }

}