import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // Nice game going on !
    
    Scanner scn = new Scanner(System.in);
    int  n = scn.nextInt();
    int [] arr = new int  [n];
    
    for (int i=0;i<n;i++){
        
        arr[i]= scn.nextInt();
    }
    int find_ele = scn.nextInt();
    int floor =-1;
    int ceil= -1;
    
    int l=0;
    int h=arr.length-1;
    
    while(l<=h){
        int mid = (l+h)/2;
        
        if (find_ele>arr[mid]){
            l=mid+1;
            floor=arr[mid];
            
        }
        else if (find_ele<arr[mid]){
            h=mid-1;
            ceil=arr[mid];
            
        }
        
        else{
            ceil=arr[mid];
            floor=arr[mid];
            break;
        }
    }
    
    System.out.println(ceil);
    System.out.println(floor);
 }

}