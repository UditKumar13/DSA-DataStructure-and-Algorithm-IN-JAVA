import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // minimum cost in maze traversal 
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt(); //rows 
        int m = scn.nextInt(); // cols
        
        int [][] arr = new int[n][m];
        // original arr contains cost to reach the current  index
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
       
         // dp array contains min cost (best ans) to traverse from current cell to final cell 
        int [][] dp = new int[n][m]; 
        
       
        for (int i=arr.length-1;i>=0;i--){
            for (int j=arr[0].length-1;j>=0;j--){
                
                 // last cell
                if (i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j]=arr[i][j];
                }
                // last col
                else if (j == dp[0].length-1){
                dp[i][j] = dp[i+1][j]+arr[i][j];    
                }
               // last row 
                else if (i == dp.length-1){
                       // it means we are in the last row 
                    // thus , only,horiontal movement add the cost of right cell to the current cell
                    dp[i][j] = dp[i][j+1]+arr[i][j];
                }
                // other cell than above cases both horizontal and vertical movement 
                else {
                    dp[i][j]= Math.min(dp[i+1][j],dp[i][j+1])+arr[i][j] ;
                    
                }
            }
        }
        
        System.out.println(dp[0][0]);
        
    }

}