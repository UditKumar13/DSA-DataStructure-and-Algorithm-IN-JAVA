import java.io.*;
import java.util.*;

public class Main {

 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    
    HashMap<Character, Integer> fmap = new HashMap<>();
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
        fmap.put(ch,-1);
    }
    
    // calling
    fun(fmap,str,0,new Character [k] ,0,k) ; 
  }
  
  public static void fun(HashMap <Character, Integer> fmap, String str, int idx, Character [] spots,int  ssf, int ts){
      if(idx == str.length()){
          if(ssf == ts){
              for(int star=0; star<spots.length;star++){
                  System.out.print(spots[star]);
              }
              
              System.out.println();
          }
          return ; 
      }
      
      char ch = str.charAt(idx);
      int lc = fmap.get(ch); // Last count 
      for(int i=lc+1;i<spots.length;i++){
          if (spots[i] == null){
              spots[i] = ch ;
              fmap.put(ch,i);
              fun(fmap,str, idx+1,spots,ssf+1,ts); // recursion call 
              fmap.put(ch,lc);
              spots[i] = null;
          }
      }
      
      // suppose if the character doesn't want to come then there should be the case when the character is placed at
      if(lc == -1){
          fun(fmap, str, idx+1, spots,ssf,ts);
      }
  }

}