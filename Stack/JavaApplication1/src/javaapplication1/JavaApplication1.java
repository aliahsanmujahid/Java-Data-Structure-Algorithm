
package javaapplication1;
class Node
{
    int data;
    Node next;
};
public class JavaApplication1 {

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

    public static Node push(Node head,  int data)
    {

        Node newNode = new Node();
        newNode.data = data;
 
        newNode.next = head;
 
 
        return newNode;
    }

    public static Node appendNode(Node head, int key) {
        Node current = head;

        if (current == null) {
            head = push(head, key);
        }
        else {

            while (current.next != null) {
                current = current.next;
            }
 
            current.next = push(current.next, key);
        }
        
        return head;
    }

    public static void main(String[] args)
    {
 
        int[] keys = {1, 2, 3, 4};
 
        Node head = null;
 
        for (int key: keys) {
            head = appendNode(head, key);
        }
        printList(head);
    }
    
}
