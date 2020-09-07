import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

public static void reverse(int[] a, int st, int end){
    int i=st;
    while(i<end){
        int temp = a[i];
        a[i]=a[end];
        a[end]=temp;
        i++;
        end--;
    
    }
}
  public static void rotate(int[] a, int k){
    // Nice game going on
    //last index is li
    int li = a.length-1;
    // special cases for k
    int nli=li*(-1);
    // magnitude whether its negative or positive higher than total ele of arr
    if (k>li || k<nli){
    k=k%(li+1);
    }    
    // for negative value
    if (k<0){
    k+=(li+1);}
    // part1 is from index 0 to li-k
    reverse(a,0,li-k);
    
    // part2 is from index li-k+1 to li

    reverse(a,li-k+1,li);
    // now reverse the whole array from 0 to li 
    reverse(a,0,li);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}