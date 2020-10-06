/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postorder.iterative;

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
public class PostorderIterative {
// Iterative function to perform post-order traversal of the tree
public static void postorder(Node root)
{
    // create an empty stack and push root node
    Stack<Node> stack = new Stack();
    stack.push(root);
 
    // create another stack to store post-order traversal
    Stack<Integer> out = new Stack();
 
    // run till stack is not empty
    while (!stack.empty())
    {
        // we pop a node from the stack and push the data to output stack
        Node curr = stack.pop();
        out.push(curr.data);
 
        // push left and right child of popped node to the stack
        if (curr.left != null) {
            stack.push(curr.left);
        }
 
        if (curr.right != null) {
            stack.push(curr.right);
        }
    }
 
    // print post-order traversal
    while (!out.empty()) {
        System.out.print(out.pop() + " ");
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
 
       
 
       postorder(x);
    }
    
}
