import java.io.*;
import java.util.*;

public class Main {
    // input : abc
    // output: [, c, b, bc, a, ac, ab, abc]

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList <String> res = gss(str);
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str) {
        // Base case
        // 2^0 =1 
        // blank ka subsequence right[""]  wrong[]
        
        if (str.length()==0){
            ArrayList <String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0) ;  //a
        String ros = str.substring(1);//bc
        //recursion
        ArrayList <String> rres = gss(ros);// faith [--,-c,b-,bc]
        
        ArrayList<String> mres = new ArrayList<>();
        //logic to add 
        for(String rstr : rres){
            mres.add("" + rstr);
        }
        
        for(String rstr : rres){
            mres.add(ch + rstr);
        }
        return mres;
        
        
        
        
    }

}