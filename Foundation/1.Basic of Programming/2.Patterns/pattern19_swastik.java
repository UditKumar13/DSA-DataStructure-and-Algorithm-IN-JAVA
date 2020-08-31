import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     int n = scn.nextInt();
     for (int i=1;i<=n;i++){
         // first row
         if (i==1){
               for(int j=1;j<=n;j++){
                 if(j==n || j<=(n/2)+1){
                 System.out.print("*\t");
                     
                 }
                 
                 else{
                     
                      System.out.print("\t");
                 }
             }
       }
       
     // uppper half 
     if (i<=n/2 && i>1){
          for(int j=1;j<=n;j++){
                 if(j==n || j==(n/2)+1){
                 System.out.print("*\t");
                     
                 }
                 
                 else{
                     
                      System.out.print("\t");
                 }
         
     }
     }
     //middle 
       if (i==(n/2)+1){
             for(int j=1;j<=n;j++){
                 System.out.print("*\t");
             }
       }
       
       // lower half 
      if (i>(n/2)+1 && i!=n){
          for(int j=1;j<=n;j++){
                 if(j==1 || j==(n/2)+1){
                 System.out.print("*\t");
                     
                 }
                 
                 else{
                     
                      System.out.print("\t");
                 }
         
     }
     } 
       
       //last 
        if (i==n){
             for(int j=1;j<=n;j++){
                 if (j==1 || j>=(n/2)+1){
                 System.out.print("*\t");    
                 }
                 else{
                     System.out.print("\t");
                 }
                 
             }
       }
       
         
         System.out.println();
     }
     
     

 }
}