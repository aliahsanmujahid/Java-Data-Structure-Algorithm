
package pkg61.efficiently.print.all;
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
public class EfficientlyPrintAll {
    // Iterative function to print all nodes between two given
    // levels in a binary tree
    public static void printNodes(Node root, int start, int end)
    {
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // pointer to store current node
        Node curr = null;
 
        // maintains level of current node
        int level = 0;
 
        // run till queue is not empty
        while (!queue.isEmpty())
        {
            // increment level by 1
            level++;
 
            // calculate number of nodes in current level
            int size = queue.size();
 
            // process every node of current level and enqueue their
            // non-empty left and right child to queue
            while (size-- > 0)
            {
                curr = queue.poll();
 
                // print the node if its level is between given levels
                if (level >= start && level <= end)
                    System.out.print(curr.key + " ");
 
                if (curr.left != null) {
                    queue.add(curr.left);
                }
 
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
 
            if (level >= start && level <= end) {
                System.out.println();
            }
        }
    }
 
    // main function
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        root.right.right.right = new Node(30);
 
        int start = 2, end = 3;
        printNodes(root, start, end);
    }
}
