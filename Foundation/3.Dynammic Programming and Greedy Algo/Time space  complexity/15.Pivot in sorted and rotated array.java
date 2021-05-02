import java.io.*;
import java.util.*;

public class Main {

  public static int findPivot(int[] arr) {
    // find Pivot 
    int lo = 0;
    int hi= arr.length-1;
    
    
    while (lo<hi){
        int mid = (lo+hi)/2;
        // mid chota hai high se pivot left side hi milegaa
        if (arr[mid]<arr[hi]){
            hi = mid;
        }
        //pivot right side milegaa mid >  hi
        else{
            lo=mid+1;
        }
    }
    // when arr[lo]  == arr[hi] u will get the pivot
    return arr[hi];
    
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int pivot = findPivot(arr);
    System.out.println(pivot);
  }

}