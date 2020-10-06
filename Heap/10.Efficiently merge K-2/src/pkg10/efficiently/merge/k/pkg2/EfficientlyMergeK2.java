
package pkg10.efficiently.merge.k.pkg2;
// A linked list node
class Node {
    int data;
    Node next;
 
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
};
public class EfficientlyMergeK2 {
  // Utility function to print contents of a linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("null");
    }
 
    // Takes two lists sorted in increasing order, and merge their nodes
    // together to make one big sorted list which is returned
    public static Node sortedMerge(Node a, Node b) {
        // Base cases
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
 
        Node result;
 
        // Pick either a or b, and recur
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
 
        return result;
    }
 
    // The main function to merge given k sorted linked lists
    // It takes an array of lists list[0..k) and generates the sorted output
    public static Node mergeKLists(Node list[], int k) {
        int last = k - 1;
 
        // repeat until only one list is left
        while (last != 0) {
            int i = 0, j = last;
 
            // (i, j) forms a pair
            while (i < j) {
                // merge List i with List j and store
                // merged list in List i
                list[i] = sortedMerge(list[i], list[j]);
 
                // consider next pair
                i++;
                j--;
 
                // If all pairs are merged, update last
                if (i >= j)
                    last = j;
            }
        }
 
        return list[0];
    }
 
    public static void main(String[] s) {
        int k = 3; // Number of linked lists
 
        // An array to store the head nodes of the linked lists
        Node[] list = new Node[k];
 
        list[0] = new Node(1);
        list[0].next = new Node(5);
        list[0].next.next = new Node(7);
 
        list[1] = new Node(2);
        list[1].next = new Node(3);
        list[1].next.next = new Node(6);
        list[1].next.next.next = new Node(9);
 
        list[2] = new Node(4);
        list[2].next = new Node(8);
        list[2].next.next = new Node(10);
 
        // Merge all lists into one
        Node head = mergeKLists(list, k);
        printList(head);
    }
}
