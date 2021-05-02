import java.io.*;
import java.util.*;

public class Main {

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      // write your code here
      return mainS.size();
    }

    void add(int val) {
      // write your code here
      // 0(1) 
      mainS.push(val);
    }

    int remove() {
       // we have to use 2 stacks for this
       if (mainS.size()==0){
          System.out.println("Queue underflow");
          return -1;
      }
      // more than 2 elements 
      while (mainS.size()>1){
          helperS.push(mainS.pop());
      }
      
     int ans  = mainS.pop();
     
     while (helperS.size()>0){
         mainS.push(helperS.pop());
     }
    return ans;
    }

    int peek() {
      if (mainS.size()==0){
          System.out.println("Queue underflow");
          return -1;
      }
      // we have to use 2 stacks for this 
      // more than 2 elements 
      while (mainS.size()>1){
          helperS.push(mainS.pop());
      }
      
     int ans  = mainS.pop();
     helperS.push(ans);
     while (helperS.size()>0){
         mainS.push(helperS.pop());
     }
     return ans;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StackToQueueAdapter qu = new StackToQueueAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}