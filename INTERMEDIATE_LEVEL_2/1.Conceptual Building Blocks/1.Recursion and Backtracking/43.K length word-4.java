import java.io.*;
import java.util.*;

public class Main {

 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    HashMap <Character,Integer> fmap = new HashMap<>();
    String ustr = "" ;
    for(int i =0;i<str.length();i++){
        char ch = str.charAt(i);
        
        if (fmap.containsKey(ch) == true ){
            int of  = fmap.get(ch);
            fmap.put(ch,of+1);
        }
        
        else{
            fmap.put(ch,1);
            ustr += ch ; 
        }
    }
    
    // till now we have a hashmap that can store the number of occurence with their respective character
    fun(fmap,ustr,1,k,"");
  
  }
  
  public static void fun(HashMap <Character, Integer> fmap, String ustr, int cs, int ts,String asf){
      
      if(cs == ts + 1){
          
          System.out.println(asf); 
          return  ;
      }
      
      for (int i=0;i<ustr.length();i++){
        char ch = ustr.charAt(i) ; // a
        if(fmap.get(ch) > 0){
            fmap.put(ch,fmap.get(ch) -1);
            fun(fmap,ustr,cs+1,ts,asf+ch);
            fmap.put(ch,fmap.get(ch) +1);
        }
      }
  }

}