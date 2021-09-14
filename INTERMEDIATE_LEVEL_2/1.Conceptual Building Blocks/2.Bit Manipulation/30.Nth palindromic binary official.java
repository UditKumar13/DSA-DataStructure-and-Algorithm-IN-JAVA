import java.io.*;
import java.util.*;


/*
1. You are given an integer N.
2. You have to find the N-th number whose binary representation is a palindrome.

Note -> First binary number whose representation is a palindrome is 1.

Input : 17
Output : 35
*/


public class Main {
    
    public static int getRev(int n ){
        int rev =0 ; 
        while (n !=0){
            int lb = (n & 1);
            rev |= lb ; 
            rev <<= 1 ; 
            n >>=  1 ;
            
            }
            
            rev >>= 1 ; 
        return rev ; 
     }

    public static int NthPalindromicBinary(int n) {
        
        int count =1 ; 
        int len = 1 ; 
        
        while (count < n ){
            len ++ ; 
            int element_so_far = (1<<(len-1)/2)  ;
             count += element_so_far ; 
            
        }
        // till count 30 
        count  -= (1<<(len-1)/2) ;
        // count  = 22 ;
        int off_set  = n - count -1 ; 
        // step 1 : add len -1 os after 1 
        int ans = (1 << (len -1 )) ;
        ans |= (off_set << (len / 2)) ; 
        
        int val = (ans >> (len/2)) ;
        int rev = getRev(val);
        int f_ans = ans | rev ; 
        
        
        
        return f_ans;
    }

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int taara =     NthPalindromicBinary(n);
        System.out.println(taara);
    }

}