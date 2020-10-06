
package pkg44.invert.binary.tree;
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
public class InvertBinaryTree {
 // Function to perform preorder traversal of the binary tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Utility function to swap left subtree with right subtree
    public static void swap(Node root) {
        if (root == null) {
            return;
        }
 
        Node temp = root.left;
        root.left =  root.right;
        root.right = temp;
    }
 
    // Function to invert given binary Tree using preorder traversal
    public static void invertBinaryTree(Node root)
    {
        // base case: if tree is empty
        if (root == null)
            return;
 
        // swap left subtree with right subtree
        swap(root);
 
        // invert left subtree
        invertBinaryTree(root.left);
 
        // invert right subtree
        invertBinaryTree(root.right);
    }
    public static void main(String[] args) {
          Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        invertBinaryTree(root);
        preorder(root);
    }
    
}
