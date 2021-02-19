import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   //Count sort 
   int range = max-min+1;
   int [] farr = new int [range];
   
   //step 1  making frequency  array
   for(int i=0;i<arr.length;i++){
       int idx = arr[i]-min;
       farr[idx]++;
   }
   // step 2 : making prefix array
   for (int i=1;i<farr.length;i++){
       farr[i] = farr[i-1]+farr[i];
   }
   
   int [] ans =new int[arr.length];
   //scanning in reverse order to maintain the order (stable sort)
   for (int i=arr.length-1;i>=0;i--){
       int val =arr[i];//9
       int pos = farr[val-min];//pos = farr[9-3] = farr[6] =15;
       int idx =pos-1;// index 15-1=14
       ans[idx] = val; // 14 th  index prr 9 aayega
       farr[val-min]--;
       
       
   }
   // now ans is our sorted array
   for (int i=0;i<arr.length;i++){
       arr[i]=ans[i];
   }
   
   
   
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}