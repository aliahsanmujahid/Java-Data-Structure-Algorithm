
package pkg2.search.given.key.pkg2;
// Data structure to store a Binary Search Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
public class SearchGivenKey2 {
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
     // Iterative function to search in given BST
    public static void searchIterative(Node root, int key) {
        // start with root node
        Node curr = root;
 
        // pointer to store parent node of current node
        Node parent = null;
 
        // traverse the tree and search for the key
        while (curr != null && curr.data != key)
        {
            // update parent node as current node
            parent = curr;
 
            // if given key is less than the current node, go to left subtree
            // else go to right subtree
            if (key < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
 
        // if key is not present in the key
        if (curr == null) {
            System.out.print("Key Not found");
            return;
        }
 
        if (parent == null) {
            System.out.print("The node with key " + key + " is root node");
        }
        else if (key < parent.data) {
            System.out.print("Given key is left node of node with key "
                            + parent.data);
        }
        else {
            System.out.print("Given key is right node of node with key "
                            + parent.data);
        }
    }
 
    // Search given key in BST
    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        searchIterative(root, 25);
    }
}
