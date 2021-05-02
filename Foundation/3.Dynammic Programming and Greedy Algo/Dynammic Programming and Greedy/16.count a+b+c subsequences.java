import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        // string as input
        String str = scn.next();
        
        
        int a = 0;
        int ab =0;
        int abc =0;
        
        // a denotes the strings with only a repeated 
        // ab denotes strings starting with any no of a , then followed by b 
        // abc demotes example : aaaaabbbbccccc
        //logic : 1 _ number
        for (int i=0;i<str.length();i++){
            char cur_char = str.charAt(i);
            
            if (cur_char =='a'){
                a = 2*a+1;
            }
            
            else if(cur_char =='b'){
                ab=2*ab+a;
            }
            
            else if(cur_char =='c'){
                abc=2*abc + ab;
            }
            
    }
    
    
        
    System.out.println(abc);    

    }
}