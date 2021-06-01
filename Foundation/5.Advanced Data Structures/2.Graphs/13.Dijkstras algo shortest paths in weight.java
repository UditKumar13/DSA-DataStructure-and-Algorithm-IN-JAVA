import java.io.*;
import java.util.*;

// Dijkstra's algorithm 

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static class Pair implements Comparable <Pair> {
       int v;
       String psf;
       int wsf;
       
       Pair (int v, String psf, int wsf){
           this.v = v;
           this.psf = psf;
           this.wsf = wsf ; 
       }
       
       public int compareTo(Pair o){
           return this.wsf - o.wsf; 
           // comparision on the basis of weight so far
           // lowest value is given highest priority
       }
       
       
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(src, src +  "" , 0));
      //initialization for the source 
      
      boolean [] visited = new boolean [vtces];
      while (pq.size()>0){
          Pair rem = pq.remove();
          // remove the lowest wt first
          if (visited[rem.v] == true){
              continue;
          }
          
          visited[rem.v] = true;
          //mark
          
          // work
          System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);
          
          //add neigbours *
          for (Edge e : graph[rem.v]){
              if (visited[e.nbr] == false){
                  pq.add(new Pair(e.nbr,rem.psf + e.nbr,rem.wsf +e.wt));
              }
          }
      }
      
      
   }
}