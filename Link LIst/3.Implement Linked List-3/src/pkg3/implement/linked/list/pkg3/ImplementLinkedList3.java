
package pkg3.implement.linked.list.pkg3;
// A linked list node
class Node
{
    int data;
    Node next;
};
public class ImplementLinkedList3 {
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
   /*
        Takes a list and a data value and creates a new link with given data
        and pushes it onto the front of the list.
    */
    public static Node push(Node head,  int data)
    {
        // Allocate the new node in the heap and set its data
        Node newNode = new Node();
        newNode.data = data;
 
        // Set the next field of the new node to point to the current
        // first node of the list.
        newNode.next = head;
 
        // Change the head to point to the new node, so it is
        // now the first node in the list.
 
        return newNode;
    }
      // Function to implement linked list from given set of keys
    // using dummy node
    public static Node constructList(int[] keys)
    {
        Node dummy = new Node(); // Dummy node is temporarily the first node
        Node tail = dummy; // Start the tail at the dummy.
 
        // Build the list on dummy.next (aka tail.next)
 
        for (int key: keys) {
            tail.next = push(tail.next, key);
            tail = tail.next;
        }
 
        // The real result list is now in dummy.next
        // dummy.next == {key[0], key[1], key[2], key[3]};
        return (dummy.next);
    }
    // main method to implement linked list
    public static void main(String[] args)
    {
        // input keys
        int[] keys = {1, 2, 3, 4};
 
        // points to the head node of the linked list
        Node head = constructList(keys);
 
        // print linked list
        printList(head);
    }
}
