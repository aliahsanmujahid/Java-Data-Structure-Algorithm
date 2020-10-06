
package pkg48.maximum.width.pkg2;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
 
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
public class MaximumWidth2 {

    // Traverse the tree in pre-order fashion and store count of nodes
    // in each level
    public static void preorder(Node root, int level, Map<Integer, Integer> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // increment count of nodes in current level
        map.putIfAbsent(level, 0);
        map.put(level, map.get(level) + 1);
 
        // recur for left and right subtree by increasing level by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }
 
    // Recursive function to find maximum width of the tree
    public static void maxWidth(Node root)
    {
        // create an empty map to store count of nodes in each levels
        Map<Integer, Integer> map = new HashMap<>();
 
        // traverse the tree and fill map
        preorder(root, 1, map);
 
        // iterate through the map and find maximum width
        int maxWidth = map.values()
                        .stream()
                        .max(Comparator.<Integer>naturalOrder()).get();
 
        System.out.print("Maximum width is " + maxWidth);
    }
 
    // main function
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
 
        maxWidth(root);
    }
}

