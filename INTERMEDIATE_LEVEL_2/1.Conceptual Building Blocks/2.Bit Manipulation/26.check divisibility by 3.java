import java.io.*;
import java.util.*;
/*
1. You are given a binary string which represents a number.
2. You have to check whether this number is divisible by 3 or not.
3. Print 'true' if it is divisible by 3, otherwise print 'false'.
Input : 10010101010001
Output : false 

*/
public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int even = 0 ; 
    int odd = 0 ; 
    for (int i =0 ; i<str.length();i++){
        int num = str.charAt(i) - '0' ;
        
        if (i % 2 == 0){
            even += num ; 
        }
        
        else{
            odd += num ; 
        }
    } 
   
   
   int diff = even - odd ;
   
   if ((diff % 11 )== 0 ){
       System.out.println(true);
   }
   
   else{
       System.out.println(false);
   }
   
   
   
   
  }

}