import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner (System.in);
        String ip = scn.nextLine();
        printPermutations(ip,"");
    }

    public static void printPermutations(String ip,String taara) {
        
        // base case 
        if(ip.length()==0){
            System.out.println(taara);
            return;
        }
    
        
        for (int i=0;i<ip.length();i++){
                char ch = ip.charAt(i);//a
                // very nice trick to make calls on 
                // 1.call (ros,taara+ch ): (bc,a) (ac,b) (ab,c)
                //leaving ith index character and taking everything left 
                String ros = ip.substring(0,i) + ip.substring(i+1);
                printPermutations(ros,taara+ch);
            
        }
        
        
        
        
    }

}