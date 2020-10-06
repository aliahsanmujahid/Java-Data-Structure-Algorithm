
package pkg15.construct.a.linked.pkg4;
// A linked list node
class Node
{
    int data;
    Node next;
 
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
     public String toString(){//overriding the toString() method  
  return data+" ";  
 }
};
 
public class ConstructALinked4 {

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
 
    // Recursive function to construct a linked list by merging
    // alternate nodes of two given linked lists
    public static Node ShuffleMerge(Node a, Node b)
    {
           printList("a : ", a);
           printList("b : ", b);
        // see if either list is empty
        if (a == null) {
            return b;
        }
 
        if (b == null) {
            return a;
        }
 
        // it turns out to be convenient to do the recursive call first --
        // otherwise a.next and b.next need temporary storage
 
        Node recur = ShuffleMerge(a.next, b.next);
          printList("recur : ", recur);
        
        Node result = a;        // one node from a
          printList("result : ", result);
        a.next = b;                // one from b
          printList("a : ", a);
        printList("b : ", b);
        b.next = recur;            // then the rest
        printList("b : ", b);
        return result;
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
 
        Node a = null, b = null;
        for (int i = keys.length - 1; i >= 0; i = i - 2) {
            a = new Node(keys[i], a);
        }
 
        for (int i = keys.length - 2; i >= 0; i = i - 2) {
            b = new Node(keys[i], b);
        }
 
        // print both linked list
        printList("First List  : ", a);
        printList("Second List : ", b);
 
        Node head = ShuffleMerge(a, b);
        printList("After Merge : ", head);
    }
}