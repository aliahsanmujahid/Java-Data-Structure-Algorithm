
package pkg53.construct.a.height;
import java.util.ArrayList;
import java.util.List;
 
// Data structure to store a BST node
class Node {
    int data;
    Node left, right;
 
    // Constructor
    Node(int data) {
        this.data = data;
    }
};
 
public class ConstructAHeight {
    // Helper function to perform the pre-order traversal of a BST
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Recursive function to push nodes of a given binary search tree in a
    // List in in-order fashion
    public static void pushTreeNodes(Node root, List<Node> nodes)
    {
        // base case
        if (root == null) {
            return;
        }
 
        pushTreeNodes(root.left, nodes);
        nodes.add(root);
        pushTreeNodes(root.right, nodes);
    }
 
    // Recursive function to construct a height-balanced BST from
    // given nodes in sorted order
    public static Node buildBalancedBST(List<Node> nodes, int start, int end)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // find the middle index
        int mid = (start + end) / 2;
 
        // The root node will be node present at the mid index
        Node root = nodes.get(mid);
 
        // recursively construct left and right subtree
        root.left = buildBalancedBST(nodes, start, mid - 1);
        root.right = buildBalancedBST(nodes, mid + 1, end);
 
        // return root node
        return root;
    }
 
    // Function to construct a height-balanced BST from an unbalanced BST
    public static Node constructBalancedBST(Node root)
    {
        // Push nodes of a given binary search tree in a List in sorted order
        List<Node> nodes = new ArrayList<>();
        pushTreeNodes(root, nodes);
 
        // Construct a height-balanced BST from sorted BST nodes
        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(15);
        root.left.left = new Node(10);
        root.left.left.left = new Node(5);
        root.left.left.left.left = new Node(2);
        root.left.left.left.right = new Node(8);
 
        root = constructBalancedBST(root);
 
        System.out.print("Preorder Traversal of the constructed BST is: ");
        preorder(root);
    }
}
