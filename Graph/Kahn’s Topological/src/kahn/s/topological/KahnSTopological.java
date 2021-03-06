
package kahn.s.topological;
import java.util.*;
 
// data structure to store graph edges
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
};
class Graph
{
    // A List of Lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // stores indegree of a vertex
    List<Integer> indegree = null;
 
    // Constructor
    Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }
 
        // initialize indegree of each vertex by 0
        indegree = new ArrayList<>(Collections.nCopies(N, 0));
 
        // add edges to the undirected graph
        for (int i = 0; i < edges.size(); i++)
        {
            int src = edges.get(i).source;
            int dest = edges.get(i).dest;
 
            // add an edge from source to destination
            adjList.get(src).add(dest);
 
            // increment in-degree of destination vertex by 1
            indegree.set(dest, indegree.get(dest) + 1);
        }
    }
}
public class KahnSTopological {
public static List<Integer> doTopologicalSort(Graph graph, int N)
    {
        // list to store the sorted elements
        List<Integer> L = new ArrayList<>();
 
        // get indegree information of the graph
        List<Integer> indegree = graph.indegree;
 
        // Set of all nodes with no incoming edges
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (indegree.get(i) == 0) {
                S.add(i);
            }
        }
 
        while (!S.isEmpty())
        {
            // remove a node n from S
            int n = S.pop();
 
            // add n to tail of L
            L.add(n);
 
            for (int m : graph.adjList.get(n))
            {
                // remove edge from n to m from the graph
                indegree.set(m, indegree.get(m) - 1);
 
                // if m has no other incoming edges then
                // insert m into S
                if (indegree.get(m) == 0) {
                    S.add(m);
                }
            }
        }
 
        // if graph has edges then graph has at least one cycle
        for (int i = 0; i < N; i++) {
            if (indegree.get(i) != 0) {
                return null;
            }
        }
 
        return L;
    }
    public static void main(String[] args) {
       List<Edge> edges = Arrays.asList(
                            new Edge(5, 2), new Edge(5, 0), new Edge(4, 0),
                            new Edge(4, 1), new Edge(2, 3), new Edge(3, 1)
                        );
       
       int N=6;
       Graph graph = new Graph(edges, N);
        List<Integer> L = doTopologicalSort(graph, N);
 
        if (L != null) {
            System.out.print(L);  // print topological order
        } else {
            System.out.println("Graph has at least one cycle. " +
                              "Topological sorting is not possible");
        }
    }
    
}
