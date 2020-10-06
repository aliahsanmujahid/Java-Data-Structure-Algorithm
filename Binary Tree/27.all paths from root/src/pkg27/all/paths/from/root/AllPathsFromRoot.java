
package pkg27.all.paths.from.root;
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
 
public class AllPathsFromRoot {
  public static void printRootToleafPathIterative(Node root)
    {
        // create an empty stack to store a pair of tree node and
        // its path from the root node
        Deque<Pair<Node, String>> stack = new ArrayDeque<>();
 
        // push root node
        stack.add(Pair.of(root, ""));
 
        // loop till stack is not empty
        while (!stack.isEmpty())
        {
            // we pop a node from the stack and push the data to output stack
            Pair<Node, String> pair = stack.poll();
 
            // fetch current node
            Node curr = pair.first;
            String path = pair.second;
 
            // add current node to the existing path
            String separator = (path.equals("")) ? "\n" : " -> ";
            path += (separator + curr.data);
 
            // if leaf node, print the path
            if (curr.left == null && curr.right == null) {
                System.out.print(path);
            }
 
            // push left and right child of popped node to the stack
            if (curr.right != null) {
                stack.add(Pair.of(curr.right, path));
            }
 
            if (curr.left != null) {
                stack.add(Pair.of(curr.left, path));
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
              2       3
             / \     / \
            4   5   6   7
                   /     \
                  8       9
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.right.right = new Node(9);
 
        printRootToleafPathIterative(root);
    }
}
