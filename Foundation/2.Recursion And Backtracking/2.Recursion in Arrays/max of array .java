import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       //Nice game going on !
       
       Scanner scn = new Scanner (System.in);
       int n = scn.nextInt();
       int [] arr =new int [n];
       
       for (int i=0;i<arr.length;i++){
           arr[i] = scn.nextInt();
       }
       
       int max  = maxOfArray(arr,0);
       System.out.print(max);
    }

    public static int maxOfArray(int[] arr, int idx){
        if (idx==arr.length-1){
            return arr[idx];
        }
        int max=0;
        int max1 = arr[idx];
        int max2=maxOfArray(arr,idx+1);
        if (max1>max2){
            max=max1;
        }
        else{
            max=max2;
        }
        
        return max;
    }

}