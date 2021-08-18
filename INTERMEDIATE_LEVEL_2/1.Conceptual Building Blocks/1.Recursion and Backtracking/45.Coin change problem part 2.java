import java.io.*;
import java.util.*;

public class Main {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
    
    // base case
    if(i == coins.length){
        if(amtsf == tamt){
            System.out.println(asf+".");
        }
        return ; 
    }
    for (int chances = tamt/ coins[i] ; chances >=1 ; chances--){
        String part = "" ; 
        for(int k=0; k<chances; k++){
            part += coins[i] + "-" ;  
        }
        // keep adding the coins till a coin has a chance to add , suppose coin[i] = 2, has 12/2 = 6 chances, so 2-2-2-2-2-2- is  added in the part
        coinChange(i+1, coins,amtsf + coins[i] *chances, tamt, asf + part);
        // call for coin is get chosen 
    }
    coinChange(i+1,coins,amtsf,tamt,asf);
    // call when no coin is being selected 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}