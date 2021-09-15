import java.io.*;
import java.util.* ; 
class Main {
       public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
           int n = scn.nextInt() ;
        int [] arr = new int [n] ;
        for (int i=0; i<n ; i++){
            arr[i] = scn.nextInt() ; 
            
        }
        
        int [] dp = new int [n] ; 
        // making the dp array. We will use the tabulation method
           
        int omax = 0 ; 
        for (int uk =0 ;uk<n ;uk++){
            int max = 0 ;
            
            for (int j = 0; j<uk; j ++){
                if (arr[j] < arr [uk]){
                    if(dp[j] > max ){
                        max = dp [j] ; 
                    }
                }
            }
            
            dp[uk] = max + 1 ;
            if (dp[uk] > omax){
                omax = dp[uk] ; 
            }
        }
           
        System.out.println(omax);
    }
}