
package unionfindpath.compression;

import java.util.HashMap;
import java.util.Map;

class Disjointset{
   Map<Integer,Integer> parent = new HashMap();
   Map<Integer,Integer> rank = new HashMap();
     void makeSet(int[] universe)
    {
        // create n disjoint sets (one for each item)
        for (int i : universe)
        {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }
    

    // Find the root of the set in which element k belongs
     int Find(int k)
    {
       if(parent.get(k)==k){
        return k;
    }
    return Find(parent.get(k));
    }
    
 void Union(int a, int b)
    {
        // find root of the sets in which elements
        // x and y belongs
        int x = Find(a);
        int y = Find(b);
 
        // if x and y are present in same set
        if (x == y)
            return;
 
        // Always attach smaller depth tree under the
        // root of the deeper tree.
        if (rank.get(x) > rank.get(y))
            parent.put(y, x);
        else if (rank.get(x) < rank.get(y))
            parent.put(x, y);
        else
        {
            parent.put(x, y);
            rank.put(y, rank.get(y) + 1);
        }
    }

}

public class UnionFindpathCompression {
        public static void printSets(int[] universe, Disjointset ds)
    {
        for (int i : universe)
            System.out.print(ds.Find(i) + " ");
 
        System.out.println();
    }
    public static void main(String[] args) {
        int[] universe = {1,2,3,4,5};
        Disjointset ds = new Disjointset();
        
        ds.makeSet(universe);
        printSets(universe, ds);
        
        ds.Union(4, 3); // 4 and 3 are in same set
        printSets(universe, ds);
        
        ds.Union(2, 1); // 1 and 2 are in same set
        printSets(universe, ds);
 
        ds.Union(1, 3); // 1, 2, 3, 4 are in same set
        printSets(universe, ds);

         
    }
}
