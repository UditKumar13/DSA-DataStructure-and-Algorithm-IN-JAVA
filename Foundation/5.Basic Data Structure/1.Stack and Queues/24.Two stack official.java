import java.io.*;
import java.util.*;

public class Main {

  public static class TwoStack {
    int[] data;
     Stack<Integer> tos1 = new Stack<>();
     Stack<Integer> tos2 = new Stack<>();

    public TwoStack(int cap) {
      // write your code here
      data = new int [cap] ; 
    
    }

    int size1() {
      // write your code here
      return tos1.size();
    }

    int size2() {
      // write your code here
      return tos2.size();
    }

    void push1(int val) {
      // write your code here
      if ((tos1.size() + tos2.size() ) == data.length){
          System.out.println("Stack overflow");
          return ;
      }
      
      else{
          tos1.push(val);
      }
    }

    void push2(int val) {
      // write your code here
      if ((tos1.size() + tos2.size() ) == data.length){
          System.out.println("Stack overflow");
          return ;
      }
      
      else{
          tos2.push(val);
      }
    }

    int pop1() {
      // write your code here
      if (tos1.size()==0){
          System.out.println("Stack underflow");
          return -1;
      }
      
      else{
          return tos1.pop();
      }
    }

    int pop2() {
      // write your code here
      if (tos2.size()==0){
          System.out.println("Stack underflow");
          return -1;
      }
      
      else{
          return tos2.pop();
      }
    }

    int top1() {
      // write your code here
      if (tos1.size()==0){
          System.out.println("Stack underflow");
          return -1;
      }
      
      else{
          return tos1.peek();
      }
    }

    int top2() {
      // write your code here
      if (tos2.size()==0){
          System.out.println("Stack underflow");
          return -1;
      }
      
      else{
          return tos2.peek();
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    TwoStack st = new TwoStack(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push1")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push1(val);
      } else if (str.startsWith("pop1")) {
        int val = st.pop1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top1")) {
        int val = st.top1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size1")) {
        System.out.println(st.size1());
      } else if (str.startsWith("push2")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push2(val);
      } else if (str.startsWith("pop2")) {
        int val = st.pop2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top2")) {
        int val = st.top2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size2")) {
        System.out.println(st.size2());
      }
      str = br.readLine();
    }
  }
}