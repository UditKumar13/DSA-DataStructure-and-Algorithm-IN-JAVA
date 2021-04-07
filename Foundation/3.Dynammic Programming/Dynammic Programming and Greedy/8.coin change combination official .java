import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner (System.in);
        
        int n = scn.nextInt();
        int [] arr = new int [n];
        
        for (int i=0 ; i<arr.length;i++){
            arr[i] =scn.nextInt();
        }
        int amt = scn.nextInt();
        int [] dp = new int [amt+1];
        // outer loop : coins 
        //inner loop start with the respected current coin's value 
        // there is 1 way to store the 0 coin , don't give anything 
        dp[0] = 1 ;
        for (int i=0 ;i<arr.length;i++){
            for (int j=arr[i]; j<=dp.length-1;j++){
                
                // add the current ans and the previous ans , which is stored at the difference from the
                // current coin value i.e j-arr[i] , where arr[i] is current coin value 
                // current ans + j-arr[i]
                dp[j] = dp[j] + dp[j-arr[i]];
                
            }
        }
     System.out.println(dp[amt]);
    }
}