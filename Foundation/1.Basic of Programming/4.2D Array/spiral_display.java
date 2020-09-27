import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Nice game going on 
        
        Scanner scn = new Scanner(System.in);
        
        int rows =scn.nextInt();
        int cols = scn.nextInt();
        
        int [][] arr = new int [rows][cols];
        
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        // spiral logic 
        int minr=0;
        int minc=0;
        int maxr=arr.length-1;
        int maxc=arr[0].length-1;
        int cnt=0;
        int tcnt = rows * cols;
        while(cnt<tcnt){
        //left wall
        for (int i=minr, j=minc ; i<=maxr && cnt<tcnt; i++){
            System.out.println(arr[i][j]);
            cnt++;
        }
        
        minc++;
        //bottom wall
            for (int j=minc, i=maxr ; j<=maxc && cnt<tcnt ; j++){
            System.out.println(arr[i][j]);
            cnt++;
        }
// cnt < tcnt is special case of the last uncompleted box
        maxr--;
        //right wall
               for (int i=maxr, j=maxc ; i>=minr && cnt<tcnt ; i--){
            System.out.println(arr[i][j]);
            cnt++;
        }
        maxc--;
        //top wall
            for (int i=minr, j=maxc ; j>=minc && cnt<tcnt ; j--){
            System.out.println(arr[i][j]);
            cnt++;
        }
        minr++;
        
        
        }       
    }

}