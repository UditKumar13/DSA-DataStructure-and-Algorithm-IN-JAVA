import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();// n*n chess board
        int [][] arr = new int [n][n];
        
        printNQueens(arr,"",0);
        
        
    }
    public static boolean isSafeToPlaceNewQueen(int[][] chess,int row ,int col){
        // checking for same column
        for (int i=row-1,j=col;i>=0;i--){
            if(chess[i][j]==1){
                return false;
            }
            
        }    
        // checking left diagonal 
        for (int i=row-1 ,j=col-1;i>=0 && j>=0;i--,j--){
             if(chess[i][j]==1){
                return false;
            }
        }
        
        // checking right diagonal 
        for (int i=row-1,j=col+1;i>=0 && j<=chess[0].length-1;i--,j++){
             if(chess[i][j]==1){
                return false;
            }
        }
        
        return true;
        
    }
    
    
    public static void printNQueens(int[][] chess, String taara, int row) {
        //#skynevermiss
        if (row==chess.length){
            System.out.println(taara+".");
            return;
        }
        // cols are our options for each row 
        //it means in which column we want to place 
        for (int col=0;col<chess[0].length;col++){
            // but before putting in this col for the particular row 
            //we have to check whether is this place is valid to put new queen
            if(isSafeToPlaceNewQueen(chess,row,col)==true){
                // we can place the queen 
                chess[row][col]=1;
                printNQueens(chess,taara+row+"-"+col+", ",row+1);
                // back track
                chess[row][col]=0; 
                                     }
            }
            
        }
        
    }
