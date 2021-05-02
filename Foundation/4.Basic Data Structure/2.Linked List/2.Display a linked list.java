import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    public int size(){
        int count = 0;
        Node temp = new Node();
        temp = head ;
        if (temp == null)
        return 0 ;
        
      while(temp.next  != null ){
          temp = temp.next ; 
          count++;
      }
      count++;
      return count;
      
    }

    public void display(){
        Node temp = new Node();
        temp = head ; 
      if (temp == null){
          System.out.println();
          return;
      }
      else{
          while(temp!=null){
              System.out.print(temp.data + " ");
              temp = temp.next ;
              
          }
          
          
          System.out.println();
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("addLast")){
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      } else if(str.startsWith("size")){
        System.out.println(list.size());
      } else if(str.startsWith("display")){
        list.display();
      }
      str = br.readLine();
    }
  }
}