import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner (System.in);
        // rows , cols
        int n = scn.nextInt();
        int m = scn.nextInt();
        // calling function 
        ArrayList<String> taara = getMazePaths(1,1,n,m);
        System.out.println(taara);
        

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        // base case 
        if(sr==dr && sc==dc){
            ArrayList<String>bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> paths = new ArrayList<>();
        // horizontal moves for condition , consider y coordinate bcz that get affected in 
        //moving horizontally , ms is move size 
        for (int ms=1; ms<= dc-sc;ms++){
            // recurion will give me all paths like h1v2d3 when ms=1 , when ms=4 , h4v3d3
            ArrayList<String>h_paths = getMazePaths(sr,sc+ms,dr,dc);
            for (String h_path : h_paths){
                paths.add("h" + ms + h_path);
            }
        }
        
        //moving vertically ,for condition , consider x coordinate,  ms is move size 
        for (int ms=1; ms<= dr-sr;ms++){
          
            ArrayList<String>v_paths = getMazePaths(sr+ms,sc,dr,dc);
            for (String v_path : v_paths){
                paths.add("v" + ms + v_path);
            }
        }
        
        //moving diagonally ,for condition , consider both x,y  coordinate,  ms is move size 
        for (int ms=1; ms<= dr-sr && ms<=dc-sc;ms++){
          //  ms =1  (1,1) to (2,2) both change with same move size 
            ArrayList<String>d_paths = getMazePaths(sr+ms,sc+ms,dr,dc);
            for (String d_path : d_paths){
                paths.add("d" + ms + d_path);
            }
        }
        
        return paths;
        
    }

}