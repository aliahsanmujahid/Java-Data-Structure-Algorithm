
package pkg45.right.view.pkg2;
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
public class RightView2 {
  // traverse nodes in reverse pre-order
    public static void rightView(Node root, int level, Map<Integer, Integer> map)
    {
        if (root == null) {
            return;
        }
 
        // insert the current node and level information into the map
        map.put(level, root.key);
 
        // recur for right subtree before right subtree
        rightView(root.left, level + 1, map);
        rightView(root.right, level + 1, map);
    }
    // Function to print right view of given binary tree
    public static void rightView(Node root)
    {
        // create an empty map to store last node for each level
        Map<Integer, Integer> map = new HashMap<>();
 
        // traverse the tree and fill map
        rightView(root, 1, map);
 
        // iterate through the map in sorted order of its keys and print right view
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }
 
    // main function
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
 
        rightView(root);
    }
}
