
package pkg30.vertical.sum;
import java.util.Map;
import java.util.TreeMap;
 
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
public class VerticalSum {
// Recursive function to do a pre-order traversal of the tree and fill the map
    // Here node has 'dist' horizontal distance from the root of the tree
    public static void verticalSum(Node root, int dist, Map<Integer, Integer> map)
    {
        // base case: empty tree
        if (root == null)
            return;
 
        // update the map
        if (!map.containsKey(dist)) {
            map.put(dist, 0);
        }
        map.put(dist, map.get(dist) + root.key);
 
        // recur for left subtree by decreasing horizontal distance by 1
        verticalSum(root.left, dist - 1, map);
 
        // recur for right subtree by increasing horizontal distance by 1
        verticalSum(root.right, dist + 1, map);
    }
 
    // Function to print the vertical sum of given binary tree
    public static void verticalSum(Node root)
    {
        // create an empty TreeMap where
        // key -> relative horizontal distance of the node from root node and
        // value -> sum of all nodes present at same horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();
 
        // do pre-order traversal of the tree and fill the map
        verticalSum(root, 0, map);
 
        // traverse the TreeMap and print vertical sum
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }
 
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        verticalSum(root);
    }
    
}
