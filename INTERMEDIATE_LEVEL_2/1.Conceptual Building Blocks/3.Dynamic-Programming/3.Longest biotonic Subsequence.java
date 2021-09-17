import java.io.*;
import java.util.*;
/*
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest bitonic subsequence of array.
Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.

//Input : 
10
10
22
9
33
21
50
41
60
80
1

Output :7
*/
 
public class Main {
    public static int [] longest_Inc_Sub(int [] arr, int [] dp ){
        int omax = Integer.MIN_VALUE ; 
        
        for (int i = 0 ; i<arr.length ; i++){
            Integer max = null;
            for (int j = 0 ; j< i ;j++){
                // it will calculte the max from the dp till i-1 
                if (arr[j] <= arr[i]){
                    if (max == null){
                        max = dp[j] ; 
                    }
                    
                    else if(dp [j] > max ){
                        max = dp [j]  ; 
                    }
                    
                    
                }
            }
            
            if (max == null){
                dp [i]  = 1 ; 
            }
            
            else{
                // this max is the max of dp from the index 0 to i-1, max : length of the longest inc sub till index i
                dp [i] = max + 1;
                // why 1 because at every index we are forcing the dp[i] to end with the current element that is arr[i] 
            }
            
            if (dp [i] > omax ){
                omax = dp [i] ; 
            }
            
            
        }
        
        return dp ; 
    }
    
        
        
      
    public static int [] longest_Dec_Sub(int [] arr,int [] dp){
        int omax = Integer.MIN_VALUE  ; 
        
        for(int i = arr.length-1 ; i>=0 ; i--){
             Integer max = null ; 
            for (int j = arr.length-1 ; j > i ; j--){
               
                if (arr[j] <= arr [i]){
                    
                    if (max == null){
                        max = dp [j] ;  
                    }
                    
                    else if (dp[j] > max){
                        max = dp [j] ; 
                    }
                }
                
            
                
            }
          
                  
            if (max == null){
                dp [i] = 1 ; 
            }
            
            else{
                dp [i] = max + 1 ; 
            }
            
            if (dp [i] > omax){
                omax = dp [i];
            }
        }
            
            return dp ; 
        
    }
    
    

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in) ;
        int  n = scn.nextInt() ; 
        int [] arr = new int [n] ;
        //inputs
        for (int i =0 ; i<arr.length; i++){
            arr[i] = scn.nextInt() ;
        }
        // Step 1 : First LIS from left to right
        // step 2 : Cal LDS from right to left
        // LBS : max (LIS + LDS )
        int [] dp_lis = new int [n] ;
        int [] dp_lds = new int [n] ;
        
        int [] x = longest_Inc_Sub(arr,dp_lis);
        int [] y = longest_Dec_Sub(arr,dp_lds);
       
        // why -1 because of the commomn element in lis and lds 
        int ans = 0 ; 
       for (int uk = 0; uk<n ; uk++){
           if ((x [uk] + y [uk] - 1) > ans ){
               ans = x [uk] + y [uk] - 1 ; 
           }
       }
        
       System.out.println(ans);
    }

}