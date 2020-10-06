
package pkg10.floor.and.ceil.pkg2;
// Data structure to store a Binary Search Tree node
class Node {
    int data;
    Node left, right;
 
    Node(int data) {
        this.data = data;
    }
};
 
public class FloorAndCeil2 {
   // Wrapper over the Node class
    static class NodeWrapper {
        public Node node;
 
        NodeWrapper() {
            this.node = new Node(-1);
        }
    }
 
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
 
        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    // Recursive function to find floor and ceil of a given key in a BST
    // Note that floor and ceil is passed by reference to the function
    public static void findFloorCeil(Node root, NodeWrapper floor,
                                    NodeWrapper ceil, int key)
    {
        while (root != null)
        {
            // if node with key's value is found, both floor and ceil is equal
            // to the current node
            if (root.data == key)
            {
                floor.node = root;
                ceil.node = root;
                break;
            }
 
            // if given key is less than the root node, visit left subtree
            else if (key < root.data)
            {
                // update ceil to current node before visiting left subtree
                ceil.node = root;
                root = root.left;
            }
 
            // if given key is more than the root node, visit right subtree
            else
            {
                // update floor to current node before visiting right subtree
                floor.node = root;
                root = root.right;
            }
        }
    }
 
    // main function
    public static void main(String[] args)
    {
        /* Construct below tree
                   8
                 /   \
                /     \
               4       10
              / \     /  \
             /   \   /    \
            2     6 9      12
        */
 
        int[] keys = { 2, 4, 6, 8, 9, 10, 12 };
 
        Node root = null;
        for (int key : keys) {
            root = insert(root, key);
        }
 
        // find Ceil and Floor for each key
        for (int i = 0; i < 15; i++)
        {
            NodeWrapper floor = new NodeWrapper();
            NodeWrapper ceil = new NodeWrapper();
 
            findFloorCeil(root, floor, ceil, i);
            System.out.println(i + " -> Floor is " + floor.node.data + ", Ceil is "
                                        + ceil.node.data);
        }
 
    }
}
