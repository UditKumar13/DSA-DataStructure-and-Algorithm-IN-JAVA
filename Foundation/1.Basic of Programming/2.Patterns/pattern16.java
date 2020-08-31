import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     int n = scn.nextInt();
     
     int star=1;
     int sp = 2*n-3;
     for(int i=1;i<=n;i++){
         int val=1;
       // System.out.print(star + " , " + sp);
        for (int j=1;j<=star;j++){
            System.out.print(val+"\t");
            val++;
        }
        for (int j=1;j<=sp;j++){
            System.out.print("\t");
        }
    
       //special case if(i==n){
            star--;
            val--;
        }
         val--;
        for (int j=1;j<=star;j++){
            System.out.print(val+"\t");
            val--;
        }
        
        
        
            star++;
            sp-=2;
            
            
        
        
        System.out.println();
     }

 }
}