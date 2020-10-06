
package preorder;
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int key) {
        this.data = key;
    }
}
 
public class Preorder {
// Recursive function to perform pre-order traversal of the tree
public static void preorder(Node root)
{
    // return if the current node is empty
    if (root == null) {
        return;
    }
 
    // Display the data part of the root (or current node)
    System.out.print(root.data + " ");
 
    // Traverse the left subtree
    preorder(root.left);
 
    // Traverse the right subtree
    preorder(root.right);
}
    public static void main(String[] args) {
       // construct first tree
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);
 
       
 
       preorder(x);
    }
    
}
