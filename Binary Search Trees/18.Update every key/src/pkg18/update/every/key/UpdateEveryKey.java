
package pkg18.update.every.key;

// Class to store a Binary Search Tree node
class Node {
    int data;
    Node left, right;
 
    Node(int data) {
        this.data = data;
    }
};
public class UpdateEveryKey {
   // Function to perform in-order traversal of the tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
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
 
    // Helper function to return sum of all nodes present in a binary tree
    public static int findSum(Node root)
    {
        if (root == null) {
            return 0;
        }
 
        return root.data + findSum(root.left) + findSum(root.right);
    }
 
    // Function to modify the BST such that every key is updated to
    // contain sum of all greater keys
    public static int update(Node root, int sum)
    {
        // base case
        if (root == null) {
            return sum;
        }
 
        // update the left subtree
        sum = update(root.left, sum);
 
        // modify the sum to contain sum of all greater keys
        sum = sum - root.data;
 
        // update the root to contain sum of all greater keys
        root.data += sum;
 
        // update the right subtree
        sum = update(root.right, sum);
 
        return sum;
    }
 
    public static void main(String[] args)
    {
        Node root = null;
        /* Construct below tree
                   5
                 /   \
                /     \
               3       8
              / \     / \
             /   \   /   \
            2    4  6     10
        */
 
        int[] keys = { 5, 3, 2, 4, 6, 8, 10 };
        for (int key : keys) {
            root = insert(root, key);
        }
 
        int sum = findSum(root);
        update(root, sum);
        inorder(root);
    }
}
