package stack;

class Node{
    int data;
    Node next;
   
}

public class Stack {

        static Node top=null;
     
        public void push(int x){
            Node node = new Node();
            if(node==null){
                System.out.println("Heap Overflow\n");
                return;
            }
            System.out.println("Inserting "+x);
            node.data=x;
            node.next=top;
            top = node;
        }
        public static void Display(){
            Node p;
            p=top;
            while(top!=null){
                System.out.print(top.data+"->");
                top=top.next;
            }
            System.out.println("null");
            
        }
        public static void main(String[] args){
            Stack stack = new Stack();
            
            stack.push(1);
            stack.push(2);
            stack.push(3);
            
            Display();
        }
        
}