
package pkg20.build.a.binary.search.pkg2;
import java.util.concurrent.atomic.AtomicInteger;
 
// class to store a Binary Tree node
class Node {
    int data;
    Node left, right;
 
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
};
public class BuildABinarySearch2 {
  // Function to print the inorder traversal of a binary tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Recursive function to build a binary search tree from
    // its postorder sequence
    public static Node buildTree(int[] postorder, AtomicInteger pIndex,
                                 int min, int max)
    {
        // Base case
        if (pIndex.get() < 0) {
            return null;
        }
 
        // Return if next element of postorder traversal from the end
        // is not in valid range
        int curr = postorder[pIndex.get()];
        if (curr < min || curr > max) {
            return null;
        }
 
        // Construct the root node and decrement pIndex
        Node root = new Node(curr);
        pIndex.decrementAndGet();
 
        // Construct left and right subtree of the root node.
        // Build right subtree before left subtree since the values are
        // being read from the end of the postorder sequence
 
        // Since all elements in the right subtree of a BST must be greater
        // than the value of root node, set range as [curr+1..max] and recur
        root.right = buildTree(postorder, pIndex, curr + 1, max);
 
        // Since all elements in the left subtree of a BST must be less
        // than the value of root node, set range as [min, curr-1] and recur
        root.left = buildTree(postorder, pIndex, min, curr - 1);
 
        return root;
    }
 
    // Build a binary search tree from its postorder sequence
    public static Node buildTree(int[] postorder)
    {
        // start from the root node (last element in postorder sequence)
        AtomicInteger postIndex = new AtomicInteger(postorder.length - 1);
 
        // set range of the root node as [Integer.MIN_VALUE, Integer.MAX_VALUE] and recur
        return buildTree(postorder, postIndex, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
 
    public static void main(String[] args)
    {
        /* Construct below BST
                  15
                /    \
               /      \
              10       20
             /  \     /  \
            /    \   /    \
           8     12 16    25
        */
 
        // postorder traversal of BST
        int[] postorder = { 8, 12, 10, 16, 25, 20, 15 };
 
        // construct the BST
        Node root = buildTree(postorder);
 
        // print the BST
        System.out.print("Inorder Traversal of BST is : ");
 
        // inorder on the BST always returns a sorted sequence
        inorder(root);
    }
}
