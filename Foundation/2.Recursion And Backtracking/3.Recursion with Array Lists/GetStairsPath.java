import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        
        ArrayList<String>ans = getStairPaths(n);
        System.out.println(ans);

    }

    public static ArrayList<String> getStairPaths(int n) {
        // required result
        if (n==0){
            ArrayList<String>bres = new ArrayList<>();
            bres.add("");
            return bres;
            
        }
        //negative cases
        if (n<0){
            ArrayList<String>bres = new ArrayList<>();
            return bres;
            
        }
        ArrayList<String> path1 = getStairPaths(n-1);
        ArrayList<String> path2 = getStairPaths(n-2);
        ArrayList<String> path3 = getStairPaths(n-3);
        // post order submit in new arraylist after every 3 child calls 
        
        ArrayList<String> paths = new ArrayList<>();
        
        for(String raste : path1){
            paths.add(1+raste);
        }
        for(String raste : path2){
            paths.add(2+raste);
        }
        for(String raste : path3){
            paths.add(3+raste);
        }
        
        return paths;
        
        
    }

}