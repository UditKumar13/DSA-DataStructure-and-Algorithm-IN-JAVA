import java.io.*;
import java.util.*;


/*
1. You are given a number n.
2. You have to count the number of set bits in the given number.
*/
public class Main {
  public static void count_One(int n, int count){
      // base case 
      if (n==0){
          System.out.print(count);
      return ; 
      }
      
      int rsbm = n & -n ;
      count++;
      count_One( n - rsbm,count);
      
  }
  
  
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    /*   Iterative method 
     while (n >0){
        int rsbm = n & -n ;
        n = n - rsbm ;
        count++ ;
    }
    
    System.out.println(count);
    */
    
    // Recursive approach 
    count_One(n,0);
    
  }

}