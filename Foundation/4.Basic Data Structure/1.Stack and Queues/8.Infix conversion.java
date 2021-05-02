import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // infix conversion to prefix and postfix 
    
    Stack <String> pre= new Stack<>();
    Stack <String> post= new Stack<>();
    Stack <Character> ops= new Stack<>();
    
    for (int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);
        
        if (ch == '('){
            ops.push(ch);
        }
        // character is eiher in number or in alphabet 
        else if((ch >='0' && ch<='9') || (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
            // ch + " " for making character to string 
             pre.push(ch + "");
            post.push(ch + "");
        }
        
        else if(ch==')'){
            while ( ops.peek()!= '(') {
                char op = ops.pop();
                
                String pre_v2 = pre.pop();
                String pre_v1 = pre.pop();
                
                String pre_val = op + pre_v1 + pre_v2;
                pre.push(pre_val);
                
                String post_v2 = post.pop();
                String post_v1 = post.pop();
                
                String post_val =  post_v1 + post_v2 + op;
                post.push(post_val);
                
            }
            
            ops.pop();
        }
        
        else if (ch == '-' || ch == '+' || ch == '*' || ch == '/' ){
            while (ops.size()>0 && ops.peek()!= '(' && precedence(ch)<=precedence(ops.peek())){
                char op = ops.pop();
                
                String pre_v2 = pre.pop();
                String pre_v1 = pre.pop();
                
                String pre_val = op + pre_v1 + pre_v2;
                pre.push(pre_val);
                
                String post_v2 = post.pop();
                String post_v1 = post.pop();
                
                String post_val =  post_v1 + post_v2 + op;
                post.push(post_val);
                
            }
            ops.push(ch);
        }
    }
        
            while ( ops.size()>0) {
                char op = ops.pop();
                
                String pre_v2 = pre.pop();
                String pre_v1 = pre.pop();
                
                String pre_val = op + pre_v1 + pre_v2;
                pre.push(pre_val);
                
                String post_v2 = post.pop();
                String post_v1 = post.pop();
                
                String post_val =  post_v1 + post_v2 + op;
                post.push(post_val);
                
            
        }
        
        System.out.println(post.peek());
        System.out.println(pre.peek());
        
    }
    
    public static int precedence(char optor){
        if (optor == '+'){
            return 1;
        }
           else if (optor == '-'){
            return 1;
        }
        else if (optor == '*'){
            return 2;
            
        }
        // for division
        else if (optor =='/') {
            return 2;
        }
        else{
            return 0;
        }
    }
    

 
}