import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
              
              
              Scanner scn = new Scanner(System.in);
              // no of ele
              int n = scn.nextInt();
              // have to do the parition in k 
              int k = scn.nextInt();
              
              long [][] dp  = new long  [n+1][k+1];
              
              // base cases
              if (n==0 || k==0 || n<k){
                  System.out.println("0");
                  return;
              }
              
              //i represent the ele
              
              // j represent the partition in k 
              for (int i=1;i<dp.length;i++){
                  for (int j=1;j<dp[0].length;j++){
                      
                      if (i<j){
                          dp[i][j] = 0; 
                      }
                      
                      else if (i==j){
                          dp[i][j] = 1;
                      }
                      
                      else{
                          
                          dp[i][j] = j*(dp[i-1][j]) + dp[i-1][j-1];  
                       }
                      
                  }
              }
              
        System.out.println(dp[n][k]);
   }
   
}