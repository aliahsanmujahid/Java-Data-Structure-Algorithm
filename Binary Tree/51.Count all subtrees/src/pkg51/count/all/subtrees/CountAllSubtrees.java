
package pkg51.count.all.subtrees;
import java.util.concurrent.atomic.AtomicInteger;
 
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
public class CountAllSubtrees {
 // Helper function to count all subtrees having same value of nodes
    // The function returns the value of the root node if all nodes in subtree
    // rooted at root have same values, else it returns infinity
    // Here count stores the result and it is passed by reference
    public static int countSubtrees(Node root, AtomicInteger count)
    {
        // base case: empty tree
        if (root == null)
            return Integer.MIN_VALUE;
 
        // if root is a leaf node, increase the count and return root node data
        if (root.left == null && root.right == null)
        {
            count.incrementAndGet();
            return root.data;
        }
 
        // recur for left subtree and right subtree
        int left = countSubtrees(root.left, count);
        int right = countSubtrees(root.right, count);
 
        // 1. left subtree is empty & right subtree data matches with root
        // 2. right subtree is empty & left subtree data matches with root
        // 3. both left & right subtree are non-empty & their data matches with root
 
        if ((left == Integer.MIN_VALUE && right == root.data) ||
                    (right == Integer.MIN_VALUE && left == root.data) ||
                    (left == right && left == root.data))
        {
            // increase the count and return root node data
            count.incrementAndGet();
            return root.data;
        }
 
        // return infinity if root's data doesn't match with left or right subtree
        return Integer.MAX_VALUE;
    }
 
    // Main function to count all subtrees having same value of nodes
    public static int countSubtrees(Node root)
    {
        // Using AtomicBoolean as Integer is passed by value in Java
        AtomicInteger count = new AtomicInteger(0);
        countSubtrees(root, count);
 
        return count.get();
    }
 
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.left.right = new Node(5);
        root.right.right.right = new Node(7);
 
        System.out.print(countSubtrees(root));
    }
    
}
