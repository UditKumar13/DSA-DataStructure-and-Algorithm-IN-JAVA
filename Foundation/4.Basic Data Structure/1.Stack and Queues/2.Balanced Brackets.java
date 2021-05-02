import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn =  new Scanner (System.in);
        
        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        
        for (int i = 0 ;i<str.length();i++){
            char ch  = str.charAt(i);
             if ((ch == ')' || ch== ']' || ch=='}') && (st.size()==0)  ){
                System.out.println("false");
                return;
            }
            
            else if (ch ==')' ){
                if (st.peek() == '('){
                    st.pop();
                }
                
                
                else{
                    System.out.println("false");
                    return;
                }
            }
            
            else if (ch ==']'){
                if (st.peek() == '['){
                    st.pop();
                }
                
                else{
                    System.out.println("false");
                    return ;
                }
            }
            
            else if (ch == '}'){
                if (st.peek() == '{'){
                    st.pop();
                }
                else{
                    System.out.println("false");
                    return;
                }
            }
            
            else if ((ch == ')' || ch== ']' || ch=='}') && (st.size()==0)  ){
                System.out.println("false");
                return;
            }
            
            else{
                if (ch == '(' || ch== '[' || ch=='{'){
                    st.push(ch);
                
                }
            }
            
            
        }
    
        
        if (st.size() == 0 ){
        System.out.println("true");
        }
        
        else{
            System.out.println("false");
        }

        
      
        }
          
        
      
    

}