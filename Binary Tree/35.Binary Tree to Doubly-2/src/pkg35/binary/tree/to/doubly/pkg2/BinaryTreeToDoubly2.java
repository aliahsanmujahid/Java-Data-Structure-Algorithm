/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg35.binary.tree.to.doubly.pkg2;

// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
public class BinaryTreeToDoubly2 {
 // Helper function to print given doubly linked list
    public static void printDLL(Node head)
    {
        Node curr = head;
        while (curr != null)
        {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
 
    // Function to in-place convert given Binary Tree to a Doubly Linked List
    // by doing reverse inorder traversal
    public static Node convert(Node root, Node head)
    {
        // base case: tree is empty
        if (root == null) {
            return head;
        }
 
        // recursively convert right subtree first
        head = convert(root.right, head);
 
        // insert current node in the beginning of DLL
        root.right = head;
 
        if (head != null) {
            head.left = root;
        }
 
        head = root;
 
        // recursively convert left subtree
        return convert(root.left, head);
    }
 
    // in-place convert given Binary Tree to a Doubly Linked List
    public static Node convert(Node root)
    {
        // head of doubly linked list
        Node head = null;
 
        // convert above binary tree to DLL
        return convert(root, head);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        root = convert(root);
 
        // print list
        printDLL(root);
    }
    
}
