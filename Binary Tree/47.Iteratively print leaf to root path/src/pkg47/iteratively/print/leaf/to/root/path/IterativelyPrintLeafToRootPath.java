
package pkg47.iteratively.print.leaf.to.root.path;

import java.util.ArrayDeque;
import java.util.Deque;
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
public class IterativelyPrintLeafToRootPath {
  // Function to check if given node is a leaf node or not
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
 
    // Recursive function to print root-to-leaf path for a given leaf
    public static void printPathRecursive(Node curr, Map<Node, Node> map)
    {
        // base case : curr is root node (parent of root node is null)
        if (curr == null) {
            return;
        }
 
        // recursively call parent node
        printPathRecursive(map.get(curr), map);
        System.out.print(curr.data + (isLeaf(curr) ? "\n" : " -> "));
    }
 
    // Iterative function to print leaf-to-root path for a given leaf
    // For printing root-to-leaf path, we can use printPathRecursive() or a stack
    public static void printPathIterative(Node leafNode, Map<Node, Node> map)
    {
        // start from the leaf node
        Node curr = leafNode;
 
        // loop till root node is reached and print each node in the path
        while (map.get(curr) != null)
        {
            System.out.print(curr.data + " -> ");
            curr = map.get(curr);
        }
 
        System.out.println(curr.data);
    }
 
    // Iterative function to print leaf to root path for every leaf node
    public static void postorderIterative(Node root)
    {
        // create an empty stack
        Deque<Node> stk = new ArrayDeque<>();
 
        // create an empty map to store (child, parent) pairs
        Map<Node, Node> map = new HashMap<>();
 
        // parent of root node is null
        map.put(root, null);
 
        // push root node
        stk.add(root);
 
        // loop till stack is not empty
        while (!stk.isEmpty())
        {
            // pop top node from the stack
            Node curr = stk.poll();
 
            // if leaf node is found, print the path
            if (isLeaf(curr))
            {
                // print leaf-to-root path for current leaf
                printPathIterative(curr, map);
 
                // print root-to-leaf path for current leaf
                // printPathRecursive(curr, map);
            }
 
            // push left and right child of popped node to the stack
            // include current node left and right child in a map
            if (curr.right != null)
            {
                stk.add(curr.right);
                map.put(curr.right, curr);
            }
 
            if (curr.left != null)
            {
                stk.add(curr.left);
                map.put(curr.left, curr);
            }
        }
    }
 
    // main function
    public static void main(String[] args)
    {
        /* Construct below tree
                   1
                 /   \
                /     \
               /       \
              2         3
             / \       / \
            /   \     /   \
           4     5   6     7
                    / \
                   /   \
                  8     9
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right  = new Node(9);
 
        postorderIterative(root);
    }
}
