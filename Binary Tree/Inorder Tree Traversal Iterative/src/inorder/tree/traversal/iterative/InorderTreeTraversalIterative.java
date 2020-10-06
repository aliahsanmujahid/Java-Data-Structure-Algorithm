/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inorder.tree.traversal.iterative;

// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int key) {
        this.data = key;
    }
}
 
public class InorderTreeTraversalIterative {
// Recursive function to perform in-order traversal of the tree
public static void inorder(Node root)
{
    // return if the current node is empty
    if (root == null) {
        return;
    }
 
    // Traverse the left subtree
    inorder(root.left);
 
    // Display the data part of the root (or current node)
    System.out.print(root.data + " ");
 
    // Traverse the right subtree
    inorder(root.right);
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
 
       
 
       inorder(x);
    }
    
}
