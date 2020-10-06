
package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
class Edge{
    int src,dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class Graph{
    int i;
    List<List<Integer>> adj = new ArrayList<>();
    Graph(List<Edge> edges,int n){
        for( i=0;i<7;i++){
            adj.add(i,new ArrayList<>());
        }
        System.out.println(i+" "+edges.size());
        for(int i = 0; i <edges.size(); i++){
            int src = edges.get(i).src;
            int dest = edges.get(i).dest;
            System.out.println(i+" "+src+" "+dest);
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
    }
}

public class BFS {
public static void bfs(Graph graph,int v,boolean discovered[]){
Queue<Integer> q = new ArrayDeque<>();
discovered[v] = true;
q.add(v);
    System.out.println("q->"+q);
while(!q.isEmpty()){
    v= q.poll();
    System.out.println("result//v=["+v+"]");
    for(int u:graph.adj.get(v)){
         System.out.println("////u="+u );
        if(!discovered[u]){
            discovered[u] = true;
            q.add(u);
            System.out.println("////q="+q);
        }
    }
}
}
    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(2, 1),new Edge(2, 4),
                new Edge(3, 1), new Edge(3, 4),new Edge(4, 2),new Edge(4, 3),new Edge(4, 5),new Edge(4, 6),new Edge(5, 4),
                new Edge(6, 4)
        );
        int n=12;
        Graph graph = new Graph(edges,n);
        boolean [] discovered = new boolean[7];
        for(int i=0;i<2;i++){
            if(discovered[i]==false)
                bfs(graph,i,discovered);
        }
    }
        
}
