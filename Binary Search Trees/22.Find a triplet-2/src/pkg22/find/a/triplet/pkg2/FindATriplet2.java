
package pkg22.find.a.triplet.pkg2;
// Data structure to store a BST node
class Node
{
    // value of node
    int data;
 
    // left and right child pointer for the BST node
    Node left, right;
 
    // Constructor
    Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
};
 
// Tuple class
class Tuple<X,Y,Z>
{
    public final X first;        // first field of a Tuple
    public final Y second;         // second field of a Tuple
    public final Z third;         // third field of a Tuple
 
    // Constructs a new Tuple with specified values
    private Tuple(X first, Y second, Z third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
 
    // Factory method for creating a Typed Tuple immutable instance
    public static <X,Y,Z> Tuple <X,Y,Z> of(X a, Y b, Z c)
    {
        // calls private constructor
        return new Tuple<>(a, b, c);
    }
}
public class FindATriplet2 {
   // Wrapper over the Node class
    static class NodeWrapper {
        public Node node = null;
    }
 
    // Function to insert a given key at its correct position in BST
    public static Node insert(Node root, int data)
    {
        if (root == null) {
            return new Node(data);
        }
 
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
 
        return root;
    }
 
    // Function to insert a BST node at the front of a doubly linked list
    public static Node push(Node node, Node head, NodeWrapper tail)
    {
        // update the right pointer of the given node to point to the current head
        node.right = head;
 
        // update the left pointer of the existing head node of the doubly linked list
        // to point to the new node
        if (head != null) {
            head.left = node;
        }
 
        // update the tail pointer of doubly linked list (updated only for the first node)
        if (tail.node == null) {
            tail.node = node;
        }
 
        // finally update and return the head pointer of doubly linked list
        head = node;
        return head;
    }
 
    /*
    Recursive function to construct a sorted doubly linked list from a given BST
        root : Pointer to the root node of the BST
        head : Reference to the head node of the doubly linked list
        tail : Reference to the last node of the doubly linked list
    */
    public static Node convertBSTtoDLL(Node root, Node head, NodeWrapper tail)
    {
        // Base case
        if (root == null) {
            return head;
        }
 
        // recursively convert the right subtree
        head = convertBSTtoDLL(root.right, head, tail);
 
        // push current node at the front of the doubly linked list
        head = push(root, head, tail);
 
        // recursively convert the left subtree
        head = convertBSTtoDLL(root.left, head, tail);
 
        return head;
    }
 
    // Returns true if a triplet with given sum is found in the given BST
    public static Tuple findTriplet(Node root, int sum)
    {
        /* 1. Convert the given BST into a sorted DLL */
 
        Node head = null;
 
        // Wrap tail node so it's reference can be changed inside push() method
        NodeWrapper tail = new NodeWrapper();
        head = convertBSTtoDLL(root, head, tail);
 
        /* 2: Find triplet with given sum in DLL */
 
        // loop till only 2 nodes are left
        while (head!= null && head.right != tail.node)
        {
            // Assuming current head node is part of the triplet, find other two nodes
            // of the triplet in search space [head.right, tail]
 
            // maintain two pointers pointing to end-points of the search space
            Node start = head.right;
            Node end = tail.node;
 
            // calculate the remaining sum
            int pairSum = sum - head.data;
 
            // reduce the search space [start, end] at each iteration of the loop
            while (start != end)
            {
                // get sum of the current start and end nodes
                int currSum = start.data + end.data;
 
                // if pair with desired sum is found in the BST
                if (currSum == pairSum)
                {
                    // create a tuple from the triplet and return true
                    return Tuple.of(head.data, start.data, end.data);
                }
 
                // if current sum is more than the desired sum, move left in the list
                else if (currSum > pairSum) {
                    end = end.left;
                }
 
                // if current sum is less than the desired sum, move right in the list
                else {
                    start = start.right;
                }
            }
 
            // move to the next node
            head = head.right;
        }
 
        // no triplet found
        return null;
    }
 
    public static void main(String[] args)
    {
        // input keys to construct a BST
        int[] keys = { 10, -15, 3, -40, 20, 15, 50 };
 
        // construct a BST from keys[]
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
 
        // triplet sum
        int sum = 20;
 
        // create a tuple to store the triplet
        Tuple<Integer, Integer, Integer> triplet = findTriplet(root, sum);
 
        // find the triplet
        if (triplet != null)
        {
            System.out.print("Triplet found: ("
                                    + triplet.first + ", "
                                    + triplet.second + ", "
                                    + triplet.third + ")");
        }
        else {
            System.out.print("Triplet not found");
        }
    }
}
