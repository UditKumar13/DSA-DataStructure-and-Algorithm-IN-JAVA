import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int m =scn.nextInt();
        // rows and cols 
        
        printMazePaths(1,1,n,m,"");

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String taara) {
        //Base Case 
        
        if(sr>dr || sc>dc){
            return;
        }
        
        if(sr==dr && sc==dc){
            System.out.println(taara);
            return;
        }
        
        // horizontal moves
        for (int ms=1; ms<=dc-sc;ms++){
            printMazePaths(sr,sc+ms,dr,dc,taara+"h"+ms);
        }
        // for vertical moves 
          for (int ms=1; ms<=dr-sr;ms++){
            printMazePaths(sr+ms,sc,dr,dc,taara+"v"+ms);
        }
        // for diagonal moves
         for (int ms=1; ms<=dc-sc && ms<=dr-sr;ms++){
            printMazePaths(sr+ms,sc+ms,dr,dc,taara+"d"+ms);
        }
        
        
    }

}