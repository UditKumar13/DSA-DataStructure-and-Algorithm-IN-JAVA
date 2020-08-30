import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int sp=n/2;
        int star=1;
        for ( int i=1;i<=n;i++){
           // System.out.print(sp + " , " + star);
             if (i!= (n/2)+1){
           for(int j=1;j<=sp;j++){
                 System.out.print("\t");
           }
         
            for(int j=1;j<=star;j++){
                 System.out.print("*\t");
           }
           
             }
           //special case for mid row all stars 
           if (i==(n/2)+1){
               for (int j=1;j<=n;j++){
                     System.out.print("*\t");
               }
           }
           
            
            //logic
            if(i<=n/2){
             star++;   
            }
            
            else{
                star--;
            }
              System.out.println();
            
        }
      

    }
}