import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // for the left
        
        for(int i=row, j=col ;j>=0;j-- ){
            if(chess[i][j]!=0){
                return false ; 
            }
        }
        // for up
        for(int i=row, j=col ;i>=0;i-- ){
            if(chess[i][j]!=0){
                return false ; 
            }
        }
        // for right
        for(int i=row, j=col ;j<chess.length; j++ ){
            if(chess[i][j]!=0){
                return false ; 
            }
        }
        // for down 
        for(int i=row, j=col ;i<chess.length;i++ ){
            if(chess[i][j]!=0){
                return false ; 
            }
        }
        
        
        
        // left diagonal up
        for(int i=row, j=col ;i>=0 && j>=0 ;i--,j-- ){
            if(chess[i][j]!=0){
                return false ; 
            }
        }
        // right diagonal up
        
        for(int i=row, j=col ;i>=0 && j <chess.length;j++,i-- ){
            if(chess[i][j]!=0){
                return false ; 
            }
        }
        // down left diagonal
            for(int i=row, j=col ;i<chess.length && j >=0;j--,i++ ){
            if(chess[i][j]!=0){
                return false ; 
            }
        }
        
        // down right diagonal 
            for(int i=row, j=col ;i<chess.length && j <chess.length;j++,i++ ){
            if(chess[i][j]!=0){
                return false ; 
            }
        }
        
        return true ; 
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
    // base case 
    if (qpsf == tq){
        
        for(int sky=0;sky <chess.length;sky++){
            for(int star = 0; star<chess.length;star++){
                if (chess[sky][star] == 0){
                    System.out.print("-\t") ; 
                }
                
                else{
                    System.out.print("q" + chess[sky][star] + "\t") ;
                }
            }
            System.out.println() ;
        }
            System.out.println() ;
        
    }
    
    for(int cell = 0; cell <chess.length * chess.length;cell++ ){
        int row  = cell / chess.length;
        int col = cell % chess.length;
        
        if(chess[row][col] == 0 && IsQueenSafe(chess,row,col)){
            chess[row][col] = qpsf + 1; 
            nqueens(qpsf+1,tq,chess) ; 
            chess[row][col] = 0 ; 
        }
    }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}