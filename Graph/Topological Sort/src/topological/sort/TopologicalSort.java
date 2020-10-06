/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topological.sort;

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
        // allocate memory
        adjList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (int i = 0; i < edges.size(); i++)
        {
            int src = edges.get(i).source;
            int dest = edges.get(i).dest;
 
            // add an edge from source to destination
            adjList.get(src).add(dest);
        }
    }
}
public class TopologicalSort {
    
static int DFS(Graph graph, int v, boolean[] discovered,
                           int[] departure, int time)
    {
        
        
        discovered[v]=true;
        time++;
        System.out.println(time);
       for(int u:graph.adjList.get(v)){
           if(!discovered[u]){
               time=    DFS(graph, u, discovered, departure, time);
           }
       }
        departure[time] = v;
        time++;
        System.out.println(time);
        return time;
        
        
    }
 
    // performs Topological Sort on a given DAG
    public static void doTopologicalSort(Graph graph, int N)
    {
        int[] departure = new int[2*N];
        Arrays.fill(departure, -1);
         
       boolean[] discovered = new boolean[N];
        int time = 0;
        
        for (int i = 0; i < N; i++) {
            if (!discovered[i]) {
                time=DFS(graph, i, discovered, departure, time);
                System.out.println(time);
            }
        }
        for(int i=N*2-1;i>=0;i--){
            if(departure[i]!=-1){
                System.out.print(departure[i]+" ");
            }
        }    
        
    }
 
    // Topological Sort Algorithm for a DAG using DFS
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                            new Edge(5, 2), new Edge(5, 0), new Edge(4, 0),
                            new Edge(4, 1), new Edge(2, 3), new Edge(3, 1)
                        );
 
        // Set number of vertices in the graph
        final int N = 6;
 
        // create a graph from edges
        Graph graph = new Graph(edges, N);
 
        // perform Topological Sort
        doTopologicalSort(graph, N);
    }
}
