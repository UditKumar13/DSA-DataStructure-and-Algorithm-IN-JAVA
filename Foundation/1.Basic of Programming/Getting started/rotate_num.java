import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       int num = scn.nextInt();
       int k = scn.nextInt();
       int i=num;
       int tot_digits=0;
       // calculating total digits 
       while(i!=0){
           i=i/10;
           tot_digits++;
       }
       // special cases 
     // case 1 for k>n
     k = k % tot_digits;
     // case 2 for k being negative 
     if (k<0){
         k = k + tot_digits;
     }
       int div=1;
       int mul=1;
      // making the divisor and multiplier
      for (i=1;i<=tot_digits;i++){
          if (i<=k){
              div=div*10;
          }
          
          else{
              mul=mul*10;
          }
      }
     
     int rem = num % div;
     int q = num/div;
     //logic
     int rotated_num= rem * mul + q; 
     
     System.out.print(rotated_num);
    }
   }