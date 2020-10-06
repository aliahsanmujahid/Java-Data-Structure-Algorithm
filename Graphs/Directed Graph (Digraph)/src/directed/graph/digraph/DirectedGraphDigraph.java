package directed.graph.digraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Edge {
	int src, dest;

	Edge(int src, int dest)
	{
		this.src = src;
		this.dest = dest;
	}
};
class Graph
{
	// A list of lists to represent adjacency list
	List<List<Integer>> adj = new ArrayList<>();

	// Constructor to construct graph
	public Graph(List<Edge> edges)
	{
		// allocate memory for adjacency list
		for (int i = 0; i < 7; i++) {
			adj.add(i, new ArrayList<>());
		}

		// add edges to the undirected graph
		for (Edge current : edges)
		{
			// allocate new node in adjacency List from src to dest
                                      System.out.println(current.src+" "+current.dest);
			adj.get(current.src).add(current.dest);
                                      adj.get(current.dest).add(current.src);
			// Uncomment line 39 for undirected graph

			// allocate new node in adjacency List from dest to src
			// adj.get(current.dest).add(current.src);
		}
	}
}

public class DirectedGraphDigraph {
private static void printGraph(Graph graph)
	{
		int src = 0;
		int n = graph.adj.size();
            System.out.println("N = "+n);
		while (src < n)
		{
                    System.out.println(src);
			// print current vertex and all its neighboring vertices
			for (int dest : graph.adj.get(src)) {
				System.out.print("(" + src + " --> " + dest + ")\t");
			}

			System.out.println();
			src++;
		}
	}

	// Directed Graph Implementation in Java
	public static void main (String[] args)
	{
		// Input: List of edges in a directed graph (as per above diagram)
		List<Edge> edges = Arrays.asList(
                        new Edge(1, 2), new Edge(1, 3), new Edge(2, 1),new Edge(2, 4),
                new Edge(3, 1), new Edge(3, 4),new Edge(4, 2),new Edge(4, 3),new Edge(4, 5),new Edge(4, 6),new Edge(5, 4),
                new Edge(6, 4)
                
                );

		// construct graph from given list of edges
		Graph graph = new Graph(edges);

		// print adjacency list representation of the graph
		printGraph(graph);
	}
}
