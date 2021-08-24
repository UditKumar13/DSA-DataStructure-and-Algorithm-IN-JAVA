import java.io.*;
import java.util.*;

/*
1. You are given N strings which represents N different skills related to I.T field.
2. You are working on a project and you want to hire a team of software developers for that project.
3. There are N applicants. Every applicant has mentioned his/her skills in resume.
4. You have to select the minimum number of developers such that for every required skill, there is 
     at least one person in the team who has that skill.
5. It is guaranteed that you can form a team which covers all the required skills.

Note -> Check out the question video for details.
*/
public class Main {

	static ArrayList<Integer> sol = new ArrayList<>();

	public static void solution(int[] people, int nskills, int cp, ArrayList<Integer> onesol, int smask) {
		
		
		// base case 
		// aisa krte krte hum pahunch jayenge ekk din jab cp , people ke equal ho jayega
		
		if(cp == people.length){
		    // we have to only the answer smask where it has covered all the skills
		    if(smask == ((1 << nskills) -1)){
		        if(sol.size()==0 || onesol.size() < sol.size()){
		            sol = new ArrayList<>(onesol); 
		        }
		        // it will have the minimum answer from  all the potential answers
		    }
		    return ; 
		}
		
		
		solution(people,nskills,cp+1,onesol,smask);
		// have to add the current people to onesol, so onesol is our level
		onesol.add(cp) ;// and cp is our current person
		//after selection call recursively yes to the person
		solution(people,nskills,cp+1,onesol,(smask | people[cp]));
		//backtrack
		onesol.remove(onesol.size()-1);
		
		
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashMap<String, Integer> smap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			smap.put(scn.next(), i);
		} // strings for the skills
		
		int np = scn.nextInt(); //number of applicants 
		int[] people = new int[np]; // 0 1 2 3 
		for (int i = 0; i < np; i++) {
			int personSkills = scn.nextInt(); // one person skill 
			for (int j = 0; j < personSkills; j++) {
				String skill = scn.next();
				int snum = smap.get(skill);
				people[i] = people[i] | (1 << snum); 
			} // this for loop is making the skill map of the individual person to one or zero e.g : a b c d e (1 0 1 0 0 ) for person 1,  where a,b,c,d,e are the skills
		}

		solution(people, n, 0, new ArrayList<>(), 0);
		// final answer will be in sol
		System.out.println(sol);
		
	}
}