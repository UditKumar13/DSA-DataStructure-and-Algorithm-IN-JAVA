/*
Problem Statement : 
1. You are given two arrays - 
     The first array(keys), which is sorted and has distinct integers, represents search keys.
   Second one(freq) represents frequency counts, where freq[i] is the number of searches to keys[i].
2. A binary search tree is constructed containing all keys and the total cost of searches is minimum. 
3. The cost of a BST node is the level of that node multiplied by its frequency.
4. You have to find the minimum cost of all searches.

Input :
9
1
3
4
5
6
7
8
9
11
3
6
4
8
7
3
7
4
7

Output :
125

*/


import java.io.*;
import java.util.*;

public class Main {
  
  private static void optimalbst(int[] keys, int[] frequency, int n) {
    int [][] dp = new int [n][n] ;
    
    
    int [] psa  = new int [n] ;
    
    psa [0]  = frequency[0];
    
    for(int  i=1 ; i< frequency.length; i++){
      psa [i]  = psa [i-1] + frequency [i] ; 
    }
    
    // gap strategy 
    
    for(int g=0; g<dp.length ;g++){
      for(int i=0,j=g; j<n ; i++,j++){
        if (g == 0 ){
          dp [i][j] = frequency[i] ;  
        }
        
        else if( g==1 ){
          
          int f1 = frequency[i];
          int f2 = frequency[j] ;
          dp[i][j]  = Math.min(f1 + 2*f2 , f2 + 2*f1) ;
          
        }
        
        else{
          
          // for handling the general case 
          
          int min  = Integer.MAX_VALUE ; 
          int fs = psa [j] - (i==0 ? 0 :psa[i-1]) ; 
          
          for(int k=i ; k<=j ; k ++){
            int left = k==i?0:dp[i][k-1] ;  
            int right = k==j?0: dp[k+1][j] ;
            
            if(left + right + fs < min ){
              min = left + right + fs ; 
            }
            
          }
          dp [i][j] = min ; 
        }
      }
    }
    System.out.println( dp[0][n-1] )  ; 
	}

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
	int[] keys = new int[n];
	int[] frequency = new int[n];
    for(int i= 0 ;i < n ; i++) {
		keys[i] = scn.nextInt();
	}
	for(int i = 0 ; i < n; i++){
      frequency[i] = scn.nextInt();
    }
	optimalbst(keys,frequency,n);
	}

}