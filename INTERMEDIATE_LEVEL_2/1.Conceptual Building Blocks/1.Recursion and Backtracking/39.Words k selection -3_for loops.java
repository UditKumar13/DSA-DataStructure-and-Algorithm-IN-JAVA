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
    
    for(int i =fmap.get(ch); i>=0;i--){
        
        String uk = "";
        for (int j=0; j<i;j++){
            uk+=ch;
        }// for making the strings aaa,aa,a,""
        
        // calling recursively 
        fun(str,fmap,idx+1,asf+uk,k-i);
        
    }
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