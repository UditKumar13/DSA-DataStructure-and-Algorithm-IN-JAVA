import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Buy and sell infinite transactions 
        
        Scanner scn = new Scanner (System.in);
        
        int n = scn.nextInt();
        
        int [] prices = new int [n];
        
        for (int j=0;j<prices.length;j++){
            prices[j] = scn.nextInt();
        }
        
        
        int max_profit = 0;
        int buy =0; 
        int sell=0;
        for (int i=1;i<prices.length;i++ ){
            // this means increasing graph 
            if (prices[i-1] <= prices[i] ){
                sell ++;
            }
            //first decreasing 
            else  {
            
        
            max_profit += prices[sell]-prices[buy];
            
            buy = sell = i;
                
            }
        }
        // 1 time more for the last peak 
        max_profit += prices[sell] - prices[buy];
    System.out.println(max_profit);
    }

}