import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Nice game going on !
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
    }

    public static void pzz(int n){
    if(n==0){
        return;
    }
    //pre 
    System.out.print(n + " ");
    pzz(n-1);  // left call
    //in
    System.out.print(n + " ");
    pzz(n-1);  //Right call
    //post 
    System.out.print(n + " ");
    }

}