
package pkg7.find.inorder.predecessor.pkg2;
// Data structure to store a Binary Search Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
public class FindInorderPredecessor2 {
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
    public static Node findMaximum(Node root)
    {
        while (root.right!= null) {
            root = root.right;
        }
 
        return root;
    }
 
    // Iterative function to find in-order predecessor for given key in a BST
    public static Node findPredecessor(Node root, int key)
    {
        Node prec = null;
 
        while (true)
        {
            // if given key is less than the root node, visit left subtree
            if (key < root.data) {
                root = root.left;
            }
 
            // if given key is more than the root node, visit right subtree
            else if (key > root.data)
            {
                // update predecessor to current node before visiting
                // right subtree
                prec = root;
                root = root.right;
            }
 
            // if node with key's value is found, predecessor is maximum
            // value node in its left subtree (if any)
            else
            {
                if (root.left!= null) {
                    prec = findMaximum(root.left);
                }
                break;
            }
            
            // if key doesn't exist in binary tree
            if (root == null)
                return null;
        }
 
        // return predecessor if any
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
            Node prec = findPredecessor(root, key);
 
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
