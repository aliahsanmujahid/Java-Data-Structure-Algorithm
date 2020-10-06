
package pkg44.invert.binary.tree.pkg3;
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
 
 
public class InvertBinaryTree3 {
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
 
    // Iterative Function to invert given binary Tree using stack
    public static void invertBinaryTree(Node root)
    {
        // base case: if tree is empty
        if (root == null) {
            return;
        }
 
        // create an empty stack and push root node
        Deque<Node> s = new ArrayDeque<>();
        s.add(root);
 
        // run till stack is not empty
        while (!s.isEmpty())
        {
            // pop top node from stack
            Node curr = s.poll();
 
            // swap left child with right child
            swap(curr);
 
            // push right child of popped node to the stack
            if (curr.right != null) {
                s.add(curr.right);
            }
 
            // push left child of popped node to the stack
            if (curr.left != null) {
                s.add(curr.left);
            }
        }
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
