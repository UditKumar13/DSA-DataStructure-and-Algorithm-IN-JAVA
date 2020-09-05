import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // Nice game going on
    
    Scanner scn = new Scanner(System.in);
    int n1 =scn.nextInt();
    int [] arr1 = new int [n1];
    // first array
    for (int i=0;i<n1;i++){
        arr1[i] = scn.nextInt();
    }
    int n2 =scn.nextInt();
    int [] arr2 = new int [n2];
    //second array
    for (int i=0;i<n2;i++){
        arr2[i] = scn.nextInt();
    }
    
    
    
    // adding two arrays
int [] sum_arr = new int [n1>=n2? n1 : n2];
int i = arr1.length-1;
int j = arr2.length-1;
int k = sum_arr.length-1;
//starting addition from the last index till 0 
int carry=0;

while (k>=0){
    //initializaton take care of last carry 
    int d = carry;
    if (i>=0){
        d = d +arr1[i];
    }
    
    if (j>=0){
        d = d+ arr2[j];
    }
    
    carry = d /10;
    d = d % 10;
    //saving ele in new sum_arr from the last index to 0
    sum_arr[k]=d;
    
    
    i--;
    j--;
    k--;
    
   
    
    
    
}
// because first the carry will print if get saved e.g (999 + 28) case
if (carry!=0){
    System.out.println(carry);
}
// special way of writing to print val directly
for (int val : sum_arr){
    System.out.println(val);    
}

    
 }

}