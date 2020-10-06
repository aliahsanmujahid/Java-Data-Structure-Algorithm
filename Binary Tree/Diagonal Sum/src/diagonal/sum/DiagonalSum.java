
package diagonal.sum;
import java.util.HashMap;
import java.util.Map;
 
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
public class DiagonalSum {

    // Recursive function to do a pre-order traversal of the tree and
    // fill the map with diagonal sum of elements
    public static void diagonalSum(Node root, int diagonal, Map<Integer, Integer> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // update the current diagonal with node's value
        map.putIfAbsent(diagonal, 0);
        map.put(diagonal, map.get(diagonal) + root.data);
 
        // recur for left subtree by increasing diagonal by 1
        diagonalSum(root.left, diagonal + 1, map);
 
        // recur for right subtree with same diagonal
        diagonalSum(root.right, diagonal, map);
    }
 
    // Function to print the diagonal sum of given binary tree
    public static void diagonalSum(Node root)
    {
        // create an empty map to store diagonal sum for every slope
        Map<Integer, Integer> map = new HashMap<>();
 
        // do pre-order traversal of the tree and fill the map
        diagonalSum(root, 0, map);
 
        // traverse the map and print diagonal sum
        for (int i = 0; i < map.size(); i++) {
            System.out.print(map.get(i) +" ");
        }
    }
    public static void main(String[] args) {
       Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left  = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        diagonalSum(root);
    }
    
}
