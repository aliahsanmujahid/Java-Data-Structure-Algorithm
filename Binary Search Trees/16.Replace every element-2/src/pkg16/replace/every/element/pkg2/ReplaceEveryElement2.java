/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg16.replace.every.element.pkg2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
 
// Data structure to store a Binary Search Tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
public class ReplaceEveryElement2 {

       // Function to insert a specified key in the binary search tree
    // rooted at specified node and also find its successor
    public static Node insert(Node root, int key, AtomicInteger successor)
    {
        // base case: empty tree
        if (root == null) {
            return new Node(key);
        }
 
        // if the key is less than root
        if (key < root.key) {
            // set successor as current node
            successor.set(root.key);
 
            // traverse the left subtree
            root.left = insert(root.left, key, successor);
        }
 
        // if the key is more than root
        else if (key > root.key) {
            // traverse the right subtree
            root.right = insert(root.right, key, successor);
        }
 
        return root;
    }
 
    // Replace each element of the specified array with the
    // least greater element on its right
    public static void findInorderSuccessor(int[] arr)
    {
        // root of the binary search tree
        Node root = null;
 
        // traverse the array from the end
        for (int i = arr.length - 1; i >= 0; i--)
        {
            // insert the current element in the binary search tree
            // and replace it with its in-order successor
            AtomicInteger successor = new AtomicInteger(-1);
            root = insert(root, arr[i], successor);
            arr[i] = successor.get();
        }
 
        // print the resultant array
        System.out.println(Arrays.toString(arr));
    }
 
    // main function
    public static void main(String[] args)
    {
        int[] arr = { 10, 100, 93, 32, 35, 65, 80, 90, 94, 6 };
 
        findInorderSuccessor(arr);
    }
}
