import java.io.*;
import java.util.*;

public class Main {

  public static void targetSumPair(int[] arr, int target){
    //target  sum pair 
    int l =0; // left pointer 
    int r= arr.length-1; //right pointer
    // step 1 sort the array first 
    Arrays.sort(arr);
    
    while(l<r){
        if ((arr[l] + arr[r])>target){
            r--;
        }
        else if ((arr[l] + arr[r])<target){
            l++;
        }
        
        else if ((arr[l] + arr[r])==target){
            System.out.println(arr[l] + ", " + arr[r]);
            l++;
            r--;
        }
    }
    

  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}