import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String taara = scn.nextLine();
        printKPC (taara,"");
        //taara : 678
    }
    
    static String [] codes = {".;","abc","def","ghi","jkl","mno","pqrs",
    "tu","vwx","yz"};
    
    public static void printKPC(String que, String ans) {
        //base case 
        if (que.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = que.charAt(0);//6
        String roq = que.substring(1);//78
        
        String res = codes[ch-'0'];//pqrs
        for (int i=0;i<res.length();i++){
            char option = res.charAt(i);//p
            printKPC(roq,ans+option);
            
            
        }
        
        
    }

}