import java.io.*;
import java.util.*;
/*
1. You are given a number n.
2. You have to print the right-most set bit mask.

// rsb  : that position of bit where the last 1 occured, and after this bit no 1 occured
*/
public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    // (~n + 1) or -n both represnts 2's compliment  
    int rsbm = n & (~n + 1); // right most set bit mask
    // this will give us the number will want 
    System.out.println(Integer.toBinaryString(rsbm));
  }

}