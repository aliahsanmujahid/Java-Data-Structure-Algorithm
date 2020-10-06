
package pkg28.find.ancestors;
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
public class FindAncestors {
// Recursive function to print all ancestors of given node in a binary tree. The
    // function returns true if node is found in subtree rooted at given root node
    public static boolean printAncestors(Node root, int node)
    {
        // base case
        if (root == null) {
            return false;
        }
 
        // return true if given node is found
        if (root.data == node) {
            return true;
        }
 
        // search node in left subtree
        boolean left = printAncestors(root.left, node);
 
        // search node in right subtree
        boolean right = false;
        if (!left) {
            right = printAncestors(root.right, node);
        }
 
        // if given node is found in either left or right subtree,
        // current node is an ancestor of given node
        if (left || right) {
            System.out.print(root.data + " ");
        }
 
        // return true if node is found
        return left || right;
    }
    public static void main(String[] args) {
          Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.right.right = new Node(8);
 
        int node = 7;
        printAncestors(root, node);
    }
    
}
