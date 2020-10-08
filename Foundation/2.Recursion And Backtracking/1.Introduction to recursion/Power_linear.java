import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Nice game going on 
        Scanner scn = new Scanner (System.in);
        int x =scn.nextInt();
        int n=scn.nextInt();
        int ans = power(x,n);
        System.out.print(ans);
        
        
    }

    public static int power(int x, int n){
        // special case 
        // when power is zero
        if (n==0){
        return 1;    
        }
        
        
        int xm1=power(x,n-1);
        int xn=x*xm1;
        
        return xn;
            
        
        
    }

}