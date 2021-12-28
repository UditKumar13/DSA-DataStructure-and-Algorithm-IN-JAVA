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

import java.util.Scanner;
public class Main{
    public static int solution(int m , int[] x, int[] rev, int t) {
        
        // 0(n^2)
      
      int n = x.length ; 
      
      int [] dp = new int [n] ;
      
      int ans = 0 ;
      dp[0] = rev[0]; 
      for (int i =1 ; i<n ; i++ ){
        int max = 0 ; 
        for (int j = 0 ; j< i ; j++){
           
          int dist  = x[i] - x[j] ;
          
          if (dist > t){
            max= Math.max(max,dp[j]) ;  
            
            
          }
          
         
          
          
        }
        
         dp[i] = max + rev[i] ; 
          
         ans = Math.max(ans, dp[i]) ; 
      }
      
        return ans ;
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