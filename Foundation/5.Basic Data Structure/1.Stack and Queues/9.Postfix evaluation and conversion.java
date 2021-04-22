import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    // value stack vs , infix stack is , prefixstack ps
    Stack<Integer> vs = new Stack<>();
    Stack<String> is = new Stack<>();
    Stack<String> ps = new Stack<>();
    
    for (int i=0; i<exp.length();i++){
        char ch = exp.charAt(i);
        
        if (ch=='+' || ch=='-' || ch=='*' || ch=='/'  ){
            int v2 = vs.pop();
            int v1 = vs.pop();
            int val = operation(v1,v2,ch);
            
            vs.push(val);
            
            // now for infix and prefix 
            
            String is2 = is.pop();
            String is1 = is.pop();
            
            String ispu = "(" + is1 + ch + is2 + ")";
            is.push (ispu);
            
            // for prefix 
            String ps2 = ps.pop();
            String ps1 = ps.pop();
            String pspu = ch + ps1 + ps2 ;
            ps.push(pspu);
            
        }
        
        else{
            vs.push(ch-'0'); 
            is.push(ch + "");
            ps.push(ch + "");
        }
    }
    
    System.out.println(vs.pop());
    System.out.println(is.pop());
    System.out.println(ps.pop());
    
    
 }
 
 
 public static int operation (int v1 ,int v2 , char ch){
     int val = 0 ;
     if ( ch == '+'){
         val = v1+v2;
         return val;
     }
     
     else if(ch=='*'){
          val = v1*v2;
         return val;
     }
     
     else if(ch=='-'){
          val = v1-v2;
         return val;
     }
     else if(ch=='/'){
          val = v1/v2;
         return val;
     }
     else {
         return 0;
     }
 }
}