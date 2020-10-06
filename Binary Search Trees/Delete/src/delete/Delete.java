
package delete;

class Node{
    int data;
    Node lchild,rchild;
    Node(int key){
        data=key;
        lchild=rchild=null;
    }
    
}
public class Delete {
  public static int Height( Node p)
{
 int x,y;
 if(p==null)return 0;
 x=Height(p.lchild);
 y=Height(p.rchild);
 return x>y?x+1:y+1;
}
   public static  Node InPre( Node p)
{
 while(p!=null  &&  p.rchild!=null)
 p=p.rchild;
 return p;
}
   public static Node InSucc(Node p)
{
 while(p!=null&& p.lchild!=null)
 p=p.lchild;
 return p;
}

    public static Node deleteNode(Node root,int key){
   Node q;
if(root==null){
    return null;
}
if(root.lchild==null&&root.rchild==null){
    if(root==root)
        root=null;
        return null;
}
if(key<root.data){
    root.lchild=deleteNode(root.lchild,key);
}
else if(key>root.data){
    root.rchild=deleteNode(root.lchild,key);
}else{
    if(Height(root.lchild)>Height(root.rchild))
 {
 q=InPre(root.lchild);
root.data=q.data;
root.lchild=deleteNode(root.lchild,q.data);
 }
 else
 {
 q=InSucc(root.rchild);
root.data=q.data;
root.rchild=deleteNode(root.rchild,q.data);
 }
}
return root;
    }
    
    public static void inorder(Node root){
         if (root == null) {
            return;
        }
 
        inorder(root.lchild);
        System.out.print(root.data + " ");
        inorder(root.rchild);
    }
    public static Node insert(Node root,int key){
        
        Node curr  =root;
        Node parent  = null;
        if (root == null) {
            return new Node(key);
        }
        while(curr!=null){
        parent=curr;
        if(key<curr.data)
            curr=curr.lchild;
        else
            curr=curr.rchild;
        
    }
        if(key<parent.data)
           parent.lchild = new Node(key);
        else
            parent.rchild = new Node(key);
        return root;
    }
    public static void main(String[] args) {
        Node root  = null;
        int a[] = {15, 10, 20, 8, 12, 16, 25};
       
        for(int i=0;i<a.length;i++){
            root = insert(root,a[i]);
        }
        ///inorder(root);
          root=deleteNode(root, 16);
          root=deleteNode(root, 12);
         inorder(root);
    }
            
    
}
