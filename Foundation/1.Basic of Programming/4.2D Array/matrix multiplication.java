import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // Nice game going on !
    
Scanner scn =new Scanner(System.in);
// rows of 1st array
int n1 = scn.nextInt();
int m1 =scn.nextInt();

int [][]arr1 = new int [n1][m1];


for (int i=0;i<arr1.length;i++){
    for (int j=0;j<arr1[0].length;j++){
        arr1[i][j] = scn.nextInt();
    }
}
// rows and cols of 2nd arr
int n2 = scn.nextInt();
int m2 =scn.nextInt();
int [][]arr2= new int [n2][m2];


for (int i=0;i<arr2.length;i++){
    for (int j=0;j<arr2[0].length;j++){
        arr2[i][j] = scn.nextInt();
    }
}
int [][] farr = new int[n1][m2]; 
if (m1 != n2){
    System.out.println("Invalid input");
    
}
// when arrays are valid for multplications


else{
    for(int i=0 ;i<farr.length;i++){
        for (int j=0;j<farr[0].length;j++){
            for (int k=0;k<m1;k++){
                farr[i][j]+=arr1[i][k] * arr2[k][j];
            }
        }
    }
    
    
for(int i=0;i<farr.length;i++){
    for (int j=0;j<farr[0].length;j++){
        System.out.print(farr[i][j] + " ");
        
    }
    
    System.out.println();
}

    
}

}
}
