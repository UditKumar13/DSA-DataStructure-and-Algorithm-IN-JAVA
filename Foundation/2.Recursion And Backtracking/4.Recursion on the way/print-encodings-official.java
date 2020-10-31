import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String que = scn.next();
        printEncodings(que,"");
        

    }

    public static void printEncodings(String que,String taara){
        
        if (que.length()==0){
            System.out.println(taara);
            return;
        }
        // one character
        else if(que.length()==1){
            char ch = que.charAt(0);
            if(ch=='0'){
                return;
            }
            else{
                int chv =ch-'0';
                // for converting it into char back bcz (char + int = int ho jaata hai)
                char code = (char)('a' + chv -1);
                System.out.println(taara+code);
            }
        }
        // greater than >= 2 length
        else{
            char ch = que.charAt(0);
            String roq = que.substring(1);
            if (ch=='0'){
                return ;
            }
            
            else {
                int chv =ch-'0';
                 char code = (char)('a' + chv -1);
                 
                 printEncodings(roq,taara+code);
                
                
                 }
                 
            String ch1 = que.substring(0,2);
                 String roq1 = que.substring(2);
                 int ch1v = Integer.parseInt(ch1);
                 if (ch1v<=26){
                      char code = (char)('a' + ch1v -1);
                 taara = taara +code;
                 printEncodings(roq1,taara);
                          
            }
            
        }
        
        
        
    }

}