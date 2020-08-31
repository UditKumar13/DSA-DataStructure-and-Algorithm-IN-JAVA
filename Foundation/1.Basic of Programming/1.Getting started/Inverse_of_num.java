import java.util.*;

public class Main{

public static void main(String[] args) {
  Scanner scn = new Scanner(System.in);
  int num = scn.nextInt();
  // Inverse of a number 
  // op : original pos , od : original digit 
  //ip: inverse position , id :inverse digit 
  int i=0;
  int op=1;
  int inverse=0;
  while (num!=0){
      int od = num%10;
      int ip=od;
      int id=op;
      num=num/10;
      op++;
      inverse+=id*(int)Math.pow(10,ip-1);
      
  }
  
  System.out.print(inverse);
  

 }
}