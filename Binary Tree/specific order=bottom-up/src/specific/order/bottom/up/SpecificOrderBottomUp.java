/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specific.order.bottom.up;

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
public class SpecificOrderBottomUp {

     // Utility function to add an element to List corresponding to the given key
    // in a Map<Integer,List<Integer>>.
    public static void insertIntoMultiMap(Map<Integer,List<Integer>> map,
                                          Integer key, Integer value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }
 
    // Function to print all nodes of a given binary tree in
    // specific order from bottom to top
    public static void printNodes(Node root)
    {
        // return is tree is empty
        if (root == null) {
            return;
        }
 
        // start with level 1 (of root node)
        int level = 1;
 
        // create an empty multi-map of integers (every key can be
        // associated with multiple values)
        Map<Integer, List<Integer>> map = new HashMap<>();
 
        // insert root node at first level
        insertIntoMultiMap(map, level, root.key);
 
        // create an two empty queues and enqueue root's left and
        // right child respectively
        Queue<Node > Q1 = new ArrayDeque<>(), Q2 = new ArrayDeque<>();
        Q1.add(root.left);
        Q2.add(root.right);
 
        // run till queue is not empty
        while (!Q1.isEmpty())
        {
            // increment level by 1
            level++;
 
            // calculate number of nodes in current level
            int n = Q1.size();
 
            // process every node of current level
            while (n-- > 0)
            {
                // pop front node from first queue and insert it into the map
                Node x = Q1.poll();
                insertIntoMultiMap(map, level, x.key);
 
                // push left and right child of x to first queue
                if (x.left != null) {
                    Q1.add(x.left);
                }
 
                if (x.right != null) {
                    Q1.add(x.right);
                }
 
                // pop front node from second queue and insert it into the map
                Node y = Q2.poll();
 
                map.get(level).add(y.key);
 
                // push right and left child of y to second queue
                if (y.right != null) {
                    Q2.add(y.right);
                }
 
                if (y.left != null) {
                    Q2.add(y.left);
                }
            }
        }
 
        // iterate through the HashMap and print all nodes present in very level
        for (int i = map.size(); i > 0; i--) {
            System.out.print(map.get(i));
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
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
 
        printNodes(root);
    }
    
}
