
package path.exists;

import java.util.*;
 
// Data structure to store graph edges
class Edge
{
    public final int source, dest;
 
    private Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
 
    // Factory method for creating a Edge immutable instance
    public static Edge of(int a, int b) {
        return new Edge(a, b);        // calls private constructor
    }
};
 
// Class to represent a graph object
class Graph
{
    // A List of Lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>(N);
 
        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (int i = 0; i < edges.size(); i++)
        {
            int src = edges.get(i).source;
            int dest = edges.get(i).dest;
 
            adjList.get(src).add(dest);
           // adjList.get(dest).add(src);
        }
    }
}
 
public class PathExists {

     public static boolean isConnected(Graph graph, int src, int dest,
                        boolean[] discovered, Queue<Integer> path)
    {
        
        discovered[src] = true;
        
        path.add(src);
        if(src==dest){
            return true;
        }
        for(int i:graph.adjList.get(src)){
            if(!discovered[i]){
                if(isConnected(graph, i, dest, discovered, path)){
                    return true;
                }
            }
        }
        path.poll();
     return false;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(Edge.of(0, 3), Edge.of(1, 0),
                                            Edge.of(1, 2), Edge.of(1, 4),
                                            Edge.of(2, 7), Edge.of(3, 4),
                                            Edge.of(3, 5), Edge.of(4, 3),
                                            Edge.of(4, 6), Edge.of(5, 6),
                                            Edge.of(6, 7)
                                        );
 
        // Number of nodes in the graph (labelled from 0 to N-1)
        int N = 8;
 
        // create a graph from given edges
        Graph graph = new Graph(edges, N);
 
        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // source and destination vertex
        int src = 0, dest = 7;
 
        // List to store the complete path between source and destination
        Queue<Integer> path = new ArrayDeque<>();
 
        // perform DFS traversal from the source vertex to check the connectivity
        // and store path from the source vertex to the destination vertex
        if (isConnected(graph, src, dest, discovered, path))
        {
            System.out.println("Path exists from vertex " + src + 
                                            " to vertex " + dest);
            System.out.println("The complete path is: " + path);
        }
        else {
            System.out.println("No path exists between vertices " + src + 
                                                    " and " + dest);
        }
    }
}
