
package pkg48.maximum.width;
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
public class MaximumWidth {

    // Function to find maximum width of the tree using level order
    // traversal of given binary tree
    public static void maxWidth(Node root)
    {
        // return if tree is empty
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // pointer to store current node
        Node curr = null;
 
        // stores maximum width
        int max = 0;
 
        // run till queue is not empty
        while (!queue.isEmpty())
        {
            // calculate number of nodes in current level
            // This is equal to width of current level
            int width = queue.size();
 
            // update maximum width if number of nodes in current level
            // is more than maximum width found so far
            if (max < width) {
                max = width;
            }
 
            // process every node of current level and enqueue their
            // non-empty left and right child to queue
            while (width-- > 0)
            {
                curr = queue.poll();
 
                if (curr.left != null) {
                    queue.add(curr.left);
                }
 
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
 
        System.out.print("Maximum width is " + max);
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
 
        maxWidth(root);
    }
}