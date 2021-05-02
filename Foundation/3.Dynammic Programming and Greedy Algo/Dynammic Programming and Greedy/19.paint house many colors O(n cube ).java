import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn  = new Scanner (System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();
        
        int [][] arr = new int [n][c];
        
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        
        int [][] dp = new int [n][c];
        
        for (int i=0;i<dp[0].length;i++){
            dp[0][i] = arr[0][i];
        }
        
        
        // logic 
        for (int house=1;house<dp.length;house++ ){
            for (int color=0;color<dp[0].length;color++){
                int min = Integer.MAX_VALUE;
                
                //logic to extract min color cost from the previous house except for the current house
                
                for (int k=0 ; k<dp[0].length;k++){
                    if (k!=color){
                        if (min >= dp[house-1][k]){
                            min = dp[house-1][k];
                        }
                    }
                }
                
                // till now u get min color for the previous house
                dp[house][color] = arr[house][color] + min ;
                
            }
        }
        
        
        
        int min  = Integer.MAX_VALUE;
        
        for (int k=0;k<dp[0].length;k++){
            if (min >= dp[n-1][k]){
                min = dp[n-1][k];
            }
        }
        
        
        System.out.println(min);
    }
}