import java.io.*;
import java.util.*;

public class Main {

  public static void fun(String str,HashMap <Character,Integer> fmap, int idx,String asf, int k  ){
      
      if(k<0){
          return ;
      }
      
      if (idx == str.length()){
          if(k==0){
              System.out.println(asf);
          }
          
          return ; 
      }
    char ch = str.charAt(idx);
    if (fmap.get(ch) > 0 ){
        fmap.put(ch,fmap.get(ch)-1);
        fun(str,fmap,idx,asf+ch,k-1);
        fmap.put(ch,fmap.get(ch)+1);
    }
    // when the character is not being selected
    fun(str,fmap,idx+1,asf,k);
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }
    
    fun(ustr, unique,0,"",k);
    
  }

}