/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complete.binary.tree.pkg3;

// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
public class CompleteBinaryTree3 {

  private static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
 
    // Recursive function to check if given binary tree is complete tree or not
    public static boolean isComplete(Node root, int i, int n)
    {
        // return if tree is empty
        if (root == null) {
            return true;
        }
 
        if ((root.left != null && 2*i + 1 >= n) || !isComplete(root.left, 2*i + 1, n)) {
            return false;
        }
 
        if ((root.right != null && 2*i + 2 >= n) || !isComplete(root.right, 2*i + 2, n)) {
            return false;
        }
 
        return true;
    }
    public static void main(String[] args) {
      Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (isComplete(root, 0, size(root))) {
            System.out.print("Given binary tree is a Complete Binary Tree");
        } else {
            System.out.print("Given binary tree is not a Complete Binary Tree");
        }
    }
    
}
