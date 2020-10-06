/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sum.tree;

// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
public class SumTree {
// Function to print pre-order traversal of given tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
   /* Construct below tree
                  1
               /     \
              2       3
             / \     / \
            4   5   6   7
        */
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    // Recursive function to in-place convert the given binary tree to its
    // sum tree by traversing the tree in post-order manner
    public static int convertToSumTree(Node root)
    {
        // base case: tree is empty
        if (root == null) {
            return 0;
        }
 
        // recursively convert left and right subtree first before
        // processing the root node
        int left = convertToSumTree(root.left);
        int right = convertToSumTree(root.right);
 
        // stores current value of root node
        int old = root.data;
 
        // update root to sum of left and right subtree
        root.data = left + right;
 
        // return the updated value plus old value (sum of tree rooted at root node)
        return root.data + old;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);  /* Construct below tree
                  1
               /     \
              2       3
             / \     / \
            4   5   6   7
        */
 
        convertToSumTree(root);
        preorder(root);
    }
    
}
