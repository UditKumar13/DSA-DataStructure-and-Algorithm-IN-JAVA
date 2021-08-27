import java.io.*;
import java.util.*;

/*

1. You are given a positive number N.
2. You have to find the minimum number of operations required to convert N into 1.
3. Operations allowed :
     (i)  If n is even, you have to replace n with n/2.
     (ii) If n is odd, you can replace n with either n-1 or n+1.
     
     Input : 8
     
*/
public class Main {

    public static int solution(long n) {
        
        // sometimes be very careful, because u are doing the operation n = n +1 in some case, suppose the input is all 1's , tle comes,
        // the best way to tackle this problem is take long n , instead of int n.
        
        int res = 0 ; 
        
        while(n!=1){
            
            if(n%2==0){
                n = n / 2 ; 
            }
            
            else if( n == 3){
                
                res = 2 ; 
                break ; 
                
            }
            
            else if((n & 3) == 1){
                
                // 4x+1
                n = n-1 ; 
                
            }
            
            else if((n & 3) == 3 ){
                
                // 4x + 1 
                n = n + 1 ; 
                
            }
            
            res++; 
        }
        return res ;
    }
    
	public static void main(String[] args) {
	    
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
        
    }
}