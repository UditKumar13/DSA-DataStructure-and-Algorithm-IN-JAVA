import java.util.*;

public class Main{

public static void main(String[] args) {
  // write your code here  
 Scanner scn = new Scanner(System.in);
int num = scn.nextInt();

for (int div=2;div*div<num;div++){
    while(num%div==0){
        num=num/div;
        System.out.print(div + " ");
    }
}

// special cases like  46, upper cond breaks 5*5<23
// 23 is the prime factor remaining itself
if (num!=1){
    System.out.print(num);
}
 }
}