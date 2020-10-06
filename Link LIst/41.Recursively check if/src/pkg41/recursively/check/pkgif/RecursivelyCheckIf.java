
package pkg41.recursively.check.pkgif;
// Data Structure to store a linked list node
class Node
{
    char data;
    Node next;
 
    Node(char ch)
    {
        this.data = ch;
        this.next = null;
    }
};
 
public class RecursivelyCheckIf {
   // Construct String s1 and s2 out of given linked list with consecutive
    // elements of the list in forward and backward direction respectively
    public static void construct(Node head, StringBuilder s1, StringBuilder s2)
    {
        // Base case
        if (head == null) {
            return;
        }
 
        s1.append(head.data);
        construct(head.next, s1, s2);
        s2.append(head.data);
    }
 
    // Function to check if a given linked list of characters is palindrome
    public static boolean isPalindrome(Node head)
    {
        // construct String s1 and s2 with consecutive elements of the linked list
        // starting from the beginning and the end respectively
 
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        construct(head, s1, s2);
 
        // check if linked list is palindrome
        return s1.toString().equals(s2.toString());
    }
 
    public static void main(String[] args) {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('B');
        head.next.next.next.next = new Node('A');
 
        if (isPalindrome(head)) {
            System.out.print("Linked List is a palindrome.");
        }
        else {
            System.out.print("Linked List is not a palindrome.");
        }
    }
}
