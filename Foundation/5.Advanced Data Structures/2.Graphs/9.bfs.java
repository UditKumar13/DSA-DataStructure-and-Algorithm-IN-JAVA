import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
    static class Pair{
       int v;
      String psf;
      
      Pair(int v, String psf){
          this.v = v;
          this.psf = psf;
          
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      ArrayDeque<Pair> que = new ArrayDeque<>();
      que.add(new Pair(src,src + ""));
      
      boolean [] visited = new boolean [vtces];
      
      while (que.size()>0){
          // r m* w a*
          // remove mark_star work add_star_to_neighbours
          Pair rem = que.removeFirst(); //r
          if (visited[rem.v] == true){
              continue;
              // jump out of this iteration and continue other iterations 
          }
          visited[rem.v] = true ;  // m*
          System.out.println(rem.v + "@" + rem.psf); //w
          
          // a* 
          for (Edge e : graph[rem.v]){
              if (visited[e.nbr] == false){
                  que.add(new Pair(e.nbr,rem.psf + e.nbr));
              }
          }
          
          
      }
      
      
      
   }
}