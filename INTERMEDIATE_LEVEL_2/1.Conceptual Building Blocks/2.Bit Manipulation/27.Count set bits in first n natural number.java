import java.io.*;
import java.util.*;
/*
1. You are given a number n.
2. You have to print the count of set bits of first n natural numbers.  
*/
public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }

  public static int solution(int n){
      
    // base case 
    if (n==1 || n==2 || n==0){
        return n ; 
    } 
    
    int x = powerof2(n);
    
    int count = ((1<<(x-1))*x ) + (n - (1<<x)+ 1) + solution(n - (1<<x)); 
    return count;
  }
  
  public static int powerof2 (int n){
      
       int x = 0 ;
       
       while((1<<x) <= n ){
           x++ ; 
       }
       
       return x-1 ; 
  }

}