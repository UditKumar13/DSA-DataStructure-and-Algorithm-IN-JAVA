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
    int k = Integer.parseInt(br.readLine());

    // make the right max logic 
    Stack <Integer> st = new Stack <>();
    st.push (arr.length-1);
    // to get the right maximum of each element 
    int [] rm = new int [arr.length];
    rm [arr.length-1] =  arr.length; // bahar hai last element ka right max
    for (int i=arr.length-2 ; i>=0 ;i--){
        
        while (st.size()>0 && arr[i] >=arr[st.peek()]){
            st.pop();
        }
        
        if (st.size()==0){
            rm[i] = arr.length; // array se bahar matlab koi right max nhi hai 
        }
        
        else{
            rm[i] = st.peek();
        } 
        
        st.push(i);
        
    }
    int j=0;
    for (int i=0;i<=arr.length-k;i++){
        if (j<i){
            j=i;
        }
        // jab tak max right window ke ander hi hai 
        while (rm[j]<i+k){
            j = rm[j];  //shifting checking index to ander waala max next right 
        }
        
        System.out.println(arr[j]);
    }
    
    
    
 }
}