import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // we have to check for the  upper cases 
        
        // for the row 
        
        for(int i =row, j=0; j<col; j++){
            if (chess[i][j]){
                 return false ; 
            }
        }
        
        
        // for the upper vertical 
        
        for(int i =0, j=col; i<row; i++){
            if (chess[i][j]){
                 return false ; 
            }
        }
        // for the left diagonal 
        for(int i =row, j=col; i>=0 && j>=0; j--,i--){
            if (chess[i][j]){
                 return false ; 
            }
        }
        
        //  for the right diagonal 
        for(int i =row, j=col;i>=0 && j<chess.length;i--,j++ ){
            if (chess[i][j]){
                 return false ; 
            }
        }
        // if nothing goes wrong 
        return true ; 
    }

    public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nqueens(0, n, chess, -1);
    }
}