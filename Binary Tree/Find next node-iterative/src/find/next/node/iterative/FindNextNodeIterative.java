/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.next.node.iterative;

import java.util.ArrayDeque;
import java.util.Queue;
 
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
public class FindNextNodeIterative {

     // Function to find next node of given node in the same level
    // in given binary tree
    public static Node findRightNode(Node root, int val)
    {
        // return null if tree is empty
        if (root == null) {
            return null;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // pointer to store current node
        Node front;
 
        // run till queue is not empty
        while (!queue.isEmpty())
        {
            // calculate number of nodes in current level
            int size = queue.size();
 
            // process every node of current level and enqueue their
            // non-empty left and right child to queue
            while (size-- > 0)
            {
                front = queue.poll();
 
                // if desired node is found, return its next right node
                if (front.key == val)
                {
                    // if next right node doesn't exists, return null
                    if (size == 0) {
                        return null;
                    }
 
                    return queue.peek();
                }
 
                if (front.left != null) {
                    queue.add(front.left);
                }
 
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
        }
 
        return null;
    }
 
    // main function
    public static void main(String[] args) {
        /* Construct below Tree
                  1
                /  \
               /    \
              2      3
             / \      \
            4   5      6
                      / \
                     7   8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        Node right = findRightNode(root, 5);
        if (right != null) {
            System.out.print("Right Node is " + right.key);
        } else {
            System.out.print("Right Node doesn't exists");
        }
    }
}
