import java.io.*;
import java.util.*;


/*
1. You are given a number n, representing the number of bridges on a river.
2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
3. You are required to print the count of maximum number of non-overlapping bridges.

Input : 
10
10 20
2 7
8 15
17 3
21 40
50 4
41 57
60 80
80 90
1 30

Output :
7
*/
public class Main {
    public static class Bridge implements Comparable<Bridge>{
        int n ; 
        int s ;
         
        Bridge(int n, int s){
            this.n = n ;
            this.s = s ; 
        }
        
        public  int compareTo(Bridge o){
            
        // sorting on the basis of the north small value 
        if (this.n != o.n){
            return this.n - o.n ; 
        }
            
        // but what if the north values are same now we  have to sort the array on the basis of the small south value
            else{
                return this.s - o.s ; 
            }
            
            
    }
        
        
    }
    
    
    public static void main(String[] args) throws Exception {
    Scanner scn  = new Scanner(System.in) ;
        int num = Integer.parseInt(scn.nextLine()); 
        
        Bridge [] bdgs = new Bridge [num] ;
        for (int i =0 ; i<num ; i++){
          String line = scn.nextLine() ; 
          String [] parts = line.split(" ");
          int n = Integer.parseInt(parts[0] );
          int s = Integer.parseInt(parts[1]);
            
         bdgs [i] =  new Bridge(n,s);
            
        }
        
        // this sorting makes sure the sorting happens based on the increasing order of the north bank
        Arrays.sort(bdgs);
        // lets use the lis on the right bank
        int omax =0 ; 
        int [] dp = new int [num] ; 
        for (int i =0 ; i<dp.length ;i++){
            int max = 0 ; 
            
            for (int j = 0 ; j<i ; j++){
                if (bdgs[j].s <= bdgs[i].s){
                    if (dp[j] > max){
                        max = dp[j]; 
                    }
                }
            }
            dp[i] = max + 1 ;
            if (dp [i] > omax){
                omax = dp [i]; 
            }
        }
        
        System.out.println(omax);
    }
    
    

}