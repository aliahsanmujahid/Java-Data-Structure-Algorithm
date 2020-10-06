
package pkg50.flatten.a.linked.pkg2;
// A linked list node
class Node {
    int data;
    Node next;
    Node down;
};
 
public class FlattenALinked2 {
   // Helper function to insert new node in the beginning of the 
    // vertical linked list
    public static Node push(Node head,  int data)
    {
        Node newNode = new Node();
 
        newNode.data = data;
        newNode.next = null;
        newNode.down = head;
 
        return newNode;
    }
 
    // Takes two lists sorted in increasing order, and merge their nodes
    // together to make one big sorted list which is returned
    public static Node SortedMerge(Node a, Node b)
    {
        // Base cases
        if (a == null) {
            return b;
        }
        else if (b == null) {
            return a;
        }
 
        Node result;
 
        // Pick either a or b, and recur
        if (a.data <= b.data)
        {
            result = a;
            result.down = SortedMerge(a.down, b);
        }
        else
        {
            result = b;
            result.down = SortedMerge(a, b.down);
        }
 
        return result;
    }
 
    // Helper function to print given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.down;
        }
 
        System.out.println("null");
    }
 
    // Recursive function to flatten and sort a given list
    public static Node flatten(Node head)
    {
        // base case: an empty list
        if (head == null) {
            return head;
        }
 
        // Merge this list with the list on right side
        Node sorted = SortedMerge(head, flatten(head.next));
 
        // set next link to null after flattening
        head.next = null;
 
        return sorted;
    }
 
    // Helper function to create a linked list with elements of given vector
    public static Node createVerticalList(Node head, int[] arr)
    {
        for (int key: arr) {
            head = push(head, key);
        }
        return head;
    }
 
    public static void main(String[] args)
    {
        Node head = null;
 
        int arr1[] = { 8, 6, 4, 1 };
        int arr2[] = { 7, 3, 2 };
        int arr3[] = { 9, 5 };
        int arr4[] = { 12, 11, 10 };
 
        head = createVerticalList(head, arr1);
        head.next = createVerticalList(head.next, arr2);
        head.next.next = createVerticalList(head.next.next, arr3);
        head.next.next.next = createVerticalList(head.next.next.next, arr4);
 
        // flatten and sort the list
        flatten(head);
 
        // print the flattened & sorted linked list
        printList(head);
    }
}
