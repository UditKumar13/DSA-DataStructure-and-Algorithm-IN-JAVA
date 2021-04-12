import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        
        int n = scn.nextInt();
        int [] arr = new int [n];
        
        // numbers 
        for (int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        //have to find the max sum of subsequence each time no adjacent element is together 
        // inlude
        int [] inc  = new int [n];
        // exclude
        int [] exc = new int [n];
        inc[0] = arr[0];
        exc[0] = 0;
        for (int i=1;i<arr.length;i++){
            inc[i] = arr[i] + exc[i-1];
            
            exc[i] = Math.max(exc[i-1] , inc[i-1]);
            
        }
        int ans = Math.max(inc[n-1] , exc[n-1]);
        System.out.print(ans);

    }
}