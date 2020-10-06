
package pkg46.determine.pkgif.a.pkg3;

// Data Structure to store a linked list node
class Node
{
    int data;
    Node next;
 
    // Constructor
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
};
 
public class DetermineIfA3 {
  // Wrapper over the Node class
    static class NodeWrapper {
        public Node node;
 
        NodeWrapper(Node node) {
            this.node = node;
        }
    }
 
    // Function to determine if a given linked list is palindrome or not
    public static boolean isPalindrome(Node curr, NodeWrapper head)
    {
        // base case: end of the list reached
        if (curr == null) {
            return true;
        }
 
        // advance all the way till end of the list and
        // return false in case of any conflict
        if (!isPalindrome(curr.next, head)) {
            return false;
        }
 
        // check vs. "mirror" when "coming back" from recursion
        if (curr.data != head.node.data) {
            return false;
        }
 
        // advance "mirror" by one step for every one step "taken back" in the recursion
        head.node = head.node.next;
        return true;
    }
 
    // Determine if a given linked list is palindrome or not.
    // The function takes a pointer to the head node of the list.
    public static boolean isPalindrome(Node head)
    {
        return isPalindrome(head, new NodeWrapper(head));
    }
 
    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
 
        if (isPalindrome(head)) {
            System.out.print("Linked List is a palindrome.");
        }
        else {
            System.out.print("Linked List is not a palindrome.");
        }
    }
}
