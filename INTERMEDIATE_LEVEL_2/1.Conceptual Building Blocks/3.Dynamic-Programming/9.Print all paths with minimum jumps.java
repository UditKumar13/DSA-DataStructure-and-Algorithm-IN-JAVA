import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
    3.2) all configurations of "MINIMUM JUMPS".
NOTE: Checkout sample question/solution video inorder to have more insight. 

Input : 
10
3
3
0
2
1
2
4
2
0
0

Output :
4
0 -> 3 -> 5 -> 6 -> 9 .
0 -> 3 -> 5 -> 7 -> 9 .
*/
public class Main{
  // reverse Engineering 
  public static class Pair{
    int i;
    int s ;
    int j;
    String psf ; 
    
    Pair(int i,int s,int j ,String psf){
      this.i=i;
      this.j=j;
      this.s = s;
      this.psf = psf ;
    }
  }
    public static void Solution(int arr[]){
        Integer [] dp = new Integer[arr.length] ;
        dp[arr.length-1] = 0 ;
        for (int i=arr.length-2; i>=0  ; i--){
            int steps = arr[i];
            int min = Integer.MAX_VALUE;
            for (int j = 1;j<=steps && i+j < arr.length; j++){
                if (dp[i+j]!= null && dp[i+j]<min){
                    min = dp[i+j]; 
                }
            }
          
          if (min != Integer.MAX_VALUE){
            dp[i]= min + 1 ; 
          }
        }
      System.out.println(dp[0]);
    // to print the path
      ArrayDeque <Pair> queue = new ArrayDeque<>();
      queue.add(new Pair(0,arr[0],dp[0],0+""));
      while(queue.size()>0){
      Pair rem = queue.removeFirst();
      if (rem.j ==0 ){
        System.out.println(rem.psf + " .");
      }
        for (int j=1; j<=rem.s && rem.i + j <arr.length; j++){
           int ci = rem.i + j ;
          // logic of selecting the next path index 
          if(dp[ci]!= null && dp[ci] == rem.j -1){
            queue.add(new Pair(ci,arr[ci],dp[ci],rem.psf + " -> " + ci));
          }
        }
      }
      
      
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
