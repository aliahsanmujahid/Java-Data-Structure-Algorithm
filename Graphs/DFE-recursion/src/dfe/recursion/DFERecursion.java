
package dfe.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            adjList.get(dest).add(src);
        }
    }
}
public class DFERecursion {
    public static void DFS(Graph graph, int v, boolean[] discovered)
	{
		// mark current node as discovered
		discovered[v] = true;

		// print current node
		System.out.print(v + " ");

		// do for every edge (v -> u)
		for (int u : graph.adjList.get(v))
		{
			// u is not discovered
			if (!discovered[u]) {
				DFS(graph, u, discovered);
			}
		}
	}
private static void printGraph(Graph graph)
	{
		int src = 0;
		int n = graph.adjList.size();
            System.out.println("N = "+n);
		while (src < n)
		{
                    System.out.println(src);
			// print current vertex and all its neighboring vertices
			for (int dest : graph.adjList.get(src)) {
				System.out.print("(" + src + " --> " + dest + ")\t");
			}

			System.out.println();
			src++;
		}
	}
public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                // Notice that node 0 is unconnected node
                new Edge(1, 2), new Edge(2, 3), new Edge(2, 8),
                            new Edge(3, 4), new Edge(4, 6), new Edge(5, 7),
                            new Edge(5, 9), new Edge(8, 9)
                // , new Edge(6, 9) // introduce cycle
        );
 
        // Set number of vertices in the graph (0-12)
        final int N = 13;
 
        // create a graph from edges
        Graph graph = new Graph(edges, N);
      ///  printGraph(graph);
 boolean[] discovered = new boolean[N];
 
        // Do DFS traversal from all undiscovered nodes to
        // cover all unconnected components of graph
        for (int i = 0; i < N; i++) {
            if (!discovered[i]) {
                DFS(graph, i, discovered);
            }
}
}}
