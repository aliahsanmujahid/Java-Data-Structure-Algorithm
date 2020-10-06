
package deletenode;
class Node{
    int data;
    Node next;
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
}

public class DeleteNode {
    
      public static void printList(Node head){
          Node temp = head;
          while(temp!=null){
              System.out.print(temp.data+"->");
              temp=temp.next;
          }
          System.out.println("null");
      }
public static Node pop(Node headRef){
      if(headRef==null){
          return null;
      }
         int result = headRef.data;
         headRef=headRef.next;
         System.out.println("Popped node " + result);
         return headRef;
      }

public static void main(String[] args)
    {
        int[] keys = {1, 2, 3, 4};
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        head = pop(head);
        head = pop(head);
        printList(head);
    }
}
