package hamiltonian.path.present.in.a.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// data structure to store graph edges
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
};
 
// class to represent a graph object
class Graph
{
    // An array of Lists to represent adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>(N);
 
        for (int i = 0; i < N; i++) {
            adjList.add( new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (int i = 0; i < edges.size(); i++)
        {
            int src = edges.get(i).source;
            int dest = edges.get(i).dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
public class HamiltonianPathPresentInAGraph {
    
    
     public static void printAllHamiltonianPaths(Graph g, int v,
                        boolean[] visited, List<Integer> path, int N)
    {
        // if all the vertices are visited, then
        // hamiltonian path exists
        System.out.println("w||v---------------- "+v);
        System.out.println("P SIZE "+path.size());
        System.out.println("Path "+path);
          System.out.println("VisiT ch = "+v+" = "+visited[v]);  
          System.out.println("W---------------- Get v "+v+" = "+g.adjList.get(v));
           System.out.println();
        if (path.size() == N)
        {
            // print hamiltonian path
            for (int i : path)
                System.out.print(i + " ");
            System.out.println();
 
            return;
        }
 
        // Check if every edge starting from vertex v leads
        // to a solution or not
        for (int w : g.adjList.get(v))
        {
            // process only unvisited vertices as hamiltonian
            // path visits each vertex exactly once
                System.out.println("W------------------------------- Get w "+w+" = "+g.adjList.get(w));
                System.out.println("VisiT ch = "+w+" = "+visited[w]);
                if(visited[w]==false){
                    System.out.println("If Work");
                }else{
                       System.out.println("If Not Work");
                }
                System.out.println();
            if (visited[w]==false)
            {
                visited[w] = true;
                path.add(w);
                System.out.println("Path "+path);
                System.out.println("VisiT init= "+w+" = "+visited[w]);
                System.out.println();
                        
                // check if adding vertex w to the path leads
                // to solution or not
                printAllHamiltonianPaths(g, w, visited, path, N);
 
                // Backtrack
                visited[w] = false;
                System.out.println("Back-P SIZE BEFORE -----w= "+w+" ----- = "+path.size());
                path.remove(path.size()-1);
                System.out.println("Back-P SIZE AFTER -----w= "+w+" ----- = "+path.size());
                 System.out.println();
            }
        }
    }
 
    public static void main(String[] args) {
      List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(0, 3),
                new Edge(1, 2), new Edge(1, 3), new Edge(2, 3)
        );
 
        // Set number of vertices in the graph
        final int N = 4;
 
        // create a graph from edges
        Graph g = new Graph(edges, N);
 
        // starting node
        int start = 0;
 
        // add starting node to the path
        List<Integer> path = new ArrayList<>();
        path.add(start);
 
        // mark start node as visited
        boolean[] visited = new boolean[N];
        visited[start] = true;
 
        printAllHamiltonianPaths(g, start, visited, path, N);
        
    }
}
