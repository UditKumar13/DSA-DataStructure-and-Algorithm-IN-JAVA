import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
       //nice game going on 
      
    int res=0;
    int borrow=0 ;
    
    int p=1;
    
    while(n2>0){
        int d2=n2%10;
        
         n2=n2/10;
         
        int d1=n1%10;
        n1=n1/10;
        
        int d = 0;
        d2 = d2 + borrow;
        
        
        if (n2>=n1){
            borrow=0;
             d = d2-d1;
            
            
        }
        
        else{
            borrow=-1;
            // adding the base for the subtraction 
            d=d2+b-d1;
        }
        
        res = res + (d*p);
        p=p*10;
        
    }
    return res;
   }
  }
  