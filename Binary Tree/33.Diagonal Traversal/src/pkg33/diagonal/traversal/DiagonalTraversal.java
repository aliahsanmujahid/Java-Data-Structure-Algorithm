
package pkg33.diagonal.traversal;
import java.util.*;
 
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
public class DiagonalTraversal {
    // Recursive function to do a pre-order traversal of the tree and
    // fill the map with diagonal elements
    public static void printDiagonal(Node node, int diagonal,
                                    Map<Integer, List<Integer>> map)
    {
        // base case: empty tree
        if (node == null) {
            return;
        }
 
        // insert current node in current diagonal
        if (!map.containsKey(diagonal)) {
            map.put(diagonal, new ArrayList<>());
        }
        map.get(diagonal).add(node.data);
 
        // recur for left subtree by increasing diagonal by 1
        printDiagonal(node.left, diagonal + 1, map);
 
        // recur for right subtree with same diagonal
        printDiagonal(node.right, diagonal, map);
    }
 
// Function to print the diagonal elements of given binary tree
    public static void printDiagonal(Node root)
    {
        // create an empty multi-map to store diagonal element in every slope
        Map<Integer, List<Integer>> map = new HashMap<>();
 
        // do pre-order traversal of the tree and fill the map
        printDiagonal(root, 0, map);
 
        // traverse the map and print diagonal elements
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }
    public static void main(String[] args) {
       Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        printDiagonal(root);
    }
    
}
