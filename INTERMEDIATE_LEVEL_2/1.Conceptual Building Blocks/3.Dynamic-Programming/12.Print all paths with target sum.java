import java.io.*;
import java.util.*;
/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "tar" or not.
5. Also, you have to print the indices of elements that should be selected to achieve the given target.
6. You have to print all such configurations.

Input :
5
4
2
7
1
3
10
Output :
true
2 4 
1 2 3 
0 1 3 4 
*/
public class Main {

    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        boolean [][] dp = new boolean [arr.length+1][tar+1] ;
        
      for (int i=0;i<dp.length;i++)
      {
        for (int cur_tar=0;cur_tar<dp[0].length; cur_tar++) {
          if (cur_tar==0){
            // first col all ture
            dp[i][cur_tar] =true ; 
            
          }
          else if(i==0){
            // rathe than first ele all first row is false 
            dp[i][cur_tar] = false ; 
          }
          
          else{
            // previous player hi run bna leta hai
              if (dp[i-1][cur_tar]){
                // if yes , cur_player will also
                dp[i][cur_tar] = true ; 
              } 
            // target val is greater than the ith player potential
            else if(cur_tar >= arr[i-1]){
              if(dp[i-1][cur_tar - arr[i-1]] == true ){
                dp[i][cur_tar] = true ; 
              }
            }
          }
          
          
        }
      }
      
      System.out.println(dp[arr.length][tar]); 
      
      // lets make the reverse engineering to print the indexes of the arr elements (subsets)which contributes to make the target sum possible 
      
      ArrayDeque <Pair> queue = new ArrayDeque<>();
      //start from the last right corner of the 2d  dp  array 
      queue.add(new Pair(n,tar,""));
      
      while (queue.size()>0){
        Pair rem = queue.removeFirst() ; 
        
        // base case 
        if (rem.i == 0 || rem.j == 0){
          System.out.println(rem.psf); 
        }
        else{
          
      
          
            // included
        if (rem.j >= arr[rem.i -1]){
           //check the condition
              boolean inc = dp[rem.i-1][rem.j - arr[rem.i-1]] ; 
          if (inc){
            queue.add(new Pair(rem.i-1 , rem.j - arr[rem.i-1],(rem.i -1) + " " + rem.psf  ));
          }
        }
          boolean exc = dp[rem.i-1][rem.j];
        // excluded 
          
        if (exc){
          queue.add(new Pair (rem.i-1, rem.j , rem.psf));
        }
    
      
        }
      }
    }
}


                        


                        