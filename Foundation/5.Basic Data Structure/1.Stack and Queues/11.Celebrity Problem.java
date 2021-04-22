import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        
        Stack <Integer> st = new Stack<>();
        // pushing all indexes in the stack 
        for (int i=0;i<arr.length;i++){
            st.push(i);
        }
        
        while (st.size()>=2){
            int i=st.pop() ; //2
            int j=st.pop() ; //3
            if (arr[i][j] == 1){
                // this means i knows j so i can't be the celebrity 
                st.push (j);
            }
            
            else{
                // arr[i][j] == 0 , this means i don't know j 
                // j can't be the celebrity 
                st.push(i);
            }
            
            
        }
        // now only 1 element remains 
        // know check for the whole row and whole column 
    
        int one_ele = st.pop();
        for (int i=0 ; i<arr.length;i++){
            // nice tecnique bcz we have to see only those ele in one_ele 's row and col '
            if (i != one_ele){
                if (arr[i][one_ele] == 0|| arr[one_ele][i] ==1){
                    System.out.println("none");
                    return ;
                }
            }
        }
        System.out.println(one_ele);
    }

}