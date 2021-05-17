import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
  public static class BSTPair {
      boolean isBST ;
      int min;
      int max;
      Node root ; // largest bst's root
      int size;  // largest bst's size
      
  }
  
  public static BSTPair isBST (Node node) {
      
      //base case 
      
      if (node == null){
          BSTPair bp = new BSTPair ();
          bp.isBST = true;
          bp.min = Integer.MAX_VALUE;
          bp.max = Integer.MIN_VALUE;
          bp.root = null;
          bp.size=0;
          return bp;
      }
      
      BSTPair lbst = isBST (node.left);
      BSTPair rbst= isBST(node.right);
      
      BSTPair mb = new BSTPair ();
      
      mb.isBST = (lbst.isBST  && rbst.isBST && node.data >= lbst.max && node.data <= rbst.min);
      
      mb.min = Math.min(node.data , Math.min(lbst.min,rbst.min));
      
      mb.max = Math.max(node.data, Math.max(lbst.max,rbst.max));
      
      if (mb.isBST){
          
          mb.root = node;
          mb.size = lbst.size + rbst.size + 1;
          
          
      }
      
      else if (lbst.size > rbst.size){
          mb.root = lbst.root ;
          mb.size = lbst.size;
      }
      
      else{
             mb.root = rbst.root ;
          mb.size = rbst.size;
      }
      
      return mb ; 
      
      
      
  }

  
  
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    BSTPair uk = isBST(root);
    System.out.println(uk.root.data+ "@" + uk.size );
    
    // write your code here
  }

}