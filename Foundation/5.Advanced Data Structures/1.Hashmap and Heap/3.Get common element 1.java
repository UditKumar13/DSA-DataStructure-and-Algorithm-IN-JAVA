import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    
  Scanner scn = new Scanner (System.in);
   int idx1 = scn.nextInt();
  
   int [] arr1 = new int [idx1];
   
     for (int i=0;i<arr1.length;i++){
       arr1[i] = scn.nextInt();
   }
   
  int idx2 = scn.nextInt();
  int [] arr2 = new int [idx2];
  for (int i=0;i<arr2.length;i++){
       arr2[i] = scn.nextInt();
   } 
 
    
    HashMap <Integer, Integer> hm = new HashMap<>();
    
    
// first make a hashmap with integers of s1 and its respected frequency count 
  for (int i=0;i<arr1.length;i++){
      int num = arr1[i]; 
      if (hm.containsKey(num)){
          int of = hm.get(num);
          int nf = of + 1;
          hm.put(num,nf);
      }
      
      else{
          hm.put(num,1);
      }
  }
  
  // now check the char from the array2 and use hash map property
  for (int i=0;i<arr2.length;i++){
      int numb = arr2[i];
      
      if (hm.containsKey(numb))
      {
          // that means first arr1 contains this integer
          // first print it  
          System.out.println(numb);
          // then remove from the hashmap
          hm.remove(numb);
          
      }
  }
    
    
 }

}