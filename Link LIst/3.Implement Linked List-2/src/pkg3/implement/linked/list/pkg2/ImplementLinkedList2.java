
package pkg3.implement.linked.list.pkg2;

// A linked list node
class Node
{
    int data;
    Node next;
};
 
public class ImplementLinkedList2 {

   // Helper function to print given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
    // Helper function to insert a new node in the beginning of linked list
    public static Node push(Node head,  int data)
    {
        // Allocate the new node in the heap and set its data
        Node newNode = new Node();
        newNode.data = data;
 
        // Set the next field of the new node to point to the current
        // first node of the list.
        newNode.next = head;
 
        // return the head to point to the new node, so it is
        // now the first node in the list.
 
        return newNode;
    }
       // Function to add a new node at the tail end of the list instead 
    // of its head
    public static Node appendNode(Node head, int key) {
        Node current = head;
 
        // special case for the empty list
        if (current == null) {
            head = push(head, key);
        }
        else {
            // Locate the last node
            while (current.next != null) {
                current = current.next;
            }
 
            // Build the node after the last node
            current.next = push(current.next, key);
        }
        
        return head;
    }
      // main method to implement linked list
    public static void main(String[] args)
    {
        // input keys
        int[] keys = {1, 2, 3, 4};
 
        // points to the head node of the linked list
        Node head = null;
 
        for (int key: keys) {
            head = appendNode(head, key);
        }
 
        // print linked list
        printList(head);
    }
}
