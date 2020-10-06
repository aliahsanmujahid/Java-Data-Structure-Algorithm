
package pkg21.build.a.binary.search;
// Class to store a Binary Tree node
class Node
{
    int key;
    Node left, right;
 
    Node(int key) {
        this.key = key;
    }
};
 
public class BuildABinarySearch {

     // Recursive function to perform inorder traversal of a binary tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
 
    // Recursive function to build a BST from a preorder sequence
    public static Node constructBST(int[] preorder, int start, int end)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // Construct the root node of the sub-tree formed by keys of the
        // preorder sequence in range [start, end]
        Node node = new Node(preorder[start]);
 
        // search the index of first element in current range of preorder
        // sequence which is larger than the value of root node
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.key) {
                break;
            }
        }
 
        // recursively construct the left sub-tree
        node.left = constructBST(preorder, start + 1, i - 1);
 
        // recursively construct the right sub-tree
        node.right = constructBST(preorder, i, end);
 
        // return current node
        return node;
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
 
        int[] preorder = { 15, 10, 8, 12, 20, 16, 25 };
 
        // construct the BST
        Node root = constructBST(preorder, 0, preorder.length - 1);
 
        // print the BST
        System.out.print("Inorder Traversal of BST is : ");
 
        // inorder on the BST always returns a sorted sequence
        inorder(root);
    }
}
