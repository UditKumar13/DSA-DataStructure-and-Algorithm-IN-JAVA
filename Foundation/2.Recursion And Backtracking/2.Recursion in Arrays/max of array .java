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
        
        //last element 
        if (idx==arr.length-1){
            return arr[idx];
        }
        // pushing in stack 
        int max2=maxOfArray(arr,idx+1);
        //comparing last and second last
        if (arr[idx]>max2){
            return arr[idx];
        }
        else{
            return max2;
        }
        

    }

}