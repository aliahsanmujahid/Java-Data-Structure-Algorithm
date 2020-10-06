
package pkg38.calculate.height;
// Data structure for binary tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
public class CalculateHeight {
  // Recursive function to calculate height of a binary tree with
    // leaf nodes forming a circular doubly linked list
    public static int height(Node node)
    {
        // base case: if node is null
        if (node == null) {
            return 0;
        }
 
        // node is a leaf if its left's right and its right's left
        // are pointing to the node itself
        if ((node.left != null && node.left.right == node) &&
                    (node.right != null  && node.right.left == node)) {
            return 1;
        }
 
        // recur for left and right subtree and consider maximum depth
        return 1 + Math.max(height(node.left), height(node.right));
    }
 
    // main function
    public static void main(String[] args)
    {
        // construct the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);         // leaf node
        root.right.right = new Node(6);        // leaf node
        root.left.left.left = new Node(7);    // leaf node
 
        // construct circular doubly linked list from leaves
        Node L1 = root.left.left.left;
        Node L2 = root.left.right;
        Node L3 = root.right.right;
 
        // set previous and next pointers of the linked list
        // (left and right pointer of binary tree node respectively)
        L1.left = L3;
        L1.right = L2;
 
        L2.left = L1;
        L2.right = L3;
 
        L3.left = L2;
        L3.right = L1;
 
        System.out.println("The height of given binary tree is " + height(root));
    } 
}
