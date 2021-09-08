import java.io.*;
import java.util.*;


/*
1. You are given two numbers A and B.
2. You have to print the count of bits needed to be flipped to convert 'A' to 'B'.
*/
public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int xor = a^b ;
    int count  = 0 ; 
    while(xor>0){
        int rsbm = xor & (-xor);
        xor  = xor - rsbm ; 
        count++;
    }
    
    System.out.println(count);
  }

}