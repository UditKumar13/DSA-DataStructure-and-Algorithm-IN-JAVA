/*

1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
2. An employee directly reports to only one manager. 
3. All managers are employees but the reverse is not true.
4. An employee reporting to himself is the CEO of the company.
5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.

Input :
6
A C
B C
C F
D E
E F
F F

Output :

A 0
B 0
C 2
D 0
E 1
F 5
*/

import java.io.*;
import java.util.*;

public class Main {
 
  
  private static void findCount(HashMap<String,String> map){
    HashMap <String , HashSet<String>> tree = new HashMap<>() ; 
    
    String ceo = "" ;
    
    for (String emp: map.keySet()){
      String man = map.get(emp) ; // manager
      
      if(man.equals(emp)){
        ceo = man  ; 
      }
      
      else {
        if (tree.containsKey(man)){
          // already there is key called manager
          HashSet<String> emps = tree.get(man);
          emps.add(emp) ; 
        }
        
        else {
          // new entry 
          
          HashSet<String> emps = new HashSet<>(); 
          
          emps.add(emp) ;
          tree.put(man,emps);
        }
      }
    }
    
    HashMap <String,Integer> result = new HashMap<>() ; 
    
    getSize(tree,ceo,result) ; 
    
    
    for (String emp : result.keySet()){
      System.out.println(emp + " " + result.get(emp) ) ; 
    }
    
    
    
  }
  
  public static int getSize(HashMap<String, HashSet<String>> tree , String man , HashMap<String, Integer> result){
    
    if (tree.containsKey(man) == false){
      result.put(man,0) ;
      return 1 ; 
    }
    
    // base case 
    
    int sz =0  ; // size 
    
    for (String emp : tree.get(man)){
      int cs = getSize(tree,emp,result);
      sz+= cs ; 
    }
    
    result.put(man,sz) ;
    return sz + 1 ; 
  }
  
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    HashMap<String, String> map =  new HashMap<>(); 
    
    for (int i=0; i<n ; i++){
      map.put(scn.next(), scn.next()) ; 
      
    }
    
    findCount(map); 
  }

}