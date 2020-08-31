import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n =scn.nextInt();
      // Printing the digits linewise
      int count=0;
      int i=n;
      
      while (i!=0){
         i=i/10;
         count++;
      }
      
      int div = (int)Math.pow(10,count-1);
      // note care fully you can do mistake here if in 
      // second while condition u write n!=0 , cond is on div 
      // see cases like n=100000
      while (div!=0){
          int digit =n/div;
          System.out.println(digit);
          n=n%div;
          div=div/10;
         
          
      }
     }
    }