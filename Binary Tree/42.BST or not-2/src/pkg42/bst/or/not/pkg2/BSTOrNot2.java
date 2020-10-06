
package pkg42.bst.or.not.pkg2;

// Data structure to store a Binary Search Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
public class BSTOrNot2 {
  // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
 
        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
 
    // Function to perform inorder traversal of the given binary tree and
    // check if it is a BST or not. Here prev is previous processed node
    public static boolean isBST(Node root, Node prev)
    {
        // base case: empty tree is a BST
        if (root == null) {
            return true;
        }
 
        // check if left subtree is BST or not
        boolean left = isBST(root.left, prev);
 
        // value of current node should be more than that of previous node
        if (root.data <= prev.data) {
            return false;
        }
 
        // update previous node data and check if right subtree is BST or not
        prev.data = root.data;
 
        return left && isBST(root.right, prev);
    }
 
    // Function to determine if given Binary Tree is a BST or not
    public static void isBST(Node node)
    {
        // pointer to store previous processed node in inorder traversal
        Node prev = new Node(Integer.MIN_VALUE);
 
        // check if nodes are nodes are processed in sorted order
        if (isBST(node, prev)) {
            System.out.println("This is a BST.");
        } else {
            System.out.println("This is NOT a BST!");
        }
    }
 
    private static void swap(Node root) {
        Node left = root.left;
        root.left = root.right;
        root.right = left;
    }
 
   // main function
    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        // swap nodes
        swap(root);
        isBST(root);
    }
}
