import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // Prefix evaluation and conversion
    // is infix , pos , post fix
    Stack <Integer> vs  = new Stack<>();
    Stack <String> is  = new Stack<>();
    Stack <String> pos  = new Stack<>();
    
    // loop will start from right to left in case of prefix 
    for (int i=exp.length()-1;i>=0;i--){
        
        char ch = exp.charAt(i);
        
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/'  ){
            // evaluate the value 
            int v1 = vs.pop();
            int v2  = vs.pop();
            int vf = operation(v1,v2,ch);
            
            vs.push(vf);
            
            // infix exp
            
            String is1  = is.pop();
            String is2  = is.pop();
            String isf = "(" + is1 + ch + is2 + ")";
            
            
            is.push(isf);
            
            // post expression
            
            String pos1  = pos.pop();
            String pos2  = pos.pop();
            String posf =  pos1 + pos2 + ch ;
            
            
            pos.push(posf);
            
            
            
            
            
        }
        
        else{
            // operand comes 
         vs.push(ch-'0');
         is.push(ch + "");
         pos.push(ch + "");
            
        }
    }
    
    System.out.println(vs.pop());
    System.out.println(is.pop());
    System.out.println(pos.pop());
    

 }
 
 
 public static int operation (int v1 ,int v2 ,char ch ){
     if (ch == '+'){
         return v1+v2;
     }
     
     else if (ch== '-'){
         return v1-v2;
     }
     else if (ch== '*'){
         return v1*v2;
     }
     
     else if (ch=='/'){
         return v1/v2;
     }
     
     else{
         return 0;
     }
     
     
 }
}