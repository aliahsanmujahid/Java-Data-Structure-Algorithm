
package pkg47.iteratively.print.leaf.to.root.path.pkg2;
import java.util.ArrayDeque;
import java.util.Deque;
 
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 // Pair class
class Pair<U, V>
{
    public final U first;       // first field of a Pair
    public final V second;      // second field of a Pair
 
    // Constructs a new Pair with specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }
 
    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}
public class IterativelyPrintLeafToRootPath2 {

    // Function to check if given node is a leaf node or not
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
 
    public static void printLeafToRootPaths(Node root)
    {
        // create an empty stack to store a pair of tree node and
        // its path from the root node
        Deque<Pair<Node, String>> stk = new ArrayDeque<>();
 
        // push root node
        stk.add(Pair.of(root, ""));
 
        // loop till stack is not empty
        while (!stk.isEmpty())
        {
            // we pop a node from the stack and push the data to output stack
            Pair<Node, String> p = stk.poll();
 
            // fetch current node
            Node curr = p.first;
            String path = p.second;
 
            // add current node to the existing path
            String delim = (path.equals("")) ? "\n" : " -> ";
            String rootToNodePath = curr.data + delim + path;
 
            // if leaf node, print the path
            if (isLeaf(curr)) {
                System.out.print(rootToNodePath);
            }
 
            // push left and right child of popped node to the stack
            if (curr.right != null) {
                stk.add(Pair.of(curr.right, rootToNodePath));
            }
 
            if (curr.left != null) {
                stk.add(Pair.of(curr.left, rootToNodePath));
            }
        }
    }
 
    // main function
    public static void main(String[] args)
    {
        /* Construct below tree
                   1
                 /   \
                /     \
               /       \
              2         3
             / \       / \
            /   \     /   \
           4     5   6     7
                    / \
                   /   \
                  8     9
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
 
        printLeafToRootPaths(root);
    }
}
