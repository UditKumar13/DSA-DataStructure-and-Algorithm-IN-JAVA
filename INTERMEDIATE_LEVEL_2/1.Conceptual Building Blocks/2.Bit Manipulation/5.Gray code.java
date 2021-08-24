import java.util.*;
 
 public class Main {
     /*
     1. The gray code is a binary numeral system where two successive numbers differ in only one bit.
2. Given a non-negative integer n representing the total number of bits in the code, print the 
     sequence of gray code. A gray code sequence must begin with 0.
 
 Example:
 Input: 2
 Output: [0,1,3,2]
 Explanation:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 [0,2,3,1] is also a valid gray code sequence.
 00 - 0
 10 - 2
 11 - 3
 01 - 1
     */
 
     public static ArrayList<String> grayCode(int n) {
         
         // base case 
         if (n==1){
             ArrayList<String> bres = new ArrayList<>();
             bres.add("0");
             bres.add("1");
             return bres ; 
         }
 	  ArrayList <String> rmes = grayCode(n-1);
 	  ArrayList <String> mres = new  ArrayList<>();
 	  for(int i=0; i<rmes.size();i++){
 	      String rres = rmes.get(i);
 	      mres.add("0" + rres);
 	  }
 	  
 	   for(int i=rmes.size()-1; i>=0 ; i--){
 	       String rres = rmes.get(i);
 	      mres.add("1" + rres);
 	  }
 	  
 	  return mres ; 
     }
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt() ; 
         if (n==0){
             ArrayList<Integer>ans = new ArrayList<>();
             ans.add(0);
             System.out.println(ans);
         }
         else{
          
         ArrayList<String> ans=grayCode(n);
         ArrayList<Integer> gray_output = new ArrayList<>();
         for(String curr : ans){
             int num = Integer.parseInt(curr,2);
             gray_output.add(num);
         }
         Collections.sort(gray_output);
         System.out.println(gray_output);
   
         }     }
 }