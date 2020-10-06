
package complete.binary.tree.pkg2;


import java.util.*;
 
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
     public String toString(){
       return key+" ";  
 } 
}
public class CompleteBinaryTree2 {

 // utility function to get size of the binary tree
    private static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
  // Perform in-order traversal of the array and fill array A[]
    public static void inorder(Node root, boolean[] A, int i)
    {
        System.out.println("root: "+root+" -i- "+i+" --a--"+A.length);
        if (root == null || i >= A.length) {
            return;
        }
 
        // recur with index 2i+1 for left node
        inorder(root.left, A, 2*i + 1);
 
        // mark index i as visited
        System.out.println("-i-"+i);
        A[i] = true;
 
        // recur with index 2i+2 for right node
        inorder(root.right, A, 2*i + 2);
    }
     // Function to check if given binary tree is complete binary tree or not
    public static boolean isComplete(Node root, int n)
    {
        // return if tree is empty
        if (root == null) {
            return true;
        }
 
        // construct an auxiliary boolean array of size n
        boolean[] A = new boolean[n];
 
        // fill array A[]
        inorder(root, A, 0);
 
        // check if all positions in the array are filled or not
        for (boolean e: A) {
            System.out.println(e);
            if (!e) {
                return false;
            }
        }
 
        return true;
    }
    public static void main(String[] args) {
       Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
       //root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (isComplete(root, size(root))) {
            System.out.print("Given binary tree is a Complete Binary Tree");
        } else {
            System.out.print("Given binary tree is not a Complete Binary Tree");
        }
    }
    
}
