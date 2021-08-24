import java.io.*;
import java.util.*;

/*
1. You are given an array of numbers.
2. All numbers occur twice in the array except one.
3. You have to find that number by traversing only once in the array and without using any extra 
     space.
*/
public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();  // there are n numbers 
    int[] arr = new int[n]; // array of those n numbers 
    for(int i = 0 ; i < n; i++){ 
      arr[i] = scn.nextInt();
    }
    
        
int num = 0 ;

for(int i=0 ; i<arr.length; i++){
    num ^= arr[i] ; 
}

System.out.println(num); 

}

}