package height.of.binary.tree.iterative;

import java.util.ArrayDeque;
import java.util.Queue;

class Node{
    int key;
    Node left,right;
    Node(int data){
        this.key=data;
    }
}
public class HeightOfBinaryTreeIterative {
public static int height(Node root)
    {
        // empty tree has height 0
        if (root == null) {
            return 0;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
  int size = queue.size();
        System.out.println(size);
        Node front = null;
        int height = 0;
 
        // do till queue is not empty
        while (!queue.isEmpty())
        {
            // calculate number of nodes in current level
             size = queue.size();
   System.out.println(size);
            
            // process each node of current level and enqueue their
            // non-empty left and right child to queue
            while (size-- > 0) {
                System.out.println(size);
                front = queue.poll();
 
                if (front.left != null) {
                    queue.add(front.left);
                }
 
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
 
            // increment height by 1 for each level
            height++;
        }
 
        return height;
    }
    public static void main(String[] args) {
      Node root = null;
 
        root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
 
        System.out.println("The height of the binary tree is " + height(root));
    }
    
}
