
package pkg65.print.nodes.of;
import java.util.ArrayList;
import java.util.List;
 
// Data Structure to store a binary tree node
class TreeNode {
    int data;
    TreeNode left, right;
 
    TreeNode(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
};
 
// Data Structure to store a doubly linked list node
class ListNode {
    List<Integer> data = new ArrayList<>();
    ListNode prev, next;
 
    ListNode(ListNode prev, ListNode next)
    {
        this.prev = prev;
        this.next = next;
    }
};
 
public class PrintNodesOf {
   // Function to print the vertical order stored in given doubly linked list
    public static void print(ListNode mid)
    {
        // find the head mode
        while (mid != null && mid.prev != null) {
            mid = mid.prev;
        }
 
        // start with the head node
        ListNode head = mid;
        while (head != null) {
            List<Integer> v = head.data;
            for (int i: v)
                System.out.print(i + " ");
 
            System.out.println();
            head = head.next;
        }
    }
 
    // Recursive function to do a pre-order traversal of the tree and determine the
    // vertical order of given binary tree
    // Each node of doubly linked list will store nodes present at the corresponding
    // vertical line in a binary tree
    public static void updateDLLwithVerticalOrder(TreeNode root, ListNode curr)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // add current tree node to the corresponding list node
        curr.data.add(root.data);
 
        // create a new linked list node corresponding to the vertical line passing
        // through root's left child, if not already.
        // This node would become the prev pointer of current linked list node
        if (root.left != null && curr.prev == null) {
            curr.prev = new ListNode(null, curr);
        }
 
        // create a new linked list node corresponding to the vertical line through
        // through root's right child, if not already.
        // This node would become the next pointer of current linked list node
        if (root.right != null && curr.next == null) {
            curr.next = new ListNode(curr, null);
        }
 
        // recur for left and right subtree
        updateDLLwithVerticalOrder(root.left, curr.prev);
        updateDLLwithVerticalOrder(root.right, curr.next);
    }
 
    // Function to print nodes of a given binary tree in vertical order
    public static void printVertical(TreeNode root)
    {
        // create a linked list node corresponding to the vertical line through
        // the root node
        ListNode curr = new ListNode(null, null);
 
        // determine the vertical order and store it in doubly linked list
        updateDLLwithVerticalOrder(root, curr);
 
        // print the linked list
        print(curr);
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
                    /   \
                   /     \
                  5       6
                /   \
               /     \
              7       8
                    /   \
                   /     \
                  9      10
        */
 
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(9);
        root.right.left.right.right = new TreeNode(10);
 
        printVertical(root);
    }
}
