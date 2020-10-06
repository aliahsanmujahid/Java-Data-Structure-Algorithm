
package strongly.connected.or.not;
import java.util.*;
 
// Data structure to store graph edges
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
};
 
// Class to represent a graph object
class Graph
{
    // A List of Lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }
 
        // add edges to the directed graph
        for (int i = 0; i < edges.size(); i++)
        {
            int src = edges.get(i).source;
            int dest = edges.get(i).dest;
 
            adjList.get(src).add(dest);
        }
    }
}
 
public class StronglyConnectedOrNot {

    private static void DFS(Graph graph, int v, boolean[] visited)
    {
        // mark current node as visited
        visited[v] = true;
 
        // do for every edge (v -> u)
        for (int u : graph.adjList.get(v))
        {
            // u is not visited
            if (!visited[u])
                DFS(graph, u, visited);
        }
    }
    
    public static boolean check(Graph graph, int N){
        
        boolean[] visited = new boolean[N];
        DFS(graph, 0, visited);
        for (boolean b: visited)
                if (!b)
                return false;
        
        return true;
    }
   public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 4), new Edge(1, 0), new Edge(1, 2),
                new Edge(2, 1), new Edge(2, 4), new Edge(3, 1),
                new Edge(3, 2) , new Edge(4, 3)
        );
 
        // Number of vertices in the graph
        final int N = 5;
 
        // construct graph
        Graph graph = new Graph(edges, N);
 
        // check if graph is not strongly connected or not
        if (check(graph, N))
            System.out.println("Graph is Strongly Connected");
        else
            System.out.println("Graph is not Strongly Connected");
    }
}
