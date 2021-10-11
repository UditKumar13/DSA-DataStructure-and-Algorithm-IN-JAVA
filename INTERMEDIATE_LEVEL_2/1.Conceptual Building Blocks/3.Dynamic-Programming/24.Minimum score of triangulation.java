
/*
1. You are given an array of integers, which represents the vertices of an N-sided convex polygon in clockwise order.
2. You have to triangulate the given polygon into N-2 triangles.
3. The value of a triangle is the product of the labels of vertices of that triangle.
4. The total score of the triangulation is the sum of the value of all the triangles.
5. You have to find the minimum score of the triangulation of the given polygon.
 
Input : 
3
1
2
3
Output :
6 


 */
  
import java.io.*;
import java.util.*;

public class Main {

	public static int minScoreTriangulation(int[] arr) {
		int [][] dp = new int [arr.length][arr.length] ; 
		

    for(int g=0; g<dp.length; g++){
      for(int i=0 , j = g; j < dp[0].length; i++,j++){
        if (g==0){
          dp[i][j] = 0 ; 
        }
        
        else if (g==1){
          dp[i][j] = 0 ;
        }
        
        else if(g==2){
          dp[i][j] = arr[i] * arr[i+1] * arr[i+2];
        }
        
        else{
          
          
          // outer loop is for the change on basis of base that starts from arr[i+1] till arr[j-1]
          int min = Integer.MAX_VALUE ; 
          
          for (int k = i+1; k<= j-1 ; k++){
            int tri = arr[i] * arr[k] * arr[j] ; 
            int left = dp[i][k];
            int right = dp[k][j];
            
            int total = tri + left + right  ;
            if (total < min){
              min = total ; 
            }
            
            
          }
          
          dp[i][j] = min ; 
        }
      }
    }
		return dp[0][dp[0].length-1];
    }
  
  
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
		for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(minScoreTriangulation(arr));
	}
}