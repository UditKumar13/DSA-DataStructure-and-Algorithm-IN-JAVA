import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // GOLD MINE
        
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int m =scn.nextInt();
        int [][] arr = new int [n][m];
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] =  scn.nextInt();
            }
        }
        
        // dp array  
        int max;
        int [][] dp = new int [n][m];
        for (int j= dp[0].length-1;j>=0;j--){
            for (int i=dp.length-1;i>=0;i--){
                //cases 
                
                if (j==dp[0].length-1){
                    dp[i][j] = arr[i][j];
                }
                // last row but not the last col
                else if (i==dp.length-1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);
                }
                //first row
                
                
                else if (i==0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1] ,dp[i+1][j+1]);
                }
                
                //rest case 
                else{
                    max = Math.max(dp[i-1][j+1] , dp[i][j+1]);
                    max =Math.max(dp[i+1][j+1] , max);
                    dp[i][j] = arr[i][j] + max;
                 }
                 
                 
            }
        }
        
        
        // now the answers lies in the first column of dp array 
        // we have to get the maximum answer so ,
        int ans_taara = Integer.MIN_VALUE;
        for (int i=0;i<dp.length;i++){
            if (ans_taara <= dp[i][0]){
                ans_taara = dp[i][0];
            }
        }
        System.out.println(ans_taara);
    }

}