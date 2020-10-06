
package pkg34.print.corner.nodes;
import java.util.ArrayDeque;
import java.util.Queue;
 
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}

public class PrintCornerNodes {
// Iterative function to print corner nodes of every level in binary tree
    public static void print(Node root)
    {
        // return if tree is empty
        if (root == null) {
            return;
        }
 
        // create an empty queue to store Tree nodes
        Queue<Node> q = new ArrayDeque<>();
 
        // enqueue root node
        q.add(root);
 
        // run till queue is not empty
        while (!q.isEmpty())
        {
            // get size of current level
            int size = q.size();
            int n = size;
 
            // process all nodes present in current level
            while (n-- > 0)
            {
                Node node = q.poll();
 
                // if corner node found, print it
                if (n == size - 1 || n == 0) {
                    System.out.print(node.data + " ");
                }
 
                // enqueue left and right child of current node
                if (node.left != null) {
                    q.add(node.left);
                }
 
                if (node.right != null) {
                    q.add(node.right);
                }
            }
 
            // terminate level by printing newline
            System.out.println();
        }
    }
 

    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        root.right.right.right  = new Node(10);
 
        print(root);
    }
    
}
