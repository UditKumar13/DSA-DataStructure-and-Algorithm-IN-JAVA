import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Nice game going on !
        Scanner scn = new Scanner (System.in);
        
        int n = scn.nextInt();
        int [] arr = new int [n];
        
        for (int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        // element to find 
        int x = scn.nextInt();
        int ans = firstIndex(arr,0,x);
        
        System.out.println(ans);
    }

    public static int firstIndex(int[] arr, int idx, int x){
        
        if (idx == arr.length){
            return -1;
        }
        // don't push first first compare if got matched then no need to push 
        //start poping 
       //  int fi = firstIndex(arr,idx+1,x);
        if (arr[idx] == x){
            return idx;
        }
        else{
            int fi = firstIndex(arr,idx+1,x);
            return fi;
        }
        
    }

}