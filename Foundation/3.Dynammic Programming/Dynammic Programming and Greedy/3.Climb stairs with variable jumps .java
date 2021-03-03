import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // climbs with variable jumps 
        
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        
        int  [] arr = new int [n];
        
        int [] dp = new int [n+1];
        
        for  (int i=0; i<n;i++){
            arr[i]  = scn.nextInt();
        }
        //base case for tabulation method 
        dp[n] =1 ;
        for (int j=n-1; j>=0 ; j--){
            for (int i=1 ; i<=arr[j] && (j + i)<dp.length  ;i++){
                dp[j] += dp[i+j];
            }
        }
        
        System.out.println(dp[0]);
    }

}