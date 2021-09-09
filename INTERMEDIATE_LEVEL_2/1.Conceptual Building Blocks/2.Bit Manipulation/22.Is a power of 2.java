import java.io.*;
import java.util.*;
/*
1. You are given a number n.
2. You have to check whether it is a power of 2 or not.
*/


public class Main {
    
 public static boolean check_pow2(int uk){
     
     int uk_1_less = uk -1 ;
     
     int pow2_or_not = uk & (uk_1_less);
     if(pow2_or_not !=0)
          return false;
     else
          return true  ;
 }
 

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean ans = check_pow2(n);
    System.out.println(ans);
  }

}