import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        // printing all the primes between low and high incliding them 
        
        for (int i=low;i<=high;i++){
            int count=0;
            for (int j=2;j*j<=i;j++){
                if(i%j==0){
                    count++;
                    break;
                }
            }
            if (count==0)
            System.out.println(i);
            
        }
    }
}