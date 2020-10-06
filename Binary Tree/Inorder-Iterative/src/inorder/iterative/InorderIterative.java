
package inorder.iterative;
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
public class InorderIterative {
// Recursive function to perform in-order traversal of the tree
public static void inorder(Node root)
{
    // create an empty stack
    Stack<Node> stack = new Stack();
 
    // start from root node (set current node to root node)
    Node curr = root;
 
    // if current node is null and stack is also empty, we're done
    while (!stack.empty() || curr != null)
    {
        // if current node is not null, push it to the stack (defer it)
        // and move to its left child
        if (curr != null)
        {
            stack.push(curr);
            curr = curr.left;
        }
        else
        {
            // else if current node is null, we pop an element from stack,
            // print it and finally set current node to its right child
            curr = stack.pop();
            System.out.print(curr.data + " ");
 
            curr = curr.right;
        }
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
 
       
 
       inorder(x);
    }
    
}
