import java.io.*;
import java.util.*;

/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
8. Also, you have to print all paths with maximum gold.

Input : 
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

Output :
33
4 d3 d1 d2 d3 d1 

*/
public class Main {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      int [][] dp = new int [arr.length][arr[0].length];
     
     for (int j=arr[0].length-1; j>=0 ; j--){
       for (int i =0 ; i<arr.length;i++){
         if (j== dp[0].length-1){
           // last col
           dp[i][j] = arr[i][j]; 
         }
         
         else if(i==0){
           //first row 
          dp[i][j] = arr[i][j] + Math.max(dp[i+1][j+1],dp[i][j+1]);
         }
         
         else if(i ==dp.length-1){
           // last col 
              dp[i][j] = arr[i][j] + Math.max(dp[i-1][j+1],dp[i][j+1]);
         }
         
         else{
            dp[i][j] = arr[i][j] + Math.max(dp[i-1][j+1],Math.max(dp[i][j+1],dp[i+1][j+1] ));
         }
       }
     }
     
     // printing the max value of gold 
     int max= Integer.MIN_VALUE ; 
     for (int i = 0 ; i<arr.length; i++){
       if (max < dp[i][0]){
         max = dp[i][0];
       }
     }
     
     System.out.println(max);
     // printing the path 
     ArrayDeque <Pair> queue = new ArrayDeque<>();
     for (int i = 0 ; i<arr.length; i++){
       if (max == dp[i][0]){
         // adding it as the starting point in the queue
         queue.add(new Pair(i + " ",i,0));
       }
     }
     
     while(queue.size()>0){
       Pair rem = queue.removeFirst();
       
       if (rem.j == arr[0].length-1){
         // last col 
         System.out.println(rem.psf);
       }
       
       else if(rem.i == 0 ){
         // first row 
         int g = Math.max(dp[rem.i][rem.j+1], dp[rem.i+1][rem.j+1]);
         
         if(g == dp[rem.i][rem.j+1]){
           queue.add(new Pair(rem.psf + "d2 ", rem.i , rem.j+1));
         }
         if(g == dp[rem.i+1][rem.j+1]){
           queue.add(new Pair(rem.psf + "d3 ", rem.i+1 , rem.j+1));
         }
         
       }
       
       else if(rem.i == arr.length-1){
         //last row 
         int g = Math.max(dp[rem.i][rem.j+1], dp[rem.i-1][rem.j+1]);
         
          if(g == dp[rem.i-1][rem.j+1]){
           queue.add(new Pair(rem.psf + "d1 ", rem.i-1 , rem.j+1));
         }
         
         if(g == dp[rem.i][rem.j+1]){
           queue.add(new Pair(rem.psf + "d2 " , rem.i , rem.j+1));
         }
        
       }
       
       else{
            int g = Math.max(dp[rem.i][rem.j+1], Math.max(dp[rem.i-1][rem.j+1], dp[rem.i+1][rem.j+1]));
         if(g == dp[rem.i-1][rem.j+1]){
           queue.add(new Pair(rem.psf + "d1 ", rem.i-1 , rem.j+1));
         }
         if(g == dp[rem.i][rem.j+1]){
           queue.add(new Pair(rem.psf + "d2 ", rem.i , rem.j+1));
         }
         
         if(g == dp[rem.i+1][rem.j+1]){
           queue.add(new Pair(rem.psf + "d3 ", rem.i+1 , rem.j+1));
         }
       }
     }
   }


}