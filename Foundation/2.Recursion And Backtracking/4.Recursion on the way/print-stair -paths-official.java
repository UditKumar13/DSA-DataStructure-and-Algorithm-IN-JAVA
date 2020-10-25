import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int taara = scn.nextInt();
        
        printStairPaths(taara,"");

    }

    public static void printStairPaths(int n, String path) {
        //base case
        if (n==0){
            System.out.println(path);
            return;
        }
        else if(n<0){
            return;
        }
        
        printStairPaths(n-1,path+1);
        printStairPaths(n-2,path+2);
        printStairPaths(n-3,path+3);
        
        
    }

}