import java.io.*;
import java.util.*;

public class Main {
    
    
    /*input:
    4
3 12 13 15*/
    public static boolean isPrime(int n){
        int count=0;
        for(int rang=2;rang*rang<=n;rang++){
            if (n%rang==0){
                count++;
                break;
            }
        }
        
        if (count==0){
            return true;
        }
        else{
            return false;
        }
        
    }

	public static void solution(ArrayList<Integer> al){
		// Nice game going on !
		int size = al.size();
		//ulta loop hi lena chahiye arraylist mein
		//proper sync
		for (int t=size-1;t>=0;t--){
		    if (isPrime(al.get(t))){
		        al.remove(t);
		    }
		    
		    
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}

}