package javaapplication2;

class Node{
    int data;
    Node next;
    
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    
}
public class JavaApplication2 {

public static void printList(Node head){
    Node temp=head;
    while(temp!=null){
        System.out.print(temp.data+" -> ");
        temp=temp.next;
    }
    System.out.print("null");
}

public static void main(String[] args)
    {
        int arr[]={1,2,3,4,5};
        Node node[] = new Node[arr.length];
        for(int i=0;i<arr.length;i++){
            node[i] = new Node(arr[i], null); 
            if (i > 0) {
                node[i - 1].next = node[i];
            }
        }
        Node head = node[0];
        printList(head);
    }
}
