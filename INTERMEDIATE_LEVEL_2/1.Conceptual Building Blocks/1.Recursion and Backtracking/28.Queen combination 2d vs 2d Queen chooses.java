import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        
        
        if (qpsf == tq){
            for (int uk=0;uk<chess.length;uk++){
                for(int gk=0;gk<chess.length;gk++){
                     if (chess[uk][gk] == false ){
                         System.out.print("-\t");
                     }
                     else{
                         System.out.print("q\t");
                     }
                }
                System.out.println();
            }
            
            System.out.println();
            return ; 
        }
        
        // first we try to place the queen in the remaining row 
        for (int col=j+1; col<chess.length;col++){
            if (chess[i][col] == false ){
                chess[i][col] = true ; 
                queensCombinations(qpsf+1,tq,chess,i,col);
                chess[i][col] = false ; 
            }
        }
        
        // now we will try to place the queens in the ramaining rows staring from the row + 1 
        for (int row = i+1 ; row<chess.length; row++){
            for (int col = 0; col<chess.length;col++){
                 if (chess[row][col] == false ){
                chess[row][col] = true ; 
                queensCombinations(qpsf+1,tq,chess,row,col);
                chess[row][col] = false ; 
            }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}