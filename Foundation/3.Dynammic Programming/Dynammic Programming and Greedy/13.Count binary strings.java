import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // Count Binary String of length n where no consecutive zeroes 
    
    Scanner scn = new Scanner (System.in);
    
    
    int n = scn.nextInt();
    // no.of string of length 1 ends with 0 
    int nzero = 1;
    // no.of string of length 1 ends with 1 
    int nones = 1;
    
    for(int len=2;len<=n;len++){
        int temp_zero  = nzero;
        nzero = nones;
        nones = nones + temp_zero ;
        
        
    }
    
    System.out.println(nzero  + nones);
 }

}