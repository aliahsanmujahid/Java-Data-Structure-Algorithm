/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottom.view;
import java.util.Map;
import java.util.TreeMap;
 
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
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
public class BottomView {
 // Recursive function to do a pre-order traversal of the tree and fill the map
    // Here node has 'dist' horizontal distance from the root of the
    // tree and level represent level of the node
 
    public static void printBottom(Node root, int dist, int level,
                                   Map<Integer, Pair<Integer, Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // if current level is more than or equal to maximum level seen so far
        // for the same horizontal distance or horizontal distance is seen for
        // the first time, update the map
 
        if (!map.containsKey(dist) || level >= map.get(dist).second)
        {
            // update value and level for current distance
            map.put(dist, Pair.of(root.key, level));
        }
 
        // recur for left subtree by decreasing horizontal distance and
        // increasing level by 1
        printBottom(root.left, dist - 1, level + 1, map);
 
        // recur for right subtree by increasing both level and
        // horizontal distance by 1
        printBottom(root.right, dist + 1, level + 1, map);
    }
 
    // Function to print the bottom view of given binary tree
    public static void printBottom(Node root)
    {
        // create a TreeMap where
        // key -> relative horizontal distance of the node from root node and
        // value -> pair containing node's value and its level
 
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
 
        // do pre-order traversal of the tree and fill the map
        printBottom(root, 0, 0, map);
 
        // traverse the TreeMap and print bottom view
        for (Pair<Integer, Integer> it: map.values()) {
            System.out.print(it.first + " ");
        }
    }
 
    // main function
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        printBottom(root);
    }
}
