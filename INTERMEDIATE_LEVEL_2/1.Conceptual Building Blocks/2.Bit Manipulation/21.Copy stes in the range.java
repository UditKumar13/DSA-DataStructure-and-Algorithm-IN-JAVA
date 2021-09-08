import java.io.*;
import java.util.*;
/*
1. You are given two numbers A and B.
2. You are given two more numbers left and right, representing a range [left,right].
3. You have to set bits in B which are set in A lying in the above mentioned range.
4. Print the updated number B.

Input : 
10
13
2
3

Output :
15
*/
public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();
    
    int m1 = 1 ; 
    int gap = Math.abs(left-right) + 1 ; 
    m1 = m1<< gap ;
    m1-=1 ; 
    // have to shift to the left 
    int x = m1<<(left-1);
    // now lets us make the maskA
    int mask_A = a & x;
    int ans = b | mask_A;
    System.out.println(ans);
    
  }

}