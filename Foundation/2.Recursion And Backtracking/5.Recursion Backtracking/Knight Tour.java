import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // #Sky never miss
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row =scn.nextInt();
        int col =scn.nextInt();
        
        int [][] chess =new int[n][n];
         
        printKnightsTour(chess,row,col,1);
        
    }

    public static void printKnightsTour(int[][] chess,  int row,int col,int move) {
        // base case 
        
        if (row<0 || col <0 || row>=chess.length||col >=chess[0].length||
        chess[row][col]>0){
            return;
        }
        else if(move==chess.length * chess.length){
            chess[row][col]=move;
        displayBoard(chess);
        chess[row][col]=0;
        return;
            
        }
        
        chess[row][col] = move;
        // move the knight with 8 possibilities Recursion calls ,make next move
        printKnightsTour(chess,row-2,col+1,move+1);
        printKnightsTour(chess,row-1,col+2,move+1);
        printKnightsTour(chess,row+1,col+2,move+1);
        printKnightsTour(chess,row+2,col+1,move+1);
        printKnightsTour(chess,row+2,col-1,move+1);
        printKnightsTour(chess,row+1,col-2,move+1);
        printKnightsTour(chess,row-1,col-2,move+1);
        printKnightsTour(chess,row-2,col-1,move+1);
        //Backtrack
        chess[row][col] = 0;
        
    
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}