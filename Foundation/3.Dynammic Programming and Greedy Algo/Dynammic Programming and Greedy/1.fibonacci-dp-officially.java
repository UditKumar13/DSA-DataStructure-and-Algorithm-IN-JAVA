import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // fibonacci with dp memoization 
    
    Scanner  scn = new Scanner (System.in);
    int n =scn.nextInt();
    int taara = fibo(n , new int [n+1]);
    System.out.println(taara);
    
 }
 
 
 public static int fibo(int n , int [] qb ){
     if (n==0 || n==1){
         return n;
     }
     
     // storing pre order 
     //dp 
     if (qb[n] !=0){
         return qb[n];
     }
     
     int fibon1 = fibo(n-1,qb);
     int fibon2 = fibo(n-2,qb);
     
     int ans = fibon1 + fibon2;
     return ans;
     
 }

}