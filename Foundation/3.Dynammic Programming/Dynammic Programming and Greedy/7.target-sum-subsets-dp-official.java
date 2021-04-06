import java.io.*;
import java.util.*;
// target sum dp 
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        
        int n = scn.nextInt();
        
        int [] arr = new int [n];
        // storing the numbers 
        for (int i=0 ;i <arr.length ;i++){
            arr[i] = scn.nextInt();
        }
        // target sum 
        int tar = scn.nextInt() ;
        
        // now make a 2d array
        // rows : array elements + 1
        // columns : target + 1
        
        boolean  [][] dp = new boolean [n+1][tar+1];
        
        for (int i=0 ; i<dp.length ;i++){
            
            for (int j=0;j<dp[0].length;j++){
                
                //4 cases 
                
                //for 1st cell :
                if (i==0 && j==0){
                    dp[i][j] = true;
                }
                // 1 row 
                else if (i==0){
                    dp[i][j] = false ;
                }
                
                // 1st column 
                else if (j==0){
                    dp[i][j] = true;
                }
                // logic resides here 
                else {// seeing if sum already exits or not
                // ye current element khud batting nhi kr rha abhi pichle team waalon ko bol rha tu krr payega sum score
                    if (dp[i-1][j] == true ){
                        dp[i][j] = true;
                    }
                    //agar haan achi baat hai ,but agar nhi toh khud khelega auur kosish krega sum achieve krne ki
                    else{//iska khud ka sum , ith index se 1 kam mein hoga , let it be val 
                        int val = arr[i-1];
                        // ab bakai ke run  jo reh gye haan dp array mein pichli row ke bache hue sum waale cell se pucho 
                        //woh bna payega yaa nahi 
                        //so we have to traverse and check "dp[i-1][j-val]""
                        
                        if (j>=val){
                        if (dp[i-1][j-val]== true){
                            dp[i][j] =true;
                        }
                        
                        
                        
                        }
                    }
                   
                   
                   
                }
                
            }
        }
        
        
                System.out.println(dp[arr.length][tar]);
        
        
    }
}