import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // Nice game going on 
    Scanner scn = new Scanner (System.in);
    int n1 = scn.nextInt();
    int [] arr1 = new int [n1];
  for (int i=0;i<n1;i++){
      arr1[i] = scn.nextInt();
                     }
 
    int n2 = scn.nextInt();
    int [] arr2 = new int [n2];
  for (int i=0;i<n2;i++){
      arr2[i] = scn.nextInt();
                     }
 
// arr2 > arr1 
int [] diff_arr = new int [n2];
int carry =0;
int p=1;
int i=arr1.length -1 ;
int j = arr2.length -1;
int k =diff_arr.length-1;
while (k>=0){
    int d=0;
    
    int a1v = i>=0 ? arr1[i] : 0;
  if (arr2[j] + carry >= a1v){
      d = arr2[j] + carry -a1v;
      carry=0;
  }
  
  else{d =  arr2[j] + carry + 10 -a1v;
      carry=-1;
      
  }
    
    diff_arr[k] =d ;
    
    
    
    i--;
    j--;
    k--;
    
}
//logic for not printing the starting zeroes 

int count =0 ;
for (int t=0;t<diff_arr.length;t++){
    if (diff_arr[t]!=0){
        break;
    }
    count++;
    
    
}
for (int t=count ; t<diff_arr.length;t++){
    System.out.println(diff_arr[t]);
}
}
}