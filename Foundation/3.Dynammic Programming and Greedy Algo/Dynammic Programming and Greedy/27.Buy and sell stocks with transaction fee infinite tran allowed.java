import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Buy and sell stocks with transaction fee infinte transaction allowed 
        
        Scanner scn = new Scanner (System.in);
        
        int n = scn.nextInt();
        
        int [] price = new int [n];
        
        for(int i=0;i<price.length;i++){
            price[i] = scn.nextInt();
            
        }
        
        int fee = scn.nextInt();
        
        int bsp = -price[0];
        int ssp = 0;
        for (int i=1;i<price.length;i++){
            int nbsp = ssp - price[i];
            int nssp = bsp;
            bsp = Math.max(bsp,nbsp);
            
            nssp = nssp + price[i] - fee;
            ssp = Math.max(ssp, nssp);
        }
        
        System.out.println(ssp);
        
    }

}