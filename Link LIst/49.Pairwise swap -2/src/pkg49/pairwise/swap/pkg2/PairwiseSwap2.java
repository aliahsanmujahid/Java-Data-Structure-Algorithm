
package pkg49.pairwise.swap.pkg2;
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
 
public class PairwiseSwap2 {
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
 
    // Function to pairwise swap adjacent nodes of a linked list
    public static Node rearrange(Node head, Node prev)
    {
        // base case: if list is empty or contains just one node
        if (head == null || head.next == null) {
            return head;
        }
 
        Node curr = head;
        Node temp = curr.next;
        curr.next = temp.next;
        temp.next = curr;
 
        if (prev == null) {
            head = temp;
        } else {
            prev.next = temp;
        }
 
        prev = curr;
        rearrange(curr.next, prev);
 
        return head;
    }
 
    // The wrapper function to call rearrange()
    public static Node rearrange(Node head)
    {
        return rearrange(head, null);
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
 
        Node head = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            head = new Node(arr[i], head);
        }
 
        printList("Before : ", head);
        head = rearrange(head);
        printList("After  : ", head);
    }
}
