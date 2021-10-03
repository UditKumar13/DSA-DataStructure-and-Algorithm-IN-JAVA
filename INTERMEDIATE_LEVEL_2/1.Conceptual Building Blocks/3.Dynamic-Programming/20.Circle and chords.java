import java.io.*;
import java.util.*;
/*

1. You are given a number N.
2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
3. You have to find the number of ways in which these chords can be drawn.

Input:
3

Ouput :
5

*/
public class Main {

    public static long NumberOfChords(int n){
      int c = n ; 
      // remember sometimes not all test cases will pass, that means maybe value is much larger so try to improvise the dp array to long
      long [] dp = new long [c+1] ;
      dp[0] =1 ;
      dp[1] = 1 ; 
      for (int i = 2 ; i<=c ; i++){
        int l = 0 ;
        int r = i-1 ; 
        while(l <= i-1){
             dp[i] += dp[l] * dp[r] ;
        l ++ ;
        r-- ; 
        }
     
      }
        
        return dp[c];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NumberOfChords(n));
	}
}