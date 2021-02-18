import java.io.*;
import java.util.*;

public class Main {
    public static int giveMin(int m ,int n){
        if (m<=n){
            return m; 
        }
        else{
            return n;
        }
        
    }

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    //merge algo
    int len = a.length + b.length;
    int [] mer = new int[len];
    int i=0,j=0;
    int k=0;
    while (i<a.length && j<b.length){
        if (a[i]<=b[j]){
            mer[k]=a[i];
            i++;
            k++;
        }
        else{
            mer[k]=b[j];
            j++;
            k++;
        }
        
        
       
        
    }
    
       // suppose a was bigger array than b , a is still remaining 
       //just copy the content the a in merge algo
       while (i<a.length){
              mer[k]=a[i];
            i++;
            k++;
       }
       
       while(j<b.length){
           mer[k]=b[j];
           j++;
           k++;
       }
    
    return mer;
 
}
  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}