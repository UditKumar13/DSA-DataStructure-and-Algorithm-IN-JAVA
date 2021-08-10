import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(boolean[] boxes, int ci, int ti, int lb){
    if(ci > ti){
        for(int i =0; i<boxes.length; i++){
            if(boxes[i]){
                System.out.print("i");
            }
            else{
                System.out.print("-") ; 
            }
        }
        System.out.println() ; 
        return ; 
    }
    
    for (int uk=lb+1 ;uk<boxes.length;uk++){
        if (boxes[uk] == false ){
           boxes[uk]=true; 
           combinations(boxes,ci+1,ti,uk);
           boxes[uk]= false ; 
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new boolean[nboxes], 1, ritems, -1);
  }

}