

package clonelinklist;
class Node{
    int data;
    Node next;
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
   Node(){}
}
public class CloneLinkList {
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
    public static Node CopyList(Node head)
    {
        Node current = head;  
 
        while (current != null)
        {
            Node newlist=new Node();
            newlist.data=current.data;
            newlist.next=head;
            head=newlist;
            current = current.next;
        }
 
        return head;
    }
    public static void main(String[] args)
    {
    int keys[]={1,2,3};
    Node head = null;
    for(int i = keys.length - 1; i >= 0; i--){
          head = new Node(keys[i], head);
    }
    System.out.println("MAIN");       
    printList(head);
    System.out.println("COPY");
    Node copy = CopyList(head);
    printList(copy);
    }
}
