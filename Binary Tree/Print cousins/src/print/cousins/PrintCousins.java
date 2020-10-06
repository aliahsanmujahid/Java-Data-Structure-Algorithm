
package print.cousins;

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
public class PrintCousins {
// Function to find level of given node x
    public static void findLevel(Node root, Node x, int index, AtomicInteger level)
    {
        // return if tree is empty or level is already found
        if (root == null || level.get() != 0) {
            return;
        }
 
        // if given node is found, update its level
        if (root == x) {
            level.set(index);
        }
 
        // recur for left and right subtree
        findLevel(root.left, x, index + 1, level);
        findLevel(root.right, x, index + 1, level);
    }
 
    public static void printLevel(Node root, Node node, int level)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // print cousins
        if (level == 1) {
            System.out.print(root.key + " ");
            return;
        }
 
        // recur for left and right subtree if given node is not child of the root
        if (!(root.left != null && root.left == node || 
            root.right != null && root.right == node))
        {
            printLevel(root.left, node, level - 1);
            printLevel(root.right, node, level - 1);
        }
    }
 
    // Function to print all cousins of given node
    public static void printAllCousins(Node root, Node node)
    {
        // Using AtomicBoolean as Integer is passed by value in Java
        AtomicInteger level = new AtomicInteger(0);
 
        // find level of given node
        findLevel(root, node, 1, level);
 
        // print all cousins of given node using its level number
        printLevel(root, node, level.get());
    }
 
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        printAllCousins(root, root.right.left);
    }
    
}
