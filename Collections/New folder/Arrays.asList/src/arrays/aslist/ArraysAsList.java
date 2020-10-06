
package arrays.aslist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
class Edge {
	int src, dest;

	Edge(int src, int dest)
	{
		this.src = src;
		this.dest = dest;
	}
};

public class ArraysAsList {

    public static void main(String[] args) {
   
List<Edge> edges = Arrays.asList(new Edge(0, 1),new Edge(2, 0),
                        new Edge(2, 1));
		for (Edge current : edges)
		{
	                   System.out.println(current.src+" "+current.dest);
		}
}
}
