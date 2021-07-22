import java.io.*;
import java.util.*;

public class Main {
 // ci is like the number 1,2,3,4, keeping increases each and every time 
  public static void permutations(int[] boxes, int ci, int ti){
      
      // base case 
      if(ci >ti){
          // print the array current value
          for (int uk=0;uk<boxes.length;uk++){
              System.out.print(boxes[uk]);
          }
          
          System.out.println();
          return ;
      }
      
    for(int i=0; i<boxes.length;i++){
        if(boxes[i] == 0){
            //then only allowed to write the entry 
            boxes[i] = ci;
            //edge pre work
            permutations(boxes,ci+1,ti); 
            // recursive call for trying the other possibility keeping edge pre work reserved
            boxes[i] = 0;
            //**Backtracking removing the current possibilty and to try something new 
            //edge post work
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}