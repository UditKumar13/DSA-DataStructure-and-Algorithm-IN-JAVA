import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        
        int fence = scn.nextInt();
        
        int color = scn.nextInt();
        int n, k;
        n= fence ;
        k = color;
        
        // for n=1 
        long same = k*1;
        long diff = k*(k-1);
        long total = same + diff ; 
        for (int i=3 ; i<=n ; i++){
            // logic is written in register 
            same  = diff ;
            diff = total * (k-1) ;
            
            total = same + diff ;
            
        }
        
        
        System.out.print(total);
        
    }
}