import java.io.*;
import java.util.*;


/*
1. You are given a number n, representing the number of envelopes.
2. You are given n pair of numbers, representing the width and height of each envelope.
3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
Note -> Rotation is not allowed.

Input : 
11
17 5
26 18
25 34
48 84
63 72
42 86
9 55
4 70
21 45
68 76
58 51

Output :
5

*/


public class Main {
    
    public static class Envelope implements Comparable<Envelope>{
        int w; 
        int h ; 
        
        Envelope(int w, int h){
          this.w = w ; 
          this.h = h ; 
        }
        
        public  int compareTo(Envelope o){
            return this.w - o.w ; 
            // return in the ascending order 
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        int n = Integer.parseInt(scn.nextLine());
        
        Envelope [] env = new Envelope [n]  ;
        
        for (int i =0 ; i<n ;i++){
            String line = scn.nextLine();
            String [] parts = line.split(" ");
            int width = Integer.parseInt(parts[0]);
            int height = Integer.parseInt(parts[1]);
            env[i] = new Envelope(width,height);
            
        }
        
        Arrays.sort(env);
        // Step 1 . Internally sorting by the comparable , and sorting in the increasing order of width
        //Step 2 . Cal LIS on the height 
        
        int omax =0  ;
        
        int [] dp = new int [n] ;
        
        for (int i=0;i<dp.length;i++){
             int max = 0;
           for(int j=0;j<i;j++ ){
               
              
               // have to check for the increasing order of height
               if ((env[j].h < env[i].h) && (env[j].w < env[i].w)){
                   if (dp[j] > max){
                       max = dp[j] ; 
                   }
               }
               
             }
            
            dp[i] = max + 1 ; 
            
            if (dp[i] > omax){
                omax = dp [i] ; 
            }
              
           }
        System.out.println(omax) ; 
        }
    }

