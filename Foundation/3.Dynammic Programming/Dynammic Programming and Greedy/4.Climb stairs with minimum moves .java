import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Climb stairs with minimum moves 
        
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        
        int [] arr = new int [n];
        // taking the input in arr , we can see from which stair we can take how much jumps  
        for (int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        // for storing all the min moves for all stairs even the top
        Integer  [] dp = new Integer[n+1];
        
        dp[n]=0; // standing at last stairs mo move required 0 move 
        
        // for all other stairs
       
        for (int i=n-1;i>=0;i--){
            if (arr[i]>0){
                int min = Integer.MAX_VALUE; // very large value
                
                for (int j=1;j<=arr[i] && i+j < dp.length ;j++){
                if (dp[i+j] != null){
                min = Math.min(min,dp[i+j]);
                }
                                           }
                                           
                                           
                                           
                // special case suppose dp[i+j] all cases stores the null value in it , so we will store the null in that dp position                           
                if (min != Integer.MAX_VALUE  ){
                    dp[i] = min +1;
                }   
                
                else{
                    dp[i] = null;
                }
            }
            
            
            
        }
        
        
        System.out.println(dp[0]);
        
    }

}