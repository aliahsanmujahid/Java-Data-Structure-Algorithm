
package subtree.of.another.binary.tree;
import java.util.ArrayList;
import java.util.List;
 
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
public class SubtreeOfAnotherBinaryTree {
 // Function to store in-order traversal of the tree in a list
    public static void inorder(Node node, List<Node> list)
    {
        if (node == null) {
            return;
        }
 
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }
 
    // Function to store post-order traversal of the tree in a list
    public static void postorder(Node node, List<Node> list)
    {
        if (node == null) {
            return;
        }
 
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node);
    }
 
    // Function to check if given binary tree is a subtree of another
    // binary tree or not
    public static boolean checkSubtree(Node tree, Node subtree)
    {
        // base case: both trees are same
        if (tree == subtree) {
            return true;
        }
 
        // base case: if first tree is empty but second tree is non-empty
        if (tree == null) {
            return false;
        }
 
        // store in-order traversal of both trees in v1 and v2 respectively
        List<Node> first = new ArrayList<>(), second = new ArrayList<>();
        inorder(tree, first);
        inorder(subtree, second);
 
        // return false if second list is not a sub-list of first list
        if (first.toString().contains(second.toString())) {
            return false;
        }
 
        // reset both lists
        first.clear();
        second.clear();
 
        // Now store post-order traversal of both trees in v1 and v2 respectively
        postorder(tree, first);
        postorder(subtree, second);
 
        // return false if second list is not a sub-list of first list
        if (first.toString().contains(second.toString())) {
            return false;
        }
 
        return true;
    }
 
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (checkSubtree(root, root.right)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }
    
}
