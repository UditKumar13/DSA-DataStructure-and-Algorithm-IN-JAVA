import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
/*
1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) Length of "Longest Increasing Subsequence"(LIS).
    3.2) All "Longest Increasing Subsequence(s)"(LIS).
NOTE: Checkout sample question/solution video inorder to have more insight.

Input : 
10
10 22 9 33 21 50 41 60 80 1

Output :
6
10 -> 22 -> 33 -> 41 -> 60 -> 80
10 -> 22 -> 33 -> 50 -> 60 -> 80


*/
public class Main{
    
    public static class Pair {
        int l;
        int i;
        int v;
        String psf;
        
        Pair(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
        
    public static void solution(int []arr){
      
      // code for finding the LIS
     int [] dp = new int [arr.length] ;
      
      int omax = 0 ; 
      int omi = 0 ; // overall max index 
      for (int i=0; i<dp.length;i++){
        int max = 0 ;
        
        for (int j=0 ; j<i ; j++){
             if (arr[j] <= arr[i] ){
               if (dp[j] >max){
                 max = dp[j];
               }
             }         
        }
        
        dp[i] = max+1 ;
        if (dp[i] > omax){
          omax = dp[i] ; 
          omi = i ; 
        }
      }
      
      System.out.println(omax) ; 
      
      ArrayDeque <Pair> que = new ArrayDeque <>() ; 
      // length, index, val, psf 
      for (int i =0; i<arr.length; i++){
        if (dp[i] == omax){
          que.add(new Pair(omax, i,arr[i], arr[i]+""));
        }
      }

      
      while(que.size()>0){
        Pair rem = que.removeFirst() ; 
        
        if (rem.l == 1){
          System.out.println(rem.psf) ; 
        }
        
        for (int j=rem.i -1; j>=0;j--){
          if (dp[j] == rem.l-1 && arr[j] <= rem.v ){
            que.add(new Pair(dp[j],j,arr[j],arr[j] + " -> " + rem.psf ));
          }
        }
      }
      
    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}