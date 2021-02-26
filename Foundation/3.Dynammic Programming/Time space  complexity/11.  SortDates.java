import java.io.*;
import java.util.*;

public class Main {

  public static void sortDates(String[] arr) {
    // write your code here
    countSort(arr,1000000,100,32);//days
    countSort(arr,10000,100,13);//months
    countSort(arr,1,10000,2501);//years
    
  }

  public static void countSort(String[] arr,int div, int mod, int range) {
       //Count sort 
// because we are sorting the digits range will be  0 to 9
   int [] farr = new int [range];
   
   //step 1  making frequency  array
   for(int i=0;i<arr.length;i++){
       
       farr[Integer.parseInt(arr[i],10)/div %mod]++;
   }
   // step 2 : making prefix array
   for (int i=1;i<farr.length;i++){
       farr[i] = farr[i-1]+farr[i];
   }
   
   String [] ans =new String[arr.length];
   //scanning in reverse order to maintain the order (stable sort)
   for (int i=arr.length-1;i>=0;i--){
       
       int pos = farr[Integer.parseInt(arr[i],10)/div %mod];//pos = farr[9-3] = farr[6] =15;
       int idx =pos-1;// index 15-1=14
       ans[idx] = arr[i]; // 14 th  index prr 9 aayega
       farr[Integer.parseInt(arr[i],10)/div %mod]--;
       
       
   }
   
   for (int i=0;i<arr.length;i++){
       arr[i]=ans[i];
   }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}