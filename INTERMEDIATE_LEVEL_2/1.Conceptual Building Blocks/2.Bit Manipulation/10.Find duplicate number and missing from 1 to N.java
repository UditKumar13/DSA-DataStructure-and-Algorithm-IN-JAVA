import java.io.*;
import java.util.*;
/*
1. You are given an array of length n containing numbers from 1 to n.
2. One number is present twice in array and one is missing.
3. You have to find these two numbers.
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
   
   int n = arr.length ; 
   int all_xor = 0 ; 
   for (int i =1 ;i<=n;i++){
       all_xor ^=  i ; 
   }
   for(int val : arr){
       all_xor ^= val ; 
   }
   // all_xor has the xor of unique values 
   int rsb = all_xor & - all_xor ;
   int on_xor = 0 ;
   int off_xor = 0; 
  for(int val:arr){
      if((val & rsb) == 0 ){
          off_xor^= val ; 
      }
      
      else{
          on_xor^= val ; 
      }
  }
  
  for(int i=1;i<=n;i++){
      if((i & rsb )== 0 ){
          off_xor ^= i ; 
      }
      
      else{
          on_xor ^= i ;  
      }
  }
  // Missing number 
  int rep_num = 0 ;
  int mis_num = 0;
  boolean  flag = false ; 
  for(int val :arr){
      if(val == off_xor){
          flag = true ; 
          rep_num = off_xor;
          mis_num = on_xor; 
         break ; 
      }
  }
  
  if(flag == false){
      rep_num = on_xor;
      mis_num = off_xor ; 
  }
  
  System.out.println("Missing Number" + " -> " + mis_num);
  System.out.println("Repeating Number" + " -> " + rep_num);
  
  }

}