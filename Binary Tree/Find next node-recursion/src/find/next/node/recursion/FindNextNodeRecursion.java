/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package find.next.node.recursion;

import java.util.concurrent.atomic.AtomicInteger;
 
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
public class FindNextNodeRecursion {

 
    // Function to find next node for given node  in same level in a
    // binary tree by using pre-order traversal
    public static Node findRightNode(Node root, int value, int level,
                                    AtomicInteger value_level)
    {
        // return null if tree is empty
        if (root == null) {
            return null;
        }
 
        // if desired node is found, set value_level to current level
        if (root.key == value)
        {
            value_level.set(level);
            return null;
        }
 
        // if value_level is already set, then current node is the next right node
        else if (value_level.get() != 0)
        {
            if (level == value_level.get()) {
                return root;
            }
        }
 
        // recur for left subtree by increasing level by 1
        Node left = findRightNode(root.left, value, level + 1, value_level);
 
        // if node is found in left subtree, return it
        if (left != null) {
            return left;
        }
 
        // recur for right subtree by increasing level by 1
        return findRightNode(root.right, value, level + 1, value_level);
    }
 
    // Function to find next node of given node in the same level
    // in given binary tree
    public static Node findRightNode(Node root, int value)
    {
        AtomicInteger value_level = new AtomicInteger(0);
        return findRightNode(root, value, 1, value_level);
    }
 
    // main function
    public static void main(String[] args)
    {
        /* Construct below Tree
                  1
                /  \
               /    \
              2      3
             / \      \
            4   5      6
                      / \
                     7   8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        Node right = findRightNode(root, 5);
        if (right != null) {
            System.out.print("Right Node is " + right.key);
        } else {
            System.out.print("Right Node doesn't exists");
        }
 
    }
}
