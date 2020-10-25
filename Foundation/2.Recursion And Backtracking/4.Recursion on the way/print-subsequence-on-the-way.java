import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String que = scn.next();
        printSS(que,"");
        //que : abc 

    }

    public static void printSS(String que, String ans ) {
        
        // base case 
        if (que.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = que.charAt(0);//a
        String roq = que.substring(1);//bc
        printSS(roq,ans+ch); // all yes calls 
        printSS(roq,ans+"");// all no calls
    }

}