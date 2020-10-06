/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level.order;

class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int key) {
        this.data = key;
    }
}
public class LevelOrder {
// Function to print all nodes of a given level from left to right
    public static boolean printLevel(Node root, int level)
    {
        // base case
        if (root == null) {
            return false;
        }
 
        if (level == 1)
        {
            System.out.print(root.data + " ");
 
            // return true if at-least one node is present at given level
            return true;
        }
 
        boolean left = printLevel(root.left, level - 1);
        boolean right = printLevel(root.right, level - 1);
 
        return left||right;
    }
 
    // Function to print level order traversal of given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // start from level 1 -- till height of the tree
          int level = 1;
        
        // run till printLevel() returns false
        while (printLevel(root, level)) {
            level++;
        }
    }
      // main function
    public static void main(String[] args)
    {
        
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
