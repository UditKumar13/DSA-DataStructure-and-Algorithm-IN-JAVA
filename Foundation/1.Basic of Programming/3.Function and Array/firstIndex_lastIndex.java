import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // Nice game going on 
    // first index last index in an duplicate value arr
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int [] arr = new int [n];
    //filling array with n values
    for (int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }
    //data to find
    
    int data = scn.nextInt();
    //logic for first index and last index
    int first =-1;
    int last=-1;
    int low=0;
    int high =arr.length-1;
    while(low<=high){
        int mid = (low+high)/2;
        if (data>arr[mid]){
            low = mid+1;
            
        }
        
        else if(data<arr[mid]){
            high=mid-1;
        }
        
        //for finding the last index
        else{last=mid;
            low=mid+1;
            
            
        }
    }
    
    // we have to start from the starting to check in the left direction from the 
    //first encounter 
    low=0;
    high=arr.length-1;
    
    while(low<=high){
        int mid = (low+high)/2;
        if (data>arr[mid]){
            low = mid+1;
            
        }
        
        else if(data<arr[mid]){
            high=mid-1;
        }
        
        //for finding the first index
        else{first=mid;
            high=mid-1;
            
            
        }
    }
    
   System.out.println(first);
   System.out.println(last);
 }

}