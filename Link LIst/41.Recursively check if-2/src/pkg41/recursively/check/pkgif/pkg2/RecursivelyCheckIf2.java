
package pkg41.recursively.check.pkgif.pkg2;
// Data Structure to store a linked list node
class Node {
    char data;
    Node next;
 
    Node(char ch)
    {
        this.data = ch;
        this.next = null;
    }
};
 
public class RecursivelyCheckIf2 {
  // Wrapper over the Node class
    static class NodeWrapper {
        public Node node;
 
        NodeWrapper(Node node) {
            this.node = node;
        }
    }
 
    // Recursive function to check if a given linked list of characters is palindrome.
    public static boolean isPalindrome(NodeWrapper left, Node right)
    {
        // base case
        if (right == null) {
            return true;
        }
 
        // return false on first mismatch
        if (!isPalindrome(left, right.next)) {
            return false;
        }
 
        // copy left pointer
        Node prev_left = left.node;
 
        // advance the left pointer to the next node
        // this change would reflect in the parent recursive calls
        left.node = left.node.next;
 
        // In order for linked list to be palindrome, the character at the left
        // node should match with the character at the right node
        return (prev_left.data == right.data);
    }
 
    public static void main(String[] args)
    {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('B');
        head.next.next.next.next = new Node('A');
 
        // Wrap left node so it's reference can be changed inside isPalindrome()
        NodeWrapper left = new NodeWrapper(head);
 
        if (isPalindrome(left, head)) {
            System.out.print("Linked List is a palindrome.");
        }
        else {
            System.out.print("Linked List is not a palindrome.");
        }
    }
}
