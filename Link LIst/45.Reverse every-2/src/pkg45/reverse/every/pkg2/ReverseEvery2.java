
package pkg45.reverse.every.pkg2;
// Data Structure to store a linked list node
class Node {
    int data;
    Node next;
 
    // Constructor
    Node(int data) {
        this.data = data;
    }
};
 
public class ReverseEvery2 {
    // Wrapper over the Node class
    static class NodeWrapper {
        public Node node;
 
        NodeWrapper(Node node) {
            this.node = node;
        }
    }
 
    // Helper function to allocate the new node in the heap and
    // insert it at the beginning of the linked list
    public static Node push(Node head, int data)
    {
        Node node = new Node(data);
        node.next = head;
        head = node;
 
        return head;
    }
 
    // Helper function to print given linked list
    public static void printList(String msg, Node head)
    {
        System.out.print(msg + ": ");
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
 
    // Function to reverse a first k nodes in a linked list.
    // Note that the linked list pointer is passed by reference
    // The function returns the new front node (or last node in original sublist)
    public static Node reverse(NodeWrapper curr, int k)
    {
        // maintain a prev pointer
        Node prev = null;
 
        // traverse the list and reverse first k nodes
        while (curr != null && k-- > 0) {
            // tricky: note the next node
            Node next = curr.node.next;
 
            // fix the curr node
            curr.node.next = prev;
 
            // advance the two pointers
            prev = curr.node;
            curr.node = next;
        }
 
        // return node at the front
        return prev;
    }
 
    // Function to skip k nodes in given linked list
    public static Node skipKNodes(Node curr, int k)
    {
        while (curr != null && k-- > 0) {
            curr = curr.next;
        }
        return curr;
    }
 
    // Recursive function to reverse every alternate group of k nodes
    // in a linked list
    public static Node reverseAlternatingKNodes(Node head, int k)
    {
        // base case
        if (head == null) {
            return null;
        }
 
        Node originalHead = head;
 
        // Wrap curr node so it's reference can be changed inside reverse() method
        NodeWrapper curr = new NodeWrapper(head);
 
        // reverse first k nodes
        head = reverse(curr, k);
        Node current = curr.node;
 
        // link original head node with the current node ((k+1)th node)
        originalHead.next = current;
 
        // skip next (k-1) nodes
        current = skipKNodes(current, k - 1);
 
        // recur for the remaining list and link it to the current node
        if (current != null) {
            current.next = reverseAlternatingKNodes(current.next, k);
        }
 
        // return head node
        return head;
    }
 
    public static void main(String[] args)
    {
        // construct a singly linked list
        Node head = null;
 
        int n = 10;
        while (n > 0) {
            head = push(head, n--);
        }
 
        int k = 2;
 
        printList("Original Linked List ", head);
        head = reverseAlternatingKNodes(head, k);
        printList("Resultant Linked List", head);
    }
}
