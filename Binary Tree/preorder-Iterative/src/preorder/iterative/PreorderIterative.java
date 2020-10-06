
package preorder.iterative;
// Data structure to store a Binary Tree node

import java.util.Stack;

class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int key) {
        this.data = key;
    }
}
public class PreorderIterative {
// Iterative function to perform pre-order traversal of the tree
public static void preorder(Node root)
{
    // return if tree is empty
    if (root == null) {
        return;
    }
 
    // create an empty stack and push root node
    Stack<Node> stack = new Stack();
    stack.push(root);
 
    // run till stack is not empty
    while (!stack.empty())
    {
        // pop a node from the stack and print it
        Node curr = stack.pop();
 
        System.out.print(curr.data + " ");
 
        // push right child of popped node to the stack
        if (curr.right != null) {
            stack.push(curr.right);
        }
 
        // push left child of popped node to the stack
        if (curr.left != null) {
            stack.push(curr.left);
        }
 
        // important note - right child is pushed first so that left child
        // is processed first (FIFO order)
    }
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
