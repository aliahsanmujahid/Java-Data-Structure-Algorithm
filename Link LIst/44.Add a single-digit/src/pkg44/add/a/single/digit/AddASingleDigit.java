
package pkg44.add.a.single.digit;
// Data Structure to store a linked list node
class Node
{
    int data;
    Node next = null;
 
    Node(int data) {
        this.data = data;
    }
};
 
public class AddASingleDigit {
  // Helper function to print given linked list
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
 
    // Function to reverse the given linked list
    public static Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next;
 
        // traverse the list
        while (current != null)
        {
            // tricky: note the next node
            next = current.next;
 
            // fix the current node
            current.next = prev;
 
            // advance the two pointers
            prev = current;
            current = next;
        }
 
        // fix the head pointer to point to the new front
        head = prev;
        return head;
    }
 
    // Function to add a single-digit number to a singly linked list
    // whose nodes represents digits of a number
    public static Node addDigit(Node head, int digit)
    {
        // empty list
        if (head == null) {
            return head;
        }
 
        // reverse the linked list
        head = reverse(head);
 
        // initialize carry with given digit
        int carry = digit;
 
        // traverse the reversed list
        Node curr = head;
        while (carry > 0)
        {
            // get sum of current node and carry
            int sum = curr.data + carry;
 
            // update value of the current node with the single-digit sum
            curr.data = sum % 10;
 
            // set carry for the next node
            carry = sum / 10;
 
            // break if current node is the last node
            if (curr.next == null) {
                break;
            }
 
            // move to the next node
            curr = curr.next;
        }
 
        // add a new node at the end of linked list if there is any carry left
        if (carry > 0) {
            curr.next = new Node(carry);
        }
 
        // reverse the list again to restore the original order
        head = reverse(head);
        return head;
    }
 
    public static void main(String[] args)
    {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(3);
 
        int digit = 7;
 
        printList(" Original Linked List: ", head);
        head = addDigit(head, digit);
        printList("Resultant Linked List: ", head);
    }
}
