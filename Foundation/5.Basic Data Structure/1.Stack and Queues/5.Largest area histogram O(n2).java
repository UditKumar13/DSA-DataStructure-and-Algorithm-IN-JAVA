import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    // largest historam 
    // br stands for breadth
    int max_area = 0;
    for (int wid=1;wid<=n;wid++){
        int len =0 ;
        int area = 0 ;
        int hit =0 ;
        for (int i=0;i<n;i++){
            if (a[i] >=wid){
                len++;
            }
            else{ 
                area = wid*len ;
            len=0;
            hit++;
                
            }
            if (max_area <area ){
            max_area = area ;
            }
        }
        if (hit ==0){
            max_area = len * wid;
        }
        
        
    }
    
    System.out.println(max_area);
 }
}