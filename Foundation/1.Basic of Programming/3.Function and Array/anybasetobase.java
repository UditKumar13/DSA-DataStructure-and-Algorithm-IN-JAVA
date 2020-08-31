import java.util.*;
  
  public class Main{
  
 
     public static int getDecimal(int n, int b){
      int res=0;
      int power=1;
      while(n>0){
          int rem = n%10;
          
          res+=rem*power;
          power=b*power;
          n=n/10;
      }
      return res;
   }
   
    public static int getFinalBase(int n, int b){
       int power=0;
       int res=0;
      while(n>0){
          int rem=n%b;
          res += rem * Math.pow(10,power);
          power++;
          n=n/b;
          
      }
      
      return res;
   }
   
   
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     int deci = getDecimal(n, sourceBase);
     
     int result = getFinalBase(deci,destBase);
     
     System.out.print(result);
   }   
  }