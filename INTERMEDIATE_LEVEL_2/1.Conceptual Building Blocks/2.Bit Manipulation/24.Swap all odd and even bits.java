import java.io.*;
import java.util.*;
/*
1. You are given a number n.
2. You have to swap all odd position bits with even position bits.
3. Every odd position bit is swapped with adjacent bit on left side.
4. Every even position bit is swapped with adjacent bit on right side.
5. Print the number formed after swapping.
Input : 10 
Output : 5
*/
public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int one_zero  = 0xAAAAAA;
    int zero_one = 0x555555;
    
    int mask_even = (n & one_zero) ; 
    int mask_odd = (n & zero_one) ;
    
    int odd_shift = mask_odd << 1 ;
    int even_shift = mask_even >> 1 ; 
    
    int result = odd_shift + even_shift ; 
    System.out.println(result);
    
    
  }

}