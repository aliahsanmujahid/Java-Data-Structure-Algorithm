
package pkg10.split.nodes;
// A linked list node
class Node
{
    int data;
    Node next;
 
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    
};
public class SplitNodes {
   // Helper function to print given linked list
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
 
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
 
    // Return the number of nodes in a list
    public static int Length(Node head)
    {
        int count = 0;
        Node ptr = head;
        while (ptr != null)
        {
            count++;
            ptr = ptr.next;
        }
        return count;
    }
 
    /*
    Split the nodes of the given list into front and back halves,
    and return the two lists using an array.
    If the length is odd, the extra node should go in the front list.
    */
    public static Node[] FrontBackSplit(Node source)
    {
        Node frontRef, backRef;
 
        int len = Length(source);
        if (len < 2)
        {
            frontRef = source;
            backRef = null;
            return new Node[] { frontRef, backRef };
        }
 
        Node current = source;
 
        int hopCount = (len - 1) / 2; // (figured these with a few drawings)
        for (int i = 0; i < hopCount; i++) {
            current = current.next;
        }
 
        // Now cut at current
        frontRef = source;
        backRef = current.next;
        current.next = null;
 
        return new Node[] { frontRef, backRef };
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = {6, 3, 4, 8, 2, 9};
 
        // points to the head node of the linked list
        Node head = null;
 
        // construct linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        Node[] nodes = FrontBackSplit(head);
 
        // print linked list
        printList("Front List : ", nodes[0]);
        printList("Back List  : ", nodes[1]);
    }
}
