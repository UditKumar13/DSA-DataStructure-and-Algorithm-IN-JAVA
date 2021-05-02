import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Buy and sell 2 transaction 
        
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        
        int arr [] = new int [n];
        
        for (int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
            
        }
        // traversing fro left to right 
        // maximum profit if sold today 
        int mpist = 0;   
        int [] dpl = new int [arr.length];
        int least  = arr[0];
        
        for (int i=1;i<arr.length;i++){
            if (arr[i] < least ){
                least  = arr[i];
            }
            
            mpist  = arr[i] - least ;
            //checking in the previous best profit 
            if(mpist > dpl[i-1]){
                dpl[i]  =mpist ;
            }
            
            else{
                dpl [i] = dpl[i-1];
            }
            
            
        }
        
        
        
        // traversing from right to left 
        int mpibt  = 0;
        int [] dpr = new int [arr.length];
        int maxat = arr[arr.length-1];
        for (int i= arr.length-2 ; i>=0 ;i--){
            if (arr[i] > maxat){
                maxat = arr[i];
            }
            
            mpibt = maxat - arr[i];
            
            if (mpibt > dpr[i+1]){
                dpr[i] = mpibt;
            }
            
            else{
                dpr[i] = dpr[i+1];
            }
            
        }
        // overall profit 
        int op = 0;
        for (int i=1; i<arr.length;i++){
            if (op < dpr[i] + dpl[i]){
                op = dpr[i] + dpl[i];
            }
        }
        
        System.out.println(op);
        
    }

}