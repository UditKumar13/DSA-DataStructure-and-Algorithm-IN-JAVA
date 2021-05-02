import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        int items  = scn.nextInt();
        // 5 number of items 
         
        int [] cost = new int [items];
        int [] weights = new int [items];
        
        for (int i=0 ;i<cost.length;i++){
            cost[i] = scn.nextInt();
        }
        
        
        for (int i=0 ;i<cost.length;i++){
            weights[i] = scn.nextInt();
        }
        
        int bag_weight = scn.nextInt();
        
        // dp solution of 0 1 knapsack is 
        // rows : items + 1 "players + 1"
        // cols : bag_weight +1 "balls given + 1"
        
        
        int [][] dp = new int [items+1][bag_weight+1];
    
        // storage done 
        //direction , small problem is dp[first row ] till last row
        //left to right 
        
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                // case 1:
                //iss case mein nhi khela yaa current item ka weight consider nhi krra 
                dp[i][j] = dp[i-1][j];
                
                int curr_cost = cost[i-1];
                int weight = weights[i-1];
                // case 2
                //when we will consider the current item weight and give oppurtunity to him 
                //condition current item ki  cost add hui auur uska weight subtract hoga j-weight
                // tabhi hoga jab current column j : max weight that can store in bagpack 
                if (j>=weight){
                dp[i][j] = Math.max(dp[i][j] , (curr_cost + dp[i-1][j-weight]));
                }
                
            }
        }
        
        
        System.out.println(dp[items][bag_weight]);
        
        
        
        
    }
}