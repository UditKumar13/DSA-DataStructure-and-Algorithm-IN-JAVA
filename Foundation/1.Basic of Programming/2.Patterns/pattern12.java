import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int  a=0;
        int b=1;
        int c;
        for (int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                //logic fibo value print in a triangle sequence
                System.out.print(a + "\t");
                c=a+b;
                a=b;
                b=c;
            }
            System.out.println();
        }

    }
}