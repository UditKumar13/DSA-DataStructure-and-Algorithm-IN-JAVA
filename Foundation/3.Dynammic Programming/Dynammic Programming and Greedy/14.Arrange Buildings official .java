import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // Arrays Building 
    
    Scanner scn  = new Scanner (System.in);
    
    long n  = scn.nextInt();
    // for n=1 , same as 0 in count binary strings 
    long buildings = 1 ;
    // for n=1 
    long space = 1;
    
    for (int len = 2;len <=n ; len++){
        long temp_building = buildings; // 5
        
        buildings = space; // 8
        space = space + temp_building ; // 8+5
    }
    long ans1side = space + buildings;
    ans1side = ans1side * ans1side;
    // now this  building sequence is on the both sides of roads , and independent event 
    //answer will be 
    System.out.println(ans1side);
 }

}