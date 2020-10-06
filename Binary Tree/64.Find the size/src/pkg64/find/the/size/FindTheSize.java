
package pkg64.find.the.size;

// Data structure to store a BST node
class Node
{
    // stores value of this node
    int data;
 
    // stores left and right child pointer for this node
    Node left, right;
 
    // Constructor
    Node(int data) {
        this.data = data;
    }
};
 
public class FindTheSize {
  // Recursive function to calculate the size of a given binary tree
    public static int size(Node root)
    {
        // base case: empty tree has size 0
        if (root == null) {
            return 0;
        }
 
        // recursively calculate the size of left and right subtrees and
        // return sum of size of left and right subtrees + 1 (for root node)
        return size(root.left) + 1 + size(root.right);
    }
 
    // Recursive function to determine if given Binary Tree is a BST or not
    // by keeping a valid range (starting from [MIN_VALUE, MAX_VALUE]) and
    // keep shrinking it down for each node as we go down recursively
    public static boolean isBST(Node node, int min, int max)
    {
        // base case
        if (node == null)
            return true;
 
        // if node's value fall outside valid range
        if (node.data < min || node.data > max) {
            return false;
        }
 
        // recursively check left and right subtrees with updated range
        return isBST(node.left, min, node.data) &&
            isBST(node.right, node.data, max);
    }
 
    // Recursive function to find the size of the largest BST in a given binary tree
    public static int findLargestBST(Node root)
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }
 
        return Math.max(findLargestBST(root.left), findLargestBST(root.right));
    }
 
    public static void main(String[] args)
    {
        /* Construct below binary tree
                  10
                /    \
               /      \
              15       8
             /  \     / \
            /    \   /   \
           12    20 5     2
        */
 
        Node root = new Node(10);
 
        root.left = new Node(15);
        root.right = new Node(8);
 
        root.left.left = new Node(12);
        root.left.right = new Node(20);
 
        root.right.left = new Node(5);
        root.right.right = new Node(2);
 
        System.out.println("The size of the largest BST is " + findLargestBST(root));
    }
}
