/*

Question :
1. You are given a number M representing length of highway(range).
2. You are given a number N representing number of bill boards.
3. You are given N space separated numbers representing (P)position of bill-boards.
4. You are given N space separated numbers representing (R)revenue corresponding to each (P)position.
5. You are given a number T such that bill-boards can only be placed after specific distance(T).
6. Find the maximum revenue that can be generated.

Input :
20
5
6 7 12 14 15
5 8 5 3 1
5
Output :
11
*/

import java.util.*;
public class Main{
    public static int solution(int m , int[] x, int[] rev, int t) {
        
        // 0(m) approach 
      
      int [] dp = new int [m+1] ;
      HashMap <Integer,Integer> map = new HashMap <>() ;
      
      
      for (int k =0 ; k<x.length ; k++){
        map.put(x[k], rev[k]) ; 
      }
      
      
      dp[0] = 0 ; 
      // base case
      for (int i=1 ; i<=m ; i++){
      if (map.containsKey(i) == false ){
        dp[i] = dp[i-1] ; 
      }
        else {
          
        int noBoard  = dp[i-1] ;
          
          
          
        int withBoard = map.get(i) ; 
        
        if (i>= t+1){
         
          withBoard +=  dp[i-t-1];  

        }
          
        dp[i] = Math.max(noBoard, withBoard) ;  
          
        }
        
       
        
        
      }
      
      
      
        return dp[m] ;
    }
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}