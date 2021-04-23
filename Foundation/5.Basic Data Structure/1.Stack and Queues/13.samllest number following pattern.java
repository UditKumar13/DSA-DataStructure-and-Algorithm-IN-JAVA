import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Stack <Integer> st = new Stack<>();
    int count = 1;
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
        
        if (ch == 'd'){
            // push in the stack 
            st.push(count);
            count++;
        }
        
        else{ // this means ch is 'i'
            st.push (count);
            count++;
            while(st.size()!=0){
                int out = st.pop();
                System.out.print(out + "");
            }
        }
    }
    
    st.push(count);
    while(st.size()!=0){
        int print = st.pop();
        System.out.print(print + "");
        
    }
    
 }
}