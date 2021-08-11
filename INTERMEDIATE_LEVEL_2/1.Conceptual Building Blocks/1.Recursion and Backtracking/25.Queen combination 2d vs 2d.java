import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        
        //base case 
        
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }
            
            return  ; 
        }
        
        
        int nr =0;
        int nc =0 ; 
        String yqp = "";
        String nqp = "";
        
        if (col == tq-1){
            // last column
            nr  = row + 1 ; 
            nc = 0 ;
            yqp = asf + "q\n";
            nqp = asf + "-\n";
        }
        
        else{
            nr = row ; 
            nc = col + 1 ;
            yqp = asf + "q";
            nqp = asf + "-";
            
            
        }
        queensCombinations(qpsf + 1,tq,nr,nc,yqp);
        queensCombinations(qpsf,tq,nr,nc,nqp);
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queensCombinations(0, n, 0, 0, "");
    }
}