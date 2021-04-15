import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Buy and cell 1 transaction is allowed 
        
        Scanner scn = new Scanner (System.in);
        
        int n = scn.nextInt();
        int [] prices  = new int [n] ;
        // prices of stocks 
        for (int sky=0; sky<prices.length;sky++){
            prices[sky] = scn.nextInt();
        }
        
        if (n==1 || n==0){
            System.out.print("0");
            return ;
        }
        
        
        
        int max_profit  = 0;
        int least = prices[0];
        
        for (int i=1;i<prices.length;i++){
            if (least>=prices[i]){
                least = prices[i];
            }
            int profit = prices[i] -least ;
            if (max_profit <= profit ){
                max_profit = profit;
            }
            
        }
        
        System.out.println(max_profit);
        
        
    }

}