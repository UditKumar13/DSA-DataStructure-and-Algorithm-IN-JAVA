import java.io.*;
import java.util.*;
/*
1. Pepcoder is feeling confident after solving many problems on Bit Manipulation.
2. So, his teacher ask him to find out the count of positive integers strictly less than N, having same 
     number of set bits as that of N.
3. Let us see that if pepcoder can solve it or not.
*/
public class Main {
    public static long ncr(long n, long r){
        if(n < r){
            return 0L;    
        }
        
        long res = 1L;
        
        for(long i = 0L; i < r; i++){
            res = res * (n - i);
            res = res / (i + 1);
        }
        
        return res;
    }
    
    public static long solution(long n, int k, int i) {
      
      // lets do it our way 
      
      // base case 
      if(i==0){
          return 0 ; 
      }
      
      long mask = 1L << i ;
      
      long res = 0 ;
      
      if((n & mask) == 0){
          // the msb bit is off that means simple recursion with the i-1, 1 less bit
         res =  solution (n,k,i-1);
      }
      
      else{
          // the msb bit is on, that means its not simple recursion, we have to build something with logic, here we will have 2 options in hand 
          
          long res1 = solution(n,k-1,i-1);
          long res0 = ncr(i,k);
          res = res1 + res0 ; 
          
      }
      
      return res ; 
    }
    
        public static int csb(long n){
            int res = 0 ;
            
            while(n > 0 ){
                long rsb  = n & -n ;
                n -= rsb ; 
                res++; 
            }
            return res ; 
        }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        int k = csb(n);
        // why we have used 63 because for long it is the longest bit defined in long. 
        System.out.println(solution(n, k, 63));
    }
	
	
}