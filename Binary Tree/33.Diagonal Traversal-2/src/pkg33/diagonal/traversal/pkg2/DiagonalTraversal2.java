
package pkg33.diagonal.traversal.pkg2;
import java.util.*;
 
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
public class DiagonalTraversal2 {
// Iterative function to print the diagonal elements of given binary tree
    public static void diagonalPrint(Node root)
    {
        // create an empty queue
        Queue<Node> q = new ArrayDeque<>();
 
        // create a sentinel (dummy) node to denote end of a diagonal
        Node sentinel = new Node(-1);
 
        // enqueue all nodes of first diagonal in binary tree
        while (root != null) {
            q.add(root);
            root = root.right;
        }
 
        // enqueue sentinel node at the end of each diagonal
        q.add(sentinel);
 
        // run till only sentinel is left
        while (q.size() != 1)
        {
            // dequeue front node
            Node front = q.poll();
 
            if (front != sentinel)
            {
                // print current node
                System.out.print(front.data + " ");
 
                // enqueue nodes of next diagonal in binary tree
                Node node = front.left;
                while (node != null)
                {
                    q.add(node);
                    node = node.right;
                }
            }
            else
            {
                // if end of current diagonal is reached, enqueue sentinel node
                // and print newline
                q.add(sentinel);
                System.out.println();
            }
        }
    }
 
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        diagonalPrint(root);
    }
    
}
