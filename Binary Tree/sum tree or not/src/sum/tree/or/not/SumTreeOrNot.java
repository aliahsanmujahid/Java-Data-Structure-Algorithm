
package sum.tree.or.not;
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
         public String toString(){//overriding the toString() method  
  return key+" ";  
 } 
}
public class SumTreeOrNot {

     // Recursive function to check if given binary tree is a sum tree or not
    public static int isSumTree(Node root)
    {
        int t;
        System.out.println("root: "+root);
        // base case: empty tree
        if (root == null) {
            return 0;
        }
 
        // special case: leaf node
        if (root.left == null && root.right == null) {
            return root.key;
        }
 
        // if root's value is equal to sum of all elements present in its
        // left and right subtree
        if (root.key == isSumTree(root.left) + isSumTree(root.right)) {
            t= 2 * root.key;
            System.out.println("t: "+t);
            return t;
        }
 
        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
          Node root = new Node(44);
        root.left = new Node(9);
        root.right = new Node(13);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (isSumTree(root) != Integer.MAX_VALUE) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
    
}
