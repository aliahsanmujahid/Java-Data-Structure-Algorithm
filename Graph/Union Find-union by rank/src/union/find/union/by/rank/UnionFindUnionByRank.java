
package union.find.union.by.rank;

import java.util.HashMap;
import java.util.Map;

class Disjointset{
   Map<Integer,Integer> parrent = new HashMap();
    public  void makeSet(int universe[]){
        for(int i : universe){
            parrent.put(i,i);
        }
    }
    
    public int Find(int k){
   //   System.out.print(parrent.get(k)+" ");
        if(parrent.get(k)==k)
            return k;
        return Find(parrent.get(k));
    }
    
    public void Union(int a,int b){
        int x= Find(a);
        //System.out.println(x);
                
        int y= Find(b);
        // System.out.println(y);
        parrent.put(x,y);
    }

}

public class UnionFindUnionByRank {
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
