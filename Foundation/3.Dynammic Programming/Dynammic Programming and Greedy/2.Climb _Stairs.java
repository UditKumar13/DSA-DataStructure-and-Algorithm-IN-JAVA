import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // count climbs 
        
        Scanner scn = new Scanner (System.in);
        
        int n =scn.nextInt();
        int [] qb = new int [n+1];
        int taara = countStairs_Tab(n,qb);
        System.out.println(taara);
        
    }
    
    public static int countStairs_Tab (int n , int [] qb){
        // base cases 
        //tabulation method 
        qb[0]  = 1;
        
        for (int i=1;i<=n;i++){
        if (i==1){
            qb[i] = qb[i-1];
        }
        
        else if (i==2){
            qb[i] = qb[i-1] + qb[i-2];
        }
        else{
            
            qb[i] = qb[i-1] + qb[i-2] + qb[i-3];
            
        }
        
       
        
        
    }
    
     return qb[n];
   }
}