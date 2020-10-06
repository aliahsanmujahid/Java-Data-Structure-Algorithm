
package pkg45.right.view.pkg3;
import java.util.concurrent.atomic.AtomicInteger;
 
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
public class RightView3 {
     // Recursive function to print right view of given binary tree
    public static void rightView(Node root, int level, AtomicInteger lastLevel)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // if current node is last node of current level
        if (lastLevel.get() < level)
        {
            // print the node's data
            System.out.print(root.key + " ");
 
            // update last level to current level
            lastLevel.set(level);
        }
 
        // recur for right and left subtree by increasing level by 1
        rightView(root.right, level + 1, lastLevel);
        rightView(root.left, level + 1, lastLevel);
    }
 
    // Function to print right view of given binary tree
    public static void rightView(Node root)
    {
        // Using AtomicBoolean as Integer is passed by value in Java
        AtomicInteger lastLevel = new AtomicInteger(0);
        rightView(root, 1, lastLevel);
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
