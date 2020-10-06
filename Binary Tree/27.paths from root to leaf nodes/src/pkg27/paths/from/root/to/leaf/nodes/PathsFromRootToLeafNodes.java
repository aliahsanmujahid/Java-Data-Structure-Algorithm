
package pkg27.paths.from.root.to.leaf.nodes;
import java.util.ArrayDeque;
import java.util.Deque;
 
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
public class PathsFromRootToLeafNodes {
// Function to check if given node is a leaf node or not
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
 
    // Recursive function to find paths from root node to every leaf node
    public static void printRootToleafPaths(Node node, Deque<Integer> path)
    {
        // base case
        if (node == null) {
            return;
        }
 
        // include current node to the path
        path.addLast(node.data);
 
        // if leaf node is found, print the path
        if (isLeaf(node)) {
            System.out.println(path);
        }
 
        // recur for left and right subtree
        printRootToleafPaths(node.left, path);
        printRootToleafPaths(node.right, path);
 
        // remove current node after left and right subtree are done
        path.removeLast();
    }
 
    // Main function to print paths from root node to every leaf node
    public static void printRootToleafPaths(Node node)
    {
        // list to store root to leaf path
        Deque<Integer> path = new ArrayDeque<>();
        printRootToleafPaths(node, path);
    }
 
    public static void main(String[] args) {
       Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.right.right = new Node(9);
 
        // print all root to leaf paths
        printRootToleafPaths(root);
    }
    
}
