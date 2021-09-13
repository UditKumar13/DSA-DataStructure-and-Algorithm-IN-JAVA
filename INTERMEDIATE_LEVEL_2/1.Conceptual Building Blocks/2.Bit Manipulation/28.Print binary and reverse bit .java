import java.io.*;
import java.util.*;
/*
1. You are given a number.
2. You have to print its binary representation.
3. You also have to reverse the bits of n and print the number obtained after reversing the bits.

Input : 11
Output : 
1011
13
*/
public class Main {

  
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
       boolean  flag  = false ;
       int rev  = 0 ;
       int  j = 0 ;
    
    for (int i = 31; i>=0 ; i--){
    
        int mask  = (1<<i);    
        if (flag){
         if ((n & mask) != 0 ){
             System.out.print(1);
              int smask = (1<<j);
             rev |= smask ; 
         }   
         
         else{
             System.out.print(0);
         }
         
         j++ ; 
        }
        
        else{
            if ((n & mask) != 0 ){
                flag = true ; 
             System.out.print(1);
             
             int smask = (1<<j);
             rev |= smask ; 
             j++ ; 
         }   
         
         else{
            
         }
        }
        
        
    }
    
    System.out.println();
    System.out.println(rev);
  }

}