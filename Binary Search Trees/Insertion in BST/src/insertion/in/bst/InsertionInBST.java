package insertion.in.bst;
class Node{
    int data;
    Node left,right;
    Node(int key){
        this.data=key;
        left=right=null;
    }
}

public class InsertionInBST {
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static Node insert(Node root,int key){
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
  // if given key is less than the root node,
        // recur for left subtree
        if (key < root.data) {
            root.left= insert(root.left, key);
        }
 
        // else recur for right subtree
        else {
            // key >= root.data
            root.right= insert(root.right, key);
        }
        return root;
    }
    public static void main(String[] args) {
        Node root=null;
        int [] keys = {15, 10, 20, 8, 12, 16, 25};
        for(int key:keys){
           root=insert(root,key); 
        }
        
        inorder(root);
    }
}
