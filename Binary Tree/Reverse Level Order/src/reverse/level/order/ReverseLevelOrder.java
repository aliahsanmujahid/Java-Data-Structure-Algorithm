/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.level.order;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
public class ReverseLevelOrder {
 // Function to print reverse level order traversal of given binary tree
    public static void reverseLevelOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // create an stack to reverse level order nodes
        Deque<Integer> stack = new ArrayDeque<>();
 
        // pointer to store current node
        Node curr;
 
        // run till queue is not empty
        while (!queue.isEmpty())
        {
            // process each node in queue and enqueue their children
            curr = queue.poll();
 
            // push current node to stack
            stack.push(curr.key);
 
            // important - process right node before left node
            if (curr.right != null) {
                queue.add(curr.right);
            }
 
            if (curr.left != null) {
                queue.add(curr.left);
            }
        }
 
        // pop all nodes from the stack and print them
        while (!stack.isEmpty()) {
            System.out.print(stack.poll() + " ");
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
          reverseLevelOrderTraversal(root);
    }
    
}
