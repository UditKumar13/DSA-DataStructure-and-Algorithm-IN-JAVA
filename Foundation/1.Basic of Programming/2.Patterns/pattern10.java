import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     int n = scn.nextInt();
     int os = n/2;
     int isp = -1;
     
     for (int i=1; i<=n;i++){
         
             
           // System.out.println(os + " , " + isp);
           
          for (int j=1;j<=os;j++){
              System.out.print("\t");
          }
           
          System.out.print("*\t");
           
        for (int j=1;j<=isp;j++){
              System.out.print("\t");
          }
           
          if (i>1 && i< n){
             System.out.print("*\t");
          }
      
           
          for (int j=1;j<=os;j++){
              System.out.print("\t");
          }
           
           
             
             if(i<=n/2){
                 os--;
                 isp=isp+2;
             }
             
             else{
                 os++;
                 isp=isp-2;
             }
     System.out.println();    
     }
     
 }
}