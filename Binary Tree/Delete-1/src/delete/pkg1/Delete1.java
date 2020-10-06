
package delete.pkg1;
// A binary tree node 
class Node  
{ 
    int data; 
    Node left, right; 
   
    Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
public class Delete1 {
Node root; 
   
    /*  This function traverses tree in post order to  
        to delete each and every node of the tree */
    void deleteTree(Node node)  
    { 
        // In Java automatic garbage collection 
        // happens, so we can simply make root 
        // null to delete the tree 
        root = null; 
    } 
   
    /* Driver program to test above functions */
    public static void main(String[] args)  
    { 
        Delete1 tree = new Delete1(); 
   
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
   
        /* Print all root-to-leaf paths of the input tree */
        tree.deleteTree(tree.root); 
        tree.root = null; 
        System.out.println("Tree deleted"); 
   
    } 
}
