import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Nice game going on 
        
        Scanner scn = new Scanner (System.in);
        
        int n = scn.nextInt();
        
        int [][] arr = new int [n][n];
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                
                arr[i][j] = scn.nextInt(); 
            }
        }
        
        for (int  f=0 ; f<arr.length ; f++){
            for (int i=0,j=f ; j<arr.length ; i++,j++){
                System.out.println(arr[i][j]);
            }
        }
        
        }

}