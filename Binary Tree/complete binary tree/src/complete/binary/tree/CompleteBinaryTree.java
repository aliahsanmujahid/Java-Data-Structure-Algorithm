/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complete.binary.tree;

import java.util.*;
 
// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
     public String toString(){
       return key+" ";  
 } 
}
public class CompleteBinaryTree {

    public static boolean isComplete(Node root){
        
        if(root==null){
            return false;
        }
        
        Queue<Node> queue  = new ArrayDeque();
        queue.add(root);
        
        Node front;
        boolean flag = false;
        
        while(!queue.isEmpty()){
         // pop front node from the queue
            System.out.println("Queue: "+queue);
            front = queue.poll();
            System.out.println("Queue: "+queue+"Front: "+front);
            // if we have encountered a non-full node before and current node
            // is not a leaf, tree cannot be complete tree
            if (flag && (front.left != null || front.right != null)) {
                return false;
            }
            // if left child is empty & right child exists, tree cannot be complete
            if (front.left == null && front.right != null) {
                return false;
            }
 
            // if left child exists, enqueue it
            if (front.left != null) {
                queue.add(front.left);
            }
            // if current node is a non-full node, set flag to true
            else {
                flag = true;
            }
 
            // if right child exists, enqueue it
            if (front.right != null) {
                queue.add(front.right);
            }
            // if current node is a non-full node, set flag to true
            else {
                flag = true;
            }
        }
        return true;
    }
    // main function
    public static void main(String[] args) {
        /* Construct below tree
                  1
               /     \
              2       3
             / \     / \
            4   5   6   7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
       // root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (isComplete(root)) {
            System.out.print("Given binary tree is a Complete Binary Tree");
        } else {
            System.out.print("Given binary tree is not a Complete Binary Tree");
        }
    }
    
}
