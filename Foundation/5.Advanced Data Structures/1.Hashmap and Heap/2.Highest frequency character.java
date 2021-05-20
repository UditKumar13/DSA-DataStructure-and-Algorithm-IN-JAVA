import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        
        // create a hashmap
        
        HashMap <Character , Integer> hm = new HashMap <>();
        
        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            
            if (hm.containsKey(ch)){
                int of = hm.get(ch);
                int nf = of + 1 ;
                
                hm.put(ch,nf);
            }
            
            else{
                // first time we get this character
                hm.put(ch,1);
                
                
            }
        }
        // maximum frequency  character : mfc 
        char mfc = str.charAt(0) ;
        // till now our hasmap is ready 
        for (Character key : hm.keySet()){
            if (hm.get(key) > hm.get(mfc)){
                mfc = key;
            }
        }
        
        System.out.println(mfc);
    }

}