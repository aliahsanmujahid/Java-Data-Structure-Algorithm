
package pkg35.convert.given.binary.tree;
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
public class ConvertGivenBinaryTree {

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
    // by doing normal inorder traversal
    public static Node convert(Node root, Node head)
    {
        // base case: tree is empty
        if (root == null) {
            return head;
        }
 
        // recursively convert left subtree first
        head = convert(root.left, head);
 
        // store right child
        Node right = root.right;
 
        // insert current node in the beginning of DLL
        root.right = head;
        if (head != null) {
            head.left = root;
        }
 
        head = root;
 
        // recursively convert right subtree
        return convert(right, head);
    }
 
    // Function to reverse a doubly linked list
    public static Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
 
        while (current != null)
        {
            // swap current.left with current.right
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;
 
            prev = current;
            current = current.left;
        }
 
        return prev;
    }
 
    // Main function to in-place convert given Binary Tree to a Doubly Linked List
    public static void convert(Node root)
    {
        // head of doubly linked list
        Node head = null;
 
        // convert above binary tree to DLL
        head = convert(root, head);
 
        // reverse the linked list
        head = reverse(head);
 
        // print list
        printDLL(head);
    }
 
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        convert(root);
    }
    
}
