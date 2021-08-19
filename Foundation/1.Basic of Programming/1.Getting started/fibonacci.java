import java.util.*;
  
 class Fibonacci{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      // fibonnaci series upto n
      int a =0;
      int b=1;
      for (int i=1;i<=n;i++){
          System.out.println(a);
          int c = a+b;
          a =b;
          b=c;
          
      }
   }
  }