
package pkg35.binary.tree.to.doubly.pkg3;

// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
public class BinaryTreeToDoubly3 {
// Wrapper over the Node class
    static class NodeWrapper {
        public Node node;
 
        NodeWrapper(Node node) {
            this.node = node;
        }
    }
 
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
 
    // root -> current node
    // head -> head of the doubly linked list (Passed by reference)
    // prev -> previous processed node (Passed by reference)
    public static Node convert(Node curr, Node head, NodeWrapper prev)
    {
        // base case: tree is empty
        if (curr == null) {
            return head;
        }
 
        // recursively convert left subtree first
        head = convert(curr.left, head, prev);
 
        // adjust pointers
        if (prev.node != null)
        {
            // set current node's left child to prev
            curr.left = prev.node;
 
            // make prev's right child as curr
            prev.node.right = curr;
        }
 
        // if prev is null, then update head of DLL as this is first node in inorder
        else {
            head = curr;
        }
 
        // after current node is visited, update previous pointer to current node
        prev.node = curr;
 
        // recursively convert right subtree
        return convert(curr.right, head, prev);
    }
 
    // in-place convert given Binary Tree to a Doubly Linked List
    public static Node convert(Node root)
    {
        // prev - keep track of previous processed node in inorder traversal
        Node prev = null;
 
        // Wrap prev node so it's reference can be changed inside convert() method
        NodeWrapper _prev = new NodeWrapper(prev);
 
        // convert above binary tree to DLL (using inorder traversal)
        return convert(root, root, _prev);
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
 
        // root is now head of doubly linked list
 
        // print list
        printDLL(root);
    }
    
}
