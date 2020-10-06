
package pkg22.find.a.triplet;
import java.util.ArrayList;
import java.util.List;
 
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
 
public class FindATriplet {

    // Function to insert a given key at its correct position in BST
    public static Node insert(Node root, int data)
    {
        if (root == null) {
            return new Node(data);
        }
 
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        else {
            root.right = insert(root.right, data);
        }
 
        return root;
    }
 
    // Function to find a triplet in a List with given sum
    // If a triplet is found, the function stores it in the tuple and returns true
    public static Tuple findTriplet(List<Integer> arr, int sum)
    {
        // get number of nodes in the BST
        int n = arr.size()
                ;
 
        // check if triplet is formed by arr[i] and a pair from arr[i+1..n-1]
        for (int i = 0; i <= n - 3; i++)
        {
            // remaining sum
            int k = sum - arr.get(i);
 
            // maintain two indices pointing to end-points of the arr[i+1..n-1]
            int low = i + 1, high = n - 1;
 
            // loop till low is less than high
            while (low < high)
            {
                // increment low index if total is less than the remaining sum
                if (arr.get(low) + arr.get(high) < k) {
                    low++;
                }
 
                // decrement high index is total is more than the remaining sum
                else if (arr.get(low) + arr.get(high) > k) {
                    high--;
                }
 
                // triplet with given sum found
                else {
                    // create a tuple of the found triplet and return it
                    return Tuple.of(arr.get(i), arr.get(low), arr.get(high));
                }
            }
        }
 
        // no triplet found
        return null;
    }
 
    // Recursive function to push keys of a given BST in a List in inorder fashion
    public static void pushTreeNodes(Node root, List<Integer> keys)
    {
        // base case
        if (root == null) {
            return;
        }
 
        pushTreeNodes(root.left, keys);
        keys.add(root.data);
        pushTreeNodes(root.right, keys);
    }
 
    // Function to print a triplet with given sum in the given BST
    public static void printTriplet(Node root, int sum)
    {
        /* 1. Push keys of a given BST in a List in sorted order */
        List<Integer> keys = new ArrayList<>();
        pushTreeNodes(root, keys);
 
        /* 2: Find a triplet with given sum in the List */
 
        // create a tuple to store the triplet
        Tuple<Integer, Integer, Integer> triplet = findTriplet(keys, sum);
 
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
 
        // print a triplet with given sum
        printTriplet(root, sum);
    }
}
