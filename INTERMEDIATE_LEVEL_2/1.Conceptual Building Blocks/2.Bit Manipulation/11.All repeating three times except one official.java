import java.io.*;
import java.util.*;


/*
1. You are given an array of numbers.
2. All numbers occur thrice in the array except one.
3. You have to find the element that occurs once.
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
   int tn = Integer.MAX_VALUE, tn_1 = 0, tn_2 = 0 ; 
   for(int i =0 ;i<arr.length; i++){
       int cn = tn & arr[i] ;
       int cn_1 = tn_1 & arr[i] ;
       int cn_2 = tn_2 & arr[i] ;
       
       // now we have to optimize the values of tn, tn_1 and tn_2
       
       /*
       Theory : 
       cn will optimize the tn_1 by adding itself to it, and it will off the bit of tn itself 
       cn will optimize the tn_2 by adding itself to it, and it will off the bit of tn_1 itself
       cn will optimize the tn by adding itself to it, and it will off the bit of tn_2 itself
       
       for the on purpose just add the (cn)  and for the off purpose we have to do the and with the 1's compiplment of the cn 
       */
       
       
       tn_1 = cn | tn_1 ;
       tn = (~cn) & tn ; 
       
       tn_2 = cn_1 | tn_2 ;
       tn_1 = (~cn_1) & tn_1 ; 
       
       
       tn = cn_2 | tn ;
       tn_2 = (~cn_2) & tn_2 ;
       
       
       
       
   }
   // answer lies in the 3n + 1 form that is tn_1
   System.out.println(tn_1); 
  }

}