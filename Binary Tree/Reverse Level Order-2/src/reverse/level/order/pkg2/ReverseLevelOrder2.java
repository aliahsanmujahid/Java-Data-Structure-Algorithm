/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.level.order.pkg2;
import java.util.*;
 
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
public class ReverseLevelOrder2 {

  // Utility function to add an element to List corresponding to the given key
    // in a Map<Integer,List<Integer>>.
    public static void insertIntoMultiMap(Map<Integer,List<Integer>> map,
                                          Integer key, Integer value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }
 
    // traverse the tree in pre-order fashion and store nodes into the map
    // corresponding to their level
    public static void preorder(Node root, int level, Map<Integer, List<Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // insert current node and its level into the map
        insertIntoMultiMap(map, level, root.key);
 
        // recur for left and right subtree by increasing level by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }
 
    // Recursive function to do reverse level order traversal of given binary tree
    public static void reverseLevelOrderTraversal(Node root)
    {
        // create an empty map to store nodes between given levels
        Map<Integer, List<Integer>> map = new HashMap<>();
 
        // traverse the tree and insert its nodes into the map
        // corresponding to the their level
        preorder(root, 1, map);
 
        // iterate through the map in reverse order and 
        // print all nodes present in very level
        for (int i = map.size(); i > 0; i--) {
            System.out.println("Level " + i + ": " + map.get(i));
        }
    }
    public static void main(String[] args) {
            Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
          reverseLevelOrderTraversal(root);
    }
    
}
