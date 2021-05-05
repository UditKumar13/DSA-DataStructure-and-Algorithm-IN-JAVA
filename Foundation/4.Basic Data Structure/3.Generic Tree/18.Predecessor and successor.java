import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  static Node pred; // predecessor 
  static Node sucess; // successor
  static int state ; // initial state = 0;
  public static void predecessorAndSuccessor(Node node, int data) {
    // logic to decide pred and sucess
    if (state ==0){
        if (node.data == data){
            // got the data indicate state should change
            state  = 1;
        }
        
        else{
            // just change the predecessor 
            pred = node;
        }
    }
    
    else if(state == 1){
        // this means we have crossed the data , this new node is the successor
        sucess = node;
        state = 2;
        
    }
    
    for (Node child : node.children){
        predecessorAndSuccessor(child , data);
    }
    
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    pred = null;
    sucess = null;
    predecessorAndSuccessor(root, data);
    if(pred == null){
      System.out.println("Predecessor = Not found");
    } else {
      System.out.println("Predecessor = " + pred.data);
    }

    if(sucess == null){
      System.out.println("Successor = Not found");
    } else {
      System.out.println("Successor = " + sucess.data);
    }
  }

}