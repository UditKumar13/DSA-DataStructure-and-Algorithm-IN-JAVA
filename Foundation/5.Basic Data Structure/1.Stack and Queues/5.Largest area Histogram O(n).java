import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    
    // how to make rb[] array which stores the indexes which are smaller than present ele i right side 
    // we will use stack 
    Stack <Integer> st = new Stack<>();
    
    st.push(arr.length-1); // last index
    // ye index hai last index + 1
    int [] rb =new int [arr.length];
    rb[arr.length-1] = arr.length ; 
    for (int i=arr.length-2;i>=0;i--){
        while (st.size() > 0 && arr[i] <= arr[st.peek()]){
            st.pop();
        }
        
        if (st.size() == 0){
            rb[i] = arr.length;
        }
        else{
            rb[i] = st.peek();
        }
        st.push(i);
    }
    // for making left array in which indexes will be strored ki left mein kon si index prr current ele se chota milega
    st = new Stack<>();
    int [] lb = new int [arr.length];
    lb[0] = -1;
    st.push(0);  //first index
    for (int i=1;i<arr.length;i++){
        //jab tak apne se more value ka milta rhega pop krte rho humko less value waala chahiye
        while (st.size()>0 && arr[i] <= arr[st.peek()] ){
            st.pop();
        }
        
        if (st.size()==0){
            lb[i] = -1;
        }
        
        else{
            lb[i] = st.peek();
        }
        
        st.push(i);
    }
    

    // largest historam 
    int max_area = 0;
    for (int i=0;i<arr.length;i++){
        int width = rb[i] - lb[i]-1;
        int area  = width * arr[i];
        if (area > max_area){
            max_area = area ;
        }
    }
    
    System.out.println(max_area);
 }
}