
package union.find.cycle.detection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Edge{
    int src,dest;
    Edge(int s,int d){
        src=s;
        dest=d;
    }
}
class Graph{
    
    List<List<Integer>>  adjlist  ;
    
    Graph(List<Edge> edges,int N){
        adjlist = new ArrayList(N+1);
        for(int i=0;i<=N;i++){
            adjlist.add(new ArrayList());
        }
        for(Edge edge: edges){
            adjlist.get(edge.src).add(edge.dest);
        }
    }
}
class DisjointSet{

Map<Integer,Integer> parent = new HashMap();

void makeset(int N){
    for(int i=1;i<=N;i++){
        parent.put(i, i);
    }
}
public int Find(int k){
    if(parent.get(k)==k){
        return k;
    }
    return Find(parent.get(k));
}

void Union(int a,int b){
    int x=Find(a);
    int y=Find(b);
    parent.put(x, y);
    
}

}
public class UnionFindCycleDetection {

    public static boolean findCycle(Graph graph, int N){
        DisjointSet ds = new DisjointSet();
        ds.makeset(N);
        
        for (int u = 1; u <= N; u++)
        {
            // Recur for all adjacent vertices
            for (int v : graph.adjlist.get(u))
            {
                // find root of the sets to which elements
                // u and v belongs
                int x = ds.Find(u);
                int y = ds.Find(v);
 
                // both u and v have same parent, cycle is found
                if (x == y) {
                    return true;
                }
                else {
                    ds.Union(x, y);
                }
            }
        }
        
        return false;
    } 
    public static void main(String[] args) {
      List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
                new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
                new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
                new Edge(9, 10), new Edge(9, 11), new Edge(11, 12)
      );
      
      final int N= 12;
      
      Graph graph = new Graph(edges,N);
      
        if (findCycle(graph, N)) {
            System.out.println("Cycle Found");
        }
        else {
            System.out.println("No Cycle is Found");
        }
    }
    
}
