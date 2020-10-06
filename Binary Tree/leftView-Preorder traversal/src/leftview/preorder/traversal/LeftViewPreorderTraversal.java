
package leftview.preorder.traversal;

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
 
public class LeftViewPreorderTraversal {
    // Recursive function to print left view of given binary tree
    public static void leftView(Node root, int level, AtomicInteger lastLevel)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // if current node is first node of current level
        if (lastLevel.get() < level)
        {
            // print the node's data
            System.out.print(root.key + " ");
 
            // update last level to current level
            lastLevel.set(level);
        }
 
        // recur for left and right subtree by increasing level by 1
        leftView(root.left, level + 1, lastLevel);
        leftView(root.right, level + 1, lastLevel);
    }
 
    // Function to print left view of given binary tree
    public static void leftView(Node root)
    {
        // Using AtomicBoolean as Integer is passed by value in Java
        AtomicInteger lastLevel = new AtomicInteger(0);
        leftView(root, 1, lastLevel);
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
 
        leftView(root);
    }
}
