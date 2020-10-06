
package pkg36.sink.nodes;
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
public class SinkNodes {
// Function to perform in-order traversal of given binary tree
    public static void inorder(Node root)
    {
        if (root == null)
            return;
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Function to sink root node having value 0 to the bottom of the tree
    // The left and right subtree (if any) of root node are already sinked
    public static void sink(Node root)
    {
        // base case: tree is empty
        if (root == null) {
            return;
        }
 
        // if left subtree exists & left child has non-zero value
        if (root.left != null && root.left.data != 0)
        {
            // swap data of current node with its left child
            int temp = root.data;
            root.data = root.left.data;
            root.left.data = temp;
 
            // recur for left subtree
            sink(root.left);
        }
 
        // if right subtree exists & right child has non-zero value
        else if(root.right != null && root.right.data != 0)
        {
            // swap data of current node with its right child
            int temp = root.data;
            root.data = root.right.data;
            root.right.data = temp;
 
            // recur for right subtree
            sink(root.right);
        }
    }
 
    // Main function to sink nodes having zero value to the bottom
    // of the binary tree
    public static void sinkNodes(Node root)
    {
        // base case: tree is empty
        if (root == null) {
            return;
        }
 
        // fix left subtree and right subtree first
        sinkNodes(root.left);
        sinkNodes(root.right);
 
        // sink current node it has value 0
        if (root.data == 0) {
            sink(root);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(0);
        root.right.left = new Node(0);
        root.right.right = new Node(2);
        root.right.left.left = new Node(3);
        root.right.left.right  = new Node(4);
 
        sinkNodes(root);
 
        inorder(root);
    }
    
}
