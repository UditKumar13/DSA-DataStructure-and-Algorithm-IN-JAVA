import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
	        Scanner scn = new Scanner (System.in);
	        int n =scn.nextInt();
	        int m = scn.nextInt();
	        // rows and cols
	        printMazePaths(1,1,n,m,"");
	    
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static void printMazePaths(int sr, int sc, int dr, int dc, String taara) {
	       
	       // base case 
	       // noraml calls(some calls are abt to exit from the maze) ,smart base cases
	       if (sr>dr || sc>dc){
	           return;
	       }
	       if (sr==dr && sc==dc){
	           System.out.println(taara);
	           return;
	       }
	       if(sc<dc)
	       printMazePaths(sr,sc+1,dr,dc,taara+"h");
	       if(sr<dr)
	       printMazePaths(sr+1,sc,dr,dc,taara+"v");
	    
	 
	       
	       
	       
	    }

	}