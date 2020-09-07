import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // Nice game going on 
    
    Scanner scn = new Scanner (System.in);
    int n =scn.nextInt();
    
    int [] arr = new int [n];
    int inc=0;
    while(inc<n){
        arr[inc] = scn.nextInt();
        inc++;
    }
   
   for (int i=0;i<n;i++ ){
       for (int j=i;j<n;j++){
           for (int k=i;k<=j;k++){
               System.out.print(arr[k] + "\t");
           }
           System.out.println();
       }
   }
    
 }

}