
package creting.binary.tree;
// importing necessary classes 
import java.util.*; 
   
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
    }
}
   
class NewClass  
{ 
    public static void treecreate(){
    
        Scanner input = new Scanner(System.in);        
        System.out.print("Enter The Root Value: ");
        
        int v = input.nextInt();
        
        Node head = new Node (v);
        head.left=head.right=null;

        Queue q = new ArrayDeque();
        q.add(head);
        
        while(!q.isEmpty()){
            Node p =(Node)q.poll();
            System.out.print("Enter The Leftchild of: "+p.data+"-- "); 
            int x=input.nextInt();
            if(x!=-1){
                Node t = new Node(x);
                t.left=t.right=null;
                p.left=t;
                q.add(t);
            }
            System.out.print("Enter The Rightchild of: "+p.data+"-- "); 
             x=input.nextInt();
             if(x!=-1){
                Node t = new Node(x);
                t.left=t.right=null;
                p.right=t;
                q.add(t);
            }
       }
        preorder(head);
    
}
public static void preorder(Node head){
    if(head!=null){
        System.out.print(head.data+" ");
        preorder(head.left);
        preorder(head.right);
    }
}
    public static void main(String[] args) {
        treecreate();
       
    }
} 