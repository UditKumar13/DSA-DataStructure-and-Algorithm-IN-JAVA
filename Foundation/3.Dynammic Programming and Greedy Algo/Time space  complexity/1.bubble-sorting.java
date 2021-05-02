import java.io.*;
import java.util.*;

public class Main {

  public static void bubbleSort(int[] arr) {
    
    //Bubble sort
    int len=arr.length;
    for (int i=0;i<=arr.length-1;i++){
        for (int j=0;j<=len-2;j++){
            if (isSmaller(arr,j,j+1)){
                swap(arr,j,j+1);
            }
            
            
        }
        len--;
        
        
        
        
    }
    
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int j, int i) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int j, int i) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
    }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
