import java.io.*;
import java.util.*;

public class Main {

 public static void   generateWords(int cc, String ustr,int ssf, int ts,  Character [] spots){
     
     if(cc == ustr.length()){
         if(ssf == ts){
             for(int star=0;star<spots.length;star++){
                 System.out.print(spots[star]);
             }
             
             System.out.println();
           
         }
           return ; 
     }
     
     char ch = ustr.charAt(cc);
     for(int a=0;a<spots.length;a++){
         if(spots[a] == null){
             spots[a]= ch;
             generateWords(cc+1,ustr,ssf+1,ts,spots);
             spots[a]=null ;
             
         }
     }
     
     generateWords(cc+1,ustr,ssf+0,ts,spots);
 }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    
    Character [] spots = new Character[k] ;
    generateWords(0,ustr,0,k,spots);

    
  }

}