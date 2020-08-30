import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int sp=n/2;
        int star=1;
        int val=1;
        for (int i=1;i<=n;i++){
            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }
               int tval= val;
                for(int j=1;j<=star;j++){
                 
                System.out.print(tval + "\t");
                //logic
                if(j<=star/2){
                tval++;    
                }
                else{
                    tval--;
                }
                
                
            }
                for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }
            
            if (i<=n/2){
                sp--;
                star+=2;
                val++;
                
            }
            
            else{
                sp++;
                star-=2;
                val--;
            }
            System.out.println();
       
        }

    }
}