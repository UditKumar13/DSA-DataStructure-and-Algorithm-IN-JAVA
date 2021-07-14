import java.io.*;
import java.util.*;

public class Main {
static int counter = 0; 
	public static void solution(int i, int n, int k, int nos, ArrayList<ArrayList<Integer>> ans) {
		//nos : number of sets 
		if (i>n){
		    if (nos == k ){
		       counter ++ ; 
		       System.out.print(counter + ". ");
		       for (ArrayList<Integer> set :ans ){
		           System.out.print(set + " ");
		       }
		         System.out.println();
		    }
		  
		    return ;
		}
		
		
		for (int j=0 ;j<ans.size();j++){
		    if (ans.get(j).size() >0 ){
		        // that means non empty
		        ans.get(j).add(i);
		        solution(i+1,n,k,nos,ans);
		        ans.get(j).remove(ans.get(j).size()-1);
		    }
		    
		    else{
		        //empty set 
		        // insertion only one time 
		          ans.get(j).add(i);
		        solution(i+1,n,k,nos + 1,ans); // insertion in a new set that why nos + 1 
		        ans.get(j).remove(ans.get(j).size()-1);
		        break; 
		    }
		}
		
		
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}

}