import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Buy and sell infinite with cool down 
        
        Scanner scn = new Scanner (System.in);
        
        int n = scn.nextInt();
        
        int [] price = new int [n];
        int i=0;
       while (i<n){
           price[i] = scn.nextInt();
           i++;
       }
       
       int obsp = -price[0];
       
       int ossp = 0;
       int ocsp = 0;
       
       for(int j=1;j<n;j++){
           int nssp=0;
           int ncsp=0;
           int nbsp=0;
           // for updating the buy stock price
           if (ocsp - price[j] > obsp ){
               nbsp = ocsp - price[j];
           }
           
           else{
               nbsp = obsp;
           }
           
            //updating ssp
           
           if (ossp< price[j] + obsp ){
               nssp = price[j] + obsp;
           }
           else{
               nssp = ossp;
           }
           
           // updating csp
           if (ocsp < ossp){
               ncsp = ossp;
           }
           else{
               ncsp = ocsp; 
           }
           
          
           
           
           obsp =nbsp;
           ossp=nssp;
           ocsp=ncsp;
           
       }
       
       
       System.out.println(ossp);
    }

}