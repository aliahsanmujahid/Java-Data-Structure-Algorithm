
package pkg7.find.inorder.predecessor;
// Data structure to store a Binary Search Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
public class FindInorderPredecessor {
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
 
    // Helper function to find maximum value node in given BST
    public static Node findMaximum(Node root) {
        while (root.right != null) {
            root = root.right;
        }
 
        return root;
    }
 
    // Recursive function to find in-order predecessor for given key in a BST
    public static Node findPredecessor(Node root, Node prec, int key)
    {
        // base case
        if (root == null) {
            return prec;
        }
 
        // if node with key's value is found, the predecessor is maximum
        // value node in its left subtree (if any)
        if (root.data == key) {
            if (root.left != null) {
                return findMaximum(root.left);
            }
        }
 
        // if given key is less than the root node, recur for left subtree
        else if (key < root.data) {
            return findPredecessor(root.left, prec, key);
        }
 
        // if given key is more than the root node, recur for right subtree
        else {
            // update predecessor to current node before recursing 
            // in right subtree
            prec = root;
            return findPredecessor(root.right, prec, key);
        }
        return prec;
    }
 
    // main function
    public static void main(String[] args)
    {
        /* Construct below tree
                   15
                 /    \
                /      \
               10       20
              /  \     /  \
             /    \   /    \
            8     12 16    25
        */
 
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        Node root = null;
        for (int key : keys) {
            root = insert(root, key);
        }
 
        // find in-order predecessor for each key
        for (int key : keys)
        {
            Node prec = findPredecessor(root, null, key);
 
            if (prec != null) {
                System.out.println("Predecessor of node " + key + " is "
                                    + prec.data);
            } else {
                System.out.println("Predecessor doesn't exists for node "
                                    + key);
            }
        }
    }
}
