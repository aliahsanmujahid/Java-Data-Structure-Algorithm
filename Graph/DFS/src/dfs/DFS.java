
package dfs;

import java.util.LinkedList;

public class DFS {
static class Graph{
    int v;
    LinkedList<Integer> adj[];
    Graph(int v){
        this.v=v;
        adj  =new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i] = new LinkedList();
        }
    }
  void addEdge(int src,int dest){ 
    adj[src].add(dest);
}
}

    public static void printGraph(Graph g){
        int src=0;
        int n=g.v;
        
        while(src<n){
             for (int dest : g.adj[src])
                System.out.print("(" + src + " --> " + dest + ")\t");
 
            System.out.println();
            src++;
        }
    }
    public static void DFS(Graph g,int v,boolean visited[]){
        visited[v]  =true;
        System.out.print(v+" ");
        for(int u : g.adj[v]){
            if (!visited[u]) {
                DFS(g, u, visited);
            }
        }
    }
    public static void main(String[] args) {
      Graph g = new Graph(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);   
       //  printGraph(g);
        boolean visited[] = new boolean[g.v]; 
       DFS(g,0,visited);
    }
    
}
