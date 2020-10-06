
package pkg30.vertical.sum.pkg2;
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
    int data;
    ListNode prev, next;
 
    ListNode(int data, ListNode prev, ListNode next)
    {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
};
public class VerticalSum2 {
 // Function to print the vertical sum stored in given doubly linked list
    public static void print(ListNode mid)
    {
        // find the head mode
        while (mid != null && mid.prev != null) {
            mid = mid.prev;
        }
 
        // start with the head node
        ListNode head = mid;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
 
    // Recursive function to do a pre-order traversal of the tree and calculate the
    // vertical sum of given binary tree.
    // Each node of doubly linked list will store the sum of tree nodes at
    // corresponding vertical line in a binary tree
    public static void updateDLLwithVerticalSum(TreeNode root, ListNode curr)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // update the data of linked list node corresponding to the vertical line
        // passing through current tree node
        curr.data += root.data;
 
        // create a new linked list node corresponding to the vertical line passing
        // through root's left child, if not already.
        // This node would be the prev pointer of current linked list node
 
        if (root.left != null && curr.prev == null) {
            curr.prev = new ListNode(0, null, curr);
        }
 
        // create a new linked list node corresponding to the vertical line through
        // through root's right child, if not already.
        // This node would be the next pointer of current linked list node
 
        if (root.right != null && curr.next == null) {
            curr.next = new ListNode(0, curr, null);
        }
 
        // recur for left and right subtree
        updateDLLwithVerticalSum(root.left, curr.prev);
        updateDLLwithVerticalSum(root.right, curr.next);
    }
 
    // Function to find and print the vertical sum of given binary tree
    public static void verticalSum(TreeNode root)
    {
        // create a linked list node corresponding to the vertical line through
        // root node
        ListNode curr = new ListNode(0, null, null);
 
        // calculate vertical sum and store it in doubly linked list
        updateDLLwithVerticalSum(root, curr);
 
        // print the linked list
        print(curr);
    }
    public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
 
        verticalSum(root);
    }
    
}
