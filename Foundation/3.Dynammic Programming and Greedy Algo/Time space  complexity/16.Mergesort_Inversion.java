import java.io.*;
import java.util.*;

public class Main {
  public static int inv = 0 ; // for maintaining the count of inversion
  public static int[] mergeSort(int[] arr, int lo, int hi) {
    //merge sort
    
    //   base case 
    if (lo==hi){
        int [] ba =new int[1];
        ba[0]=arr[lo];
        return ba;
    }
    int mid = (lo+hi)/2;
    //fsh : first sorted array //ssh :second sorted array //fsa : full sorted array // ba:base array
    int [] fsh = mergeSort(arr,lo,mid);
    int [] ssh = mergeSort(arr,mid+1,hi);
    
    int []fsa = mergeTwoSortedArrays_Inversion(fsh,ssh);

    return fsa;
  }

  //used for merging two sorted arrays
  public static int[] mergeTwoSortedArrays_Inversion(int[] left, int[] right){
    
    
    int i = 0, j =0, k = 0;
    int[] arr = new int[left.length + right.length];
    while(i < left.length && j < right.length){
        if(left[i] <= right[j]){
          arr[k] = left[i];
          i++;
          k++;
        }else{
          arr[k] = right[j];
          inv = inv + (left.length - i); 
          j++;
          k++;
        }
    }

    while(i < left.length){
      arr[k] = left[i];
      k++;
      i++;
    }

    while(j < right.length){
      arr[k] = right[j];
      k++;
      j++;
    }
    
    return arr;
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
    int[] sa = mergeSort(arr,0,arr.length - 1);
    System.out.print("Sorted Array -> ");
    print(sa);
    System.out.println("Number of Inversion");
    System.out.println(inv);
  }

}