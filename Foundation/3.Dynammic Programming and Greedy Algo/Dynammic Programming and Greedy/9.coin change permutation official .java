import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        // coins array 
        int [] arr = new int [n];
        
        for (int i=0;i< n;i++){
            arr[i] = scn.nextInt();
        }
        
        int amt = scn.nextInt();
        // dp array 
        int [] dp = new int [amt+1];
        
        // 1 way to contribute 0 by doing nothing just like x^0 =1 
        dp[0] =1 ;
        
        // because now we have to take the permutations cases so we have to see all coins effect on each 
        //and every dp array element so outer loop dp length 
        for (int i=0 ; i<dp.length ;i++){
            for (int j=0;j<arr.length;j++){
                if (i>=arr[j]){
                dp[i] = dp[i] + dp[i-arr[j]];
                }
            }
        }
      System.out.println(dp[amt]);
    }
}