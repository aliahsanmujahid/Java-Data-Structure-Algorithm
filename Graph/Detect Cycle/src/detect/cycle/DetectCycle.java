
package detect.cycle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DetectCycle {
 private final int V; 
    private final List<List<Integer>> adj; 
  
    public DetectCycle(int V)  
    { 
        this.V = V; 
        adj = new ArrayList<>(V); 
          
        for (int i = 0; i < V; i++) 
            adj.add(new LinkedList<>()); 
    } 
    private boolean isCyclicUtil(int i, boolean[] visited, 
                                      boolean[] recStack)  
    { 
          
        // Mark the current node as visited and 
        // part of recursion stack 
        if (recStack[i]) 
            return true; 
  
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
      //  List<Integer> children = adj.get(i); 
          
        for (Integer c: adj.get(i)) 
            if (isCyclicUtil(c, visited, recStack)) 
                return true; 
                  
        recStack[i] = false; 
  
        return false; 
    } 
  
    private void addEdge(int source, int dest) { 
        adj.get(source).add(dest); 
    } 
  
    // Returns true if the graph contains a  
    // cycle, else false. 
    // This function is a variation of DFS() in  
    // https://www.geeksforgeeks.org/archives/18212 
    private boolean isCyclic()  
    { 
          
        // Mark all the vertices as not visited and 
        // not part of recursion stack 
        boolean[] visited = new boolean[V]; 
        boolean[] recStack = new boolean[V]; 
          
          
        // Call the recursive helper function to 
        // detect cycle in different DFS trees 
        for (int i = 0; i < V; i++) 
            if (isCyclicUtil(i, visited, recStack)) 
                return true; 
  
        return false; 
    } 
    public static void main(String[] args) {
        DetectCycle graph = new DetectCycle(10); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 3); 
        graph.addEdge(1, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(3, 2); 
        graph.addEdge(3, 4); 
        graph.addEdge(3, 0); 
        graph.addEdge(5, 6); 
        graph.addEdge(6, 3); 
          
        if(graph.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't "
                                    + "contain cycle"); 
    } 
    }

