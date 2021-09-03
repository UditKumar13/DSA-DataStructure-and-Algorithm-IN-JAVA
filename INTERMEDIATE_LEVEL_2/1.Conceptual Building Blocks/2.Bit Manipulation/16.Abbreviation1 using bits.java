import java.io.*;
import java.util.*;
/*
1. You are given a word.
2. You have to generate all abbrevations of that word.
Note - Use bit manipulation

Input : pep

Output :

pep
pe1
p1p
p2
1ep
1e1
2p
3
*/
public class Main {

    public static void solve(String str){
        for (int i=0; i< (1<<str.length()) ;i++){
            StringBuilder sb  = new StringBuilder (); 
            int count = 0 ; 
            for(int j =0 ;j<str.length();j++){
                char ch = str.charAt(j); 
                int bit = str.length() - j -1 ; 
                // checking the bit on or off 
                if ((i & (1<<bit)) == 0 ){
                    // off
                    if(count == 0 ){
                        sb.append(ch );
                    }
                    
                    else{
                        sb.append(count);
                        sb.append(ch);
                        count = 0 ;
                    }
                }
                else{
                    // on
                    count++; 
                }
                
                
            }
            if(count>0){
                sb.append(count);
            }
            System.out.println(sb);
            
            
        }
     
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
    }
}