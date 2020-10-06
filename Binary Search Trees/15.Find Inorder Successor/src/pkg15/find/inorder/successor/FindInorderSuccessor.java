
package pkg15.find.inorder.successor;
// Data structure to store a Binary Search Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
public class FindInorderSuccessor {
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
 
 
    // Helper function to find minimum value node in given BST
    public static Node findMinimum(Node root)
    {
        while (root.left != null) {
            root = root.left;
        }
 
        return root;
    }
 
    // Recursive function to find inorder successor for given key in a BST
    public static Node findSuccessor(Node root, Node succ, int key)
    {
        // base case
        if (root == null) {
            return null;
        }
 
        // if node with key's value is found, the successor is minimum
        // value node in its right subtree (if any)
        if (root.data == key)
        {
            if (root.right != null) {
                return findMinimum(root.right);
            }
        }
 
        // if given key is less than the root node, recur for left subtree
        else if (key < root.data)
        {
            // update successor to current node before recursing in 
            // left subtree
            succ = root;
            return findSuccessor(root.left, succ, key);
        }
 
        // if given key is more than the root node, recur for right subtree
        else {
            return findSuccessor(root.right, succ, key);
        }
 
        return succ;
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
 
        // find in-order successor for each key
        for (int key : keys)
        {
            Node prec = findSuccessor(root, null, key);
 
            if (prec != null) {
                System.out.println("Successor of node " + key + " is "
                                    + prec.data);
            } else {
                System.out.println("Successor doesn't exists for node "
                                    + key);
            }
        }
    }
}
