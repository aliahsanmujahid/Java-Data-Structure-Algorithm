
package pkg10.split.nodes.pkg2;
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
 
public class SplitNodes2 {
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
 
    /*
    Split the nodes of the given list into front and back halves,
    and return the two lists using an array.
    If the length is odd, the extra node should go in the front list.
    It uses the fast/slow reference strategy
    */
    public static Node[] FrontBackSplit(Node source)
    {
        Node frontRef, backRef;
        // if length is less than 2, handle separately
        if (source == null || source.next == null)
        {
            frontRef = source;
            backRef = null;
            return new Node[] { frontRef, backRef };
        }
 
        Node slow = source;
        Node fast = source.next;
 
        // Advance 'fast' two nodes, and advance 'slow' one node
        while (fast != null)
        {
            fast = fast.next;
            if (fast != null)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
 
        // 'slow' is before the midpoint in the list, so split it in two
        // at that point.
        frontRef = source;
        backRef = slow.next;
        slow.next = null;
 
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
