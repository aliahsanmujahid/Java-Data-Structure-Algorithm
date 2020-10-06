
package pkg60.set.next.pointer;
// Data structure to store a Binary Tree node
class Node
{
    int data;
    Node left = null, right = null, next = null;
 
    Node(int data) {
        this.data = data;
    }
}

public class SetNextPointer {
    // Function to set next pointer of all nodes in a binary tree
    // curr -> current node
    // prev -> previous processed node
    public static Node setNextNode(Node curr, Node prev)
    {
        // return if tree is empty
        if (curr == null) {
            return prev;
        }
 
        // recur for left subtree
        prev = setNextNode(curr.left, prev);
 
        // set previous node next pointer to current node
        if (prev != null) {
            prev.next = curr;
        }
 
        // update previous node to current node
        prev = curr;
 
        // recur for right subtree
        return setNextNode(curr.right, prev);
    }
 
    // Function to print inorder Successor of all nodes of
    // binary tree using next pointer
    public static void inorderSuccessor(Node curr)
    {
        Node prev = null;
 
        // set next pointer of all nodes
        setNextNode(curr, prev);
 
        // go to leftmost node
        curr = curr.left.left;
 
        // print inorder Successor of all nodes
        while (curr.next != null)
        {
            System.out.println("Inorder Successor of " + curr.data + " is "
                                + curr.next.data);
            curr = curr.next;
        }
    }
 
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        inorderSuccessor(root);
    }
    
}
