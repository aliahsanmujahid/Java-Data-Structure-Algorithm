
package graph.representations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class GraphRepresentations {
    
static class Graph{
    LinkedList<Integer> adj[];
    
    Graph(int n){
        adj = new LinkedList[n+1];
        for (int i = 0; i <=n; i++)
            adj[i]=new LinkedList<>();
     
    }
        void addEdge(int src, int dest) 
    { 

           adj[src].add(dest); 
          
        // Since graph is undirected, add an edge from dest 
        // to src also 
      //  graph.adj[dest].add(src); 

    } 
}

private static void printGraph(Graph graph)
    {
        int src=0;
        int n = 10;
        System.out.println("");
        while(src<n){
             for (int dest : graph.adj[src])
                System.out.print("(" + src + " --> " + dest + ")\t");
 
            System.out.println();
            src++;
        }
    }
    public static void main(String[] args) {
      int V = 10; 
        Graph graph = new Graph(V);
        graph.addEdge(0, 1); 
        graph.addEdge(0, 3); 
        graph.addEdge(1, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(3, 2); 
        graph.addEdge(3, 4); 
        graph.addEdge(3, 0); 
        graph.addEdge(5, 6); 
        graph.addEdge(6, 3); 
       printGraph(graph);
               
    }
    
}
