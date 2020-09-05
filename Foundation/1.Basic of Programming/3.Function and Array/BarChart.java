import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // Nice game going on
    
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int [] arr = new int [n];
    // putting values in an array
    for (int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }
    
    // logic for bar chart 
    
    // max 
    int max = arr[0];
    for (int i=1;i<n;i++){
        if (arr[i]>=max){
            max= arr[i];
        }
    }
//comparion done everytime for a horizontal line 
   int com = max;
    
    for (int j=0;j<max;j++){
           for (int i=0 ;i<n ; i++){
              if (arr[i]<com){
         System.out.print("\t");
     }
               else {
         System.out.print("*\t"); 
     }
     
     
    }
       System.out.println();
       //comparison decreases by one 
       com--;
  
   
    }
}

}