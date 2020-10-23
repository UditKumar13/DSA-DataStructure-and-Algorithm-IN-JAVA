import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        
        Scanner scn = new Scanner (System.in);
        // rows and cols 
        int n= scn.nextInt();
        int m= scn.nextInt();
        
        ArrayList <String> ans = getMazePaths(1,1,n,m);
        
        System.out.println(ans);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // base cases
        if (sr==dr && sc==dc){
            // if you have reached the end point in maze
            ArrayList <String>bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        ArrayList<String> path_h = new ArrayList<>();
        ArrayList<String> path_v = new ArrayList<>();
        
        if (sr<dr){
            //2,3 -> 3,3 sr,sc ->dr,dc
            //so vertical move is possible incrementing a x index
            
            path_v= getMazePaths(sr+1,sc,dr,dc);
        }
        
        if(sc<dc){
             path_h = getMazePaths(sr,sc+1,dr,dc);
        }
        

        
        // introducing the new ArrayList
        ArrayList<String> paths = new ArrayList<>();
        for (String path : path_h){
            paths.add("h"+path);
        }
        for (String path : path_v){
            paths.add("v"+path);
        }
        
        return paths;
        
    }
    }

