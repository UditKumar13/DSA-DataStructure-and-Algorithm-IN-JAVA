import java.io.*;
import java.util.*;


/*
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the sum of elements of the increasing subsequence with maximum sum for the array.

Input : 
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

Output : 
255
*/

public class Main {

    public static void main(String[] args) throws Exception {
      Scanner  scn = new Scanner (System.in);
      int n = scn.nextInt() ;
      int [] arr = new int [n] ; 
      // taking input
      for (int  i=0 ; i<n;i++){
          arr[i] = scn.nextInt(); 
      }
        
     int [] dp = new int [n] ;
    int gmax = Integer.MIN_VALUE ; 
    for (int i =0 ; i<dp.length ;i++){
        Integer lmax = null ; 
        for(int j =0 ;j<i ; j++){
            //  have to find the lmax 
            if (arr[j] <= arr [i] ){
                if(lmax == null){
                    lmax = dp[j] ; 
                }
                 // have to update only when  the arr[j] is greater than lmax 
                else if(dp[j] > lmax){
                    lmax = dp [j];
                }
            }
        }
        
     if(lmax == null){
         dp [i] = arr [i] ;  
     }
        
    else{
        dp [i] = lmax + arr [i] ; 
    }
        
    if (dp [i] > gmax){
        gmax = dp [i] ; 
    }
    }
      System.out.println (gmax);  
    }

}