import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    // radix sort
    int max =Integer.MIN_VALUE;
    
    for(int val:arr){
        if (val>max){
            max=val;
        }
    }
    
    // radix sort kab tak chlega , sabse bade number ki saari digits purri no honn
    
    int exp=1;
    while(exp<=max){
        countSort(arr,exp); // multiple times count sort called for all type of unit places 
        exp*=10;// for unit ,10th , 100th place... 
    }
    
  }

  public static void countSort(int[] arr, int exp) {
     //Count sort 
// because we are sorting the digits range will be  0 to 9
   int [] farr = new int [10];
   
   //step 1  making frequency  array
   for(int i=0;i<arr.length;i++){
       
       farr[arr[i]/exp %10]++;
   }
   // step 2 : making prefix array
   for (int i=1;i<farr.length;i++){
       farr[i] = farr[i-1]+farr[i];
   }
   
   int [] ans =new int[arr.length];
   //scanning in reverse order to maintain the order (stable sort)
   for (int i=arr.length-1;i>=0;i--){
       
       int pos = farr[arr[i]/exp % 10];//pos = farr[9-3] = farr[6] =15;
       int idx =pos-1;// index 15-1=14
       ans[idx] = arr[i]; // 14 th  index prr 9 aayega
       farr[arr[i]/exp % 10]--;
       
       
   }
   
   for (int i=0;i<arr.length;i++){
       arr[i]=ans[i];
   }
   
   
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}