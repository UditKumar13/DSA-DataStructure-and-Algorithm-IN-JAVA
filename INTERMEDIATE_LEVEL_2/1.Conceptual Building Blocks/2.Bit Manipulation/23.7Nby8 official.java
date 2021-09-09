import java.io.*;
import java.util.*;

public class Main {
    
    /*
    1. You are given a number n.
2. You have to calculate the value of 7n/8 without using division and multiplication.
Input : 15 Output : 13
    */

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    // 7n can be written as 8n - n 
    // (8*n - n ) / 8
    
    int ans  = ((n<<3) - n ) >> 3 ; 
    System.out.println(ans);
    
    
  }

}