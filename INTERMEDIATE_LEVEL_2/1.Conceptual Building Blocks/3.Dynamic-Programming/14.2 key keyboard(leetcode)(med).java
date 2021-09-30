import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n) {
	 int ans = 0 ;
      // loop  for the logic similar to prime numbers 
      for (int uk=2; uk*uk<=n ;){
        if(n%uk == 0){
          ans+= uk ;
          n/= uk ; 
        }
        
        else{
          uk++; 
        }
      }
      
      if (n!= 1){
        ans+= n ; 
      }
      return ans ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}