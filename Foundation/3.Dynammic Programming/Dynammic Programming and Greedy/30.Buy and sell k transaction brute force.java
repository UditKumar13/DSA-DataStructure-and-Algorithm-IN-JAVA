import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner (System.in);
        // number of days 
        int n = scn.nextInt ();
        
        int [] arr = new int [n];
        
        for (int i=0 ;i<arr.length ;i++){
            arr[i] = scn.nextInt();
        }
        // k transactions 
        int k = scn.nextInt();
        
        int [][] dp = new int [k+1][n];
        for (int t=1 ;t<=k ;t++){
            for (int d=1 ;d<arr.length;d++){
                int max  = dp [t][d-1];
                
                for (int dr=0; dr<d ;dr++){
                    int diff = arr[d] - arr[dr];
                    int pval = dp[t-1][dr];
                    
                    if (diff + pval > max){
                        max= diff + pval ;
                    }
                }
                
                dp[t][d] = max;
            }
        }
        
    System.out.println(dp[k][n-1]);
    }

}