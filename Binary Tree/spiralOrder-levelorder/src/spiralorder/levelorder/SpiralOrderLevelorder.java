/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiralorder.levelorder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
public class SpiralOrderLevelorder {

    // traverse the tree in pre-order fashion and store nodes into the map
    // corresponding to their level
    public static void preorder(Node root, int level, Map<Integer, Deque<Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // insert current node and its level into the map
        if (!map.containsKey(level)) {
            map.put(level, new ArrayDeque<>());
        }
 
        // if level is odd insert at back, else insert at front
        if (level % 2 == 1) {
            map.get(level).addLast(root.key);
        } else {
            map.get(level).addFirst(root.key);
        }
 
        // recur for left and right subtree by increasing level by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }
 
    // Recursive function to print spiral order traversal of given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // create an empty map to store nodes between given levels
        Map<Integer, Deque<Integer>> map = new HashMap<>();
 
        // traverse the tree and insert its nodes into the map
        // corresponding to the their level
        preorder(root, 1, map);
 
        // iterate through the map and print all nodes present in very level
        for (int i = 1; i <= map.size(); i++) {
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
         levelOrderTraversal(root);
    }
    
}
