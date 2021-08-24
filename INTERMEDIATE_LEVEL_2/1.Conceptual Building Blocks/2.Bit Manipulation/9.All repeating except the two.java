import java.io.*;
import java.util.*;
/*
1. You are given an array of numbers.
2. You have to find 2 non-repeating numbers in an array.
3. All repeating numbers are repeating even number of times.
*/
public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
    int all_xor = 0 ;
    
    for(int val : arr){
        all_xor^= val; 
    }
    
    // step 1  : find the rsb of the all_xor
    // right most set bit : rsb  
    int rsb = all_xor & - all_xor; 
    int off_val = 0 ;
    int on_val = 0 ; 
    for(int val : arr){
        if((rsb & val) == 0 ){
            // that means the rsb bit was off in the val 
            off_val^= val ; 
        }
        
        else{
            on_val ^= val ; 
        }
    }
    
    if(on_val < off_val ){
        System.out.println(on_val);
        System.out.println(off_val);
    }
    
    else{
        System.out.println(off_val);
         System.out.println(on_val);
        
    }
   
  }

}