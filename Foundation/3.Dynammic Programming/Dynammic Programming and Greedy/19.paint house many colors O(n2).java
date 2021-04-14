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
        
        // procedure to find least and second least 
        int least = Integer.MAX_VALUE ;
        int sleast = Integer.MAX_VALUE;
        for (int i=0;i<dp[0].length;i++){
            dp[0][i] = arr[0][i];
            if (arr[0][i] <= least){
                sleast = least ;
                least  =arr[0][i];
            }
            
            else if (arr[0][i] <=sleast){
                sleast = arr[0][i];
            }
        }
        
        
        // logic 
        for (int house=1;house<dp.length;house++ ){
            int newleast = Integer.MAX_VALUE ; 
            int newsleast =Integer.MAX_VALUE ; 
            for (int color=0;color<dp[0].length;color++){
               if(dp[house-1][color] != least ){
                   dp[house][color] = arr[house][color] + least;
               }
               
               else{
                   dp[house][color] = arr[house][color] + sleast;
               }
               // updating new least for the current row 
                if (dp[house][color] <=newleast){
                    newsleast  = newleast;
                    newleast  = dp[house][color];
                }
                
                else if(dp[house][color] <=newsleast){
                    newsleast = dp[house][color];
                }
            }
            
            least  = newleast ;
            sleast = newsleast;
        }
        
        
        System.out.println(least);
    }
}