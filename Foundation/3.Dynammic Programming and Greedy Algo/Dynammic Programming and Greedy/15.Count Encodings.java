import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        
        // COUNT ENCODING 
        Scanner scn  = new Scanner(System.in);
        String str = scn.next();
        
        int [] dp = new int [str.length()];
        // trivial case 
        dp[0] =1;
        for (int i=1; i<dp.length; i++){
            // there are four cases to see
            // #case 1: i-1 and i index both having 0 
            if (str.charAt(i-1) == '0' && str.charAt(i) == '0'){
                dp[i] =0;
            }
            // #case 2 : i-1  0 , ith index is not 0.  
            else if (str.charAt(i-1) == '0' && str.charAt(i) != '0'){ 
        
                dp[i] = dp[i-1];
            }
            // #case 3 : i-1 is not 0 and i is 0 
            else if (str.charAt(i-1) != '0' && str.charAt(i) == '0'){
           
                if (str.charAt(i-1) == '1' || str.charAt(i) == '2' ){
                    // special case
                    
                    dp[i] = (i>=2 ? dp[i-2] : 1); 
                    
                }
                
                else{
                    dp[i] = 0;
                }
            }
            // case 4 : both are not equal to 0 
            else{
                if (Integer.parseInt(str.substring(i-1,i+1)) <=26) {
                    dp[i] = dp[i-1] + (i>=2 ? dp[i-2] : 1);
                }
                
                else{
                    dp[i] = dp[i-1];
                }
            }
            
            
            
        }
        
        
        System.out.println(dp[str.length() -1]);

    }
}