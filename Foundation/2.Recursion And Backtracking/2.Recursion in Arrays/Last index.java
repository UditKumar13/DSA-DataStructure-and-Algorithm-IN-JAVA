import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Nice game going on !
        
        Scanner scn = new Scanner (System.in);
        
        int n = scn.nextInt();
        int [] arr = new int [n];
        for (int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        
        int x = scn.nextInt();
        int ans = lastIndex(arr,0,x);
        System.out.println(ans);
    }

    public static int lastIndex(int[] arr, int taara, int x){
        //taara is my index
     if (taara ==arr.length){
         return -1;
     }
     int lisa = lastIndex(arr,taara+1,x);
     // when you reach the last start comparing
     if (lisa == -1){
         if (arr[taara]==x){
             return taara;
         }
         else{
             return -1;
         }
         
     }// outer if closed 
     
     else{
     return lisa;
     }
     
    }
}