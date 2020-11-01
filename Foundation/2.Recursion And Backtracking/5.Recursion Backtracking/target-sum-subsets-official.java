import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int []arr = new int [n];
        for (int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        
        
        printTargetSumSubsets(arr,0,"",0,tar);

    }

    // taara is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String taara, int sos, int tar) {
        // base case
        
        if (idx==arr.length){
            if (sos==tar){
            System.out.println(taara+".");    
            }
            
            return;
        }
        printTargetSumSubsets(arr,idx+1,taara+arr[idx]+ ","+" ",sos+arr[idx],tar);
        printTargetSumSubsets(arr,idx+1,taara,sos,tar);
        
    }

} 