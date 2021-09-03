import java.io.*;
import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
       // lets do it 
       int rbits = 0 ; 
       for(int val : arr){
           
           if(rbits == 0 ){
               
           if( (val >> 7) == 0b0 ){ // 1st byte of 1 length char 
               rbits = 0 ; 
           }
           
           else if((val >> 5) == 0b110){ // 1st byte of 2 length char 
               rbits = 1;
           }
           
           else if((val >> 4) == 0b1110){ // 1st byte of 3 length char 
               rbits = 2;
           }
           
           else if((val >> 3) == 0b11110){ // 1st byte of 4 length char 
               rbits = 3 ; 
           }
           
           }
           
           else{
               // if there is remaining bits
               if((val >> 6 ) == 0b10){
                   rbits -- ; 
               }
               
               else{
                   return false ; 
               }
           }
           
       }
       
       if(rbits == 0)
          return true  ;
       else  
          return false ; 
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    
    
}