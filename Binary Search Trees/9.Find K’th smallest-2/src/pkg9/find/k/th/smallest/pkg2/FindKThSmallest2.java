
package pkg9.find.k.th.smallest.pkg2;
import java.util.concurrent.atomic.AtomicInteger;
 
// Data structure to store a Binary Search Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
public class FindKThSmallest2 {
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
 
    // Function to find k'th largest element in BST
    // Here i denotes the number of nodes processed so far
    public static int kthLargest(Node root, AtomicInteger i, int k)
    {
        // base case
        if (root == null) {
            return Integer.MAX_VALUE;
        }
 
        // search in right subtree
        int left = kthLargest(root.right, i, k);
 
        // if k'th largest is found in left subtree, return it
        if (left != Integer.MAX_VALUE) {
            return left;
        }
 
        // if current element is k'th largest, return its value
        if (i.incrementAndGet() == k) {
            return root.data;
        }
 
        // else search in left subtree
        return kthLargest(root.left, i, k);
    }
 
    // Function to find k'th largest element in BST
    public static int kthLargest(Node root, int k)
    {
        // maintain index to count number of nodes processed so far
        AtomicInteger i = new AtomicInteger(0);
 
        // traverse the tree in in-order fashion and return k'th element
        return kthLargest(root, i, k);
    }
 
    // main function
    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        int k = 2;
        int res = kthLargest(root, k);
 
        if (res != Integer.MAX_VALUE) {
            System.out.print(res);
        }
        else {
            System.out.print("Invalid Input");
        }
    }
}
