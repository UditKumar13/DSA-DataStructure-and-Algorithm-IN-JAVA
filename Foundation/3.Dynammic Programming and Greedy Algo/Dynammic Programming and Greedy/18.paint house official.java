import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        
        int n =scn.nextInt();
        // 2d array 
        //3 column of red , blue , green color 
        int [][] arr = new int [n][3];
        
        for (int i=0;i<arr.length;i++){
            for (int j =0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        
        //logic 
        int [][] dp = new int [n][3];
        
        for (int i=0;i<dp[0].length;i++){
            dp[0][i] = arr[0][i] ; 
        }
        
        for (int i=1;i<arr.length;i++){
            for (int j =0;j<arr[0].length;j++){
                // red 
                if (j==0){
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][j+1] , dp[i-1][j+2]);
                }
                //blue 
                else if (j==1){
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][j-1] , dp[i-1][j+1]);
                }
                //green 
                else if (j==2){
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][j-2] , dp[i-1][j-1]);
                }
            }
        }
        
        // now answer is in the last row
        int min = dp[dp.length-1][0] ;
        for (int j=0;j<dp[0].length;j++){
            if (dp[dp.length-1][j] <= min) {
                min = dp[dp.length-1][j];
            }
        }
        
        System.out.println(min);

    }
}