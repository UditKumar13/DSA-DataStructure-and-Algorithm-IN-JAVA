import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Nice game going on !
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int [][] arr = new int [n][n];
        
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        // logic to find the position of x in sorted 2d arr
        int x = scn.nextInt();
        int lc =arr[0].length-1;
        int i=0;
        int j=lc;
        
        while(i<arr.length && j>=0){
            
            //checking the last columns items 
            if (arr[i][j]==x){
                System.out.println(i);
                System.out.println(j);
                return;
            }
            //shifting one left
            else if(arr[i][j]>x){
                j--;
            }
            //checking the next line row
            else{
                i++;
            }
        }
        
        
        System.out.println("Not Found");
    }

}