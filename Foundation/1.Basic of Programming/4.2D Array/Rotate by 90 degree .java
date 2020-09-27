import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // nice game going on!
        
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int [][] arr = new int [n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        
        // rotate by 90 degree 
        
        // two steps 1. transpose 2. reversing column wise
        //step 1. transpose
      int [][] trans_arr = new int [n][n];
      
      
    for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
            if (i==j){
                trans_arr[i][j]=arr[i][j];
            }
            
            else{
                trans_arr[i][j]=arr[j][i];
                 }
            }
        }
        
    //step 2 . reverse column elements 
    
        int [][] reverse = new int [n][n];
        
       for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
            reverse[i][j] = trans_arr[i][n-j-1];
            }
        }
        
    
       for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(reverse[i][j] + " ");
            }
                System.out.println();
        }

        
            
        
        
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}