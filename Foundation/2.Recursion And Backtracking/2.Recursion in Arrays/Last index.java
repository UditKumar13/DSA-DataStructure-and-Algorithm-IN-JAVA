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
        
        int x = scn.nextInt();
        int ans = lastIndex(arr,arr.length-1,x);
        System.out.println(ans);
    }

    public static int lastIndex(int[] arr, int idx, int x){
     //initially idx is at last index before pushing and after poping also it 
     //will return to last index
        if (idx==-1){
            return -1;
        }
    // we have to first go to 0 th index and then update till the last index
    
            int fi = lastIndex(arr,idx-1,x);
            if(arr[idx]==x){
                return idx;
            }
            else{
                return fi;
            }
        
    }

}