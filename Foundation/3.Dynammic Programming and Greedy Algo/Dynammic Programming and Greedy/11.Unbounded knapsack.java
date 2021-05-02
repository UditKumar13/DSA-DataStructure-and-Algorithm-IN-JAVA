	import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
	        // unbounded knapsack
	        Scanner scn = new Scanner (System.in);
	        
	        int items = scn.nextInt();
	        int [] costs = new int [items];
	        int [] weights = new int [items];
	        
	        //costs
	        for (int i=0;i<costs.length;i++){
	            costs[i] = scn.nextInt();
	        }
	        // weights
	        for (int i=0;i<weights.length;i++){
	            weights[i] = scn.nextInt();
	        }
	        
	        // bag_weight
	        int bag_weight = scn.nextInt();
	        // 1d dp array for having duplicacy ,because duplicate  items are  allowed
	        //that's why we will use 1 d array rather than 2d 
	        // 0 1 knapsack (2d array , no duplicate )
	        int [] dp = new int [bag_weight+1];
	        dp[0] = 0;
	        
	        for (int bag_cp=1; bag_cp<dp.length ; bag_cp++){
	            int max =0 ;
	            for (int item=0;item<items;item++){
	                
	              if ( bag_cp>=weights[item] ){
	                  int rem_bagcp = bag_cp - weights[item]; // 2-1
	                  int rem_val = dp[rem_bagcp]; // dp[1]
	                  int tbag_val = costs[item] + rem_val;
	                  
	                  if (max<=tbag_val){
	                      max = tbag_val;
 	                  }
	                  
	                  
	                  
	              }
	            }
	            dp[bag_cp] = max;
	            
	                                         }
	                                         
	                                         
	                                         
	                                         
	  System.out.println(dp[bag_weight]);

	    }
	}