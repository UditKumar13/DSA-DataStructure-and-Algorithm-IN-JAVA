import java.io.*;
import java.util.*;


 /*
 1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (non-duplicate) using 
     which the amount "amt" can be paid.
     
   A number n
n1
n2
.. n number of elements
A number amt  
 */
public class Main {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf){
        if(i == coins.length){
            
            if(tamt == amtsf){
                System.out.println(asf + ".");
            }
            return ; 
        }
        
        // two calls 
        // one is for not selecting 
        int curr_amt = coins[i];
        String ch = curr_amt + "" ; 
        coinChange(i+1,coins,amtsf+curr_amt,tamt,asf+ch +"-");
        coinChange(i+1, coins,amtsf,tamt,asf);
       
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferReader br = new BufferReader(new InputStreamPeader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        
        coinChange(0, coins, 0, amt, "");
    }
}