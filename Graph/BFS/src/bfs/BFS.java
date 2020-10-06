
package bfs;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private static int V;
    private LinkedList<Integer> adj[];
    
    BFS(int v){
        this.V = v; 
       adj = new LinkedList[v+1];
       for(int i=0;i<=v;i++){
           adj[i] = new LinkedList<>();
       }
    }
    void addEdge(int src,int dest){
      adj[src].add(dest);
        
    }
   void bfs(BFS g,int s){
       boolean visited[] = new boolean[V];
       LinkedList<Integer> queue = new LinkedList<>();
       
        visited[s]=true; 
        queue.add(s); 
        
         while (!queue.isEmpty()) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            for (int u :g.adj[s]) {
                System.out.println("u ="+u);
                if (!visited[u]) 
                { 
                    visited[u] = true; 
                    queue.add(u); 
                } 
            } 
            } 

   }
    public static void main(String[] args) {
        
        BFS  g = new BFS(4);
        
       g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1);  
      
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)");
       g.bfs(g,2);   
    }
    
}
