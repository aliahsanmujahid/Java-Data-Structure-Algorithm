
package left.view.recursion;
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
 
public class LeftViewRecursion {
    // traverse nodes in pre-order fashion
    public static void leftView(Node root, int level, Map<Integer, Integer> map)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // if level is visited for the first time, insert the current node
        // and level information into the map
        if (!map.containsKey(level)) {
            map.put(level, root.key);
        }
 
        leftView(root.left, level + 1, map);
        leftView(root.right, level + 1, map);
    }
 
    // Function to print left view of given binary tree
    public static void leftView(Node root)
    {
        // create an empty HashMap to store first node for each level
        Map<Integer, Integer> map = new HashMap<>();
 
        // traverse the tree and fill map
        leftView(root, 1, map);
 
        // iterate through the HashMap in sorted order of its keys
        // and print the left view
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }
     public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        leftView(root);
    }
}
