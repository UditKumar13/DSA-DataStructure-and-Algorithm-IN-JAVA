import java.io.*;
import java.util.*;

/*
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the permutations of the n coins (non-duplicate) using which the amount "amt" can be paid.

A number n
n1
n2
.. n number of elements
A number amt
*/

public class Main {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used){
       
       
       if(amtsf>tamt){
           return ; 
       }
       else if(amtsf == tamt){
           System.out.println(asf + ".");
           return ;
       }
       
       for (int k=0;k<coins.length;k++){
           if(used[k] == false){
               used[k] = true ;
               String part = coins[k] + "-";
               coinChange(coins,amtsf+coins[k],tamt,asf+part,used);
               used[k] = false ; 
           }
       }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[coins.length];
        coinChange(coins, 0, amt, "", used);
    }
}