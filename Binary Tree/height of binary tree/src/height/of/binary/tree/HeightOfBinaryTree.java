
package height.of.binary.tree;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        this.left=this.right=null;
    }
    
}
public class HeightOfBinaryTree {
   public static int height(Node n){
       if(n==null){
           return 0;
       }
       return 1+Integer.max(height(n.left),height(n.right));
   }
    public static void main(String[] args) {
      Node n;
      n = new Node(10);
      n.left = new Node(20);
       n.right = new Node(20);
        n.left.left = new Node(20);
         n.left.right = new Node(20); 
         n.right.left = new Node(20);
          n.right.right = new Node(20);
          
          System.out.println("Height is "+height(n));
         
       
    }
    
}
