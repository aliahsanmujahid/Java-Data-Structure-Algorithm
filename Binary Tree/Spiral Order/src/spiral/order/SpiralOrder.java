/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiral.order;

class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
public class SpiralOrder {
 // Function to print all nodes of a given level from left to right
    public static boolean printLevelLeftToRight(Node root, int level)
    {
        if (root == null) {
            return false;
        }
 
        if (level == 1) {
            System.out.print(root.key + " ");
            return true;
        }
 
        // process left child before right child
        boolean left = printLevelLeftToRight(root.left, level - 1);
        boolean right = printLevelLeftToRight(root.right, level - 1);
 
        return left || right;
    }
 
    // Function to print all nodes of a given level from right to left
    public static boolean printLevelRightToLeft(Node root, int level)
    {
        if (root == null) {
            return false;
        }
 
        if (level == 1) {
            System.out.print(root.key + " ");
            return true;
        }
 
        // process right child before left child
        boolean right = printLevelRightToLeft(root.right, level - 1);
        boolean left = printLevelRightToLeft(root.left, level - 1);
 
        return right || left;
    }
 
    // Function to print level order traversal of given binary tree
    public static void spiralOrderTraversal(Node root)
    {
        if (root == null)
            return;
 
        // start from level 1 -- till height of the tree
        int level = 1;
 
        // run till either function returns false
        while (printLevelLeftToRight(root, level++) &&
                       printLevelRightToLeft(root, level++));
    }
    public static void main(String[] args) {
          Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
          spiralOrderTraversal(root);
    }
    
}
