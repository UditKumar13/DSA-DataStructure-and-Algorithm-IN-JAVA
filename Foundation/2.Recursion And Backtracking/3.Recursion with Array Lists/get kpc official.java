import java.io.*;
import java.util.*;

public class Main {

//input : 678
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        String str = scn.next();
        ArrayList <String> words = getKPC(str);
        System.out.println(words);
    }
    
    static String[] codes ={".;","abc","def","ghi","jkl","mno","pqrs","tu",
    "vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        
        // base case 
        if (str.length()==0){
            ArrayList <String> bres = new ArrayList<>();
            bres.add("");//[""]
            return bres;
        }
        char ch = str.charAt(0);//'6' 
        String ros = str.substring(1);//78
        ArrayList<String> res = getKPC(ros); //faith 6 words 
        ArrayList<String> mres = new ArrayList<>();// expectation require 24 words
       
       String codeforch = codes[ch-'0'];// because codes[6] '6'-'0'=6
       for (int i=0;i<codeforch.length();i++){
           char prch = codeforch.charAt(i);//p
           for (String val: res){
               mres.add(prch+val);
           }
       }
       
        return mres;
        
    }

}