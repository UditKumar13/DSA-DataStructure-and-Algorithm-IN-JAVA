import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    // Nice game going on !
    Scanner scn = new Scanner (System.in);
    
    int n = scn.nextInt();
    int [][] arr = new int [n][n];
    for (int i=0;i<arr.length;i++){
        for (int j=0;j<arr[0].length;j++){
            
            arr[i][j] = scn.nextInt();
            
        }
    }
    
    // logic for saddlepoint 
    
    
    //finding smallest in a row 
    for (int i=0;i<arr.length;i++){
        int svj =0;
        for (int j=1;j<arr[0].length;j++){
            if (arr[i][j] <=arr[i][svj]){
                svj = j;
            }
        }
        
        boolean flag =true;
    //    comparing that number is highest or not  
        for(int f=0;f<arr.length;f++){
            if (arr[f][svj] > arr[i][svj]){
                flag =false;
                break;
            }
        }
        
        if (flag == true){
            System.out.print(arr[i][svj]);
            return;
        }
   
    }
    
    System.out.print("Invalid input");
    }

}