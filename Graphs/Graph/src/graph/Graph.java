package graph;

import java.util.Scanner;

class Node {

    int data;
    Node next;

}

public class Graph {

    public static void read_graph(Node adj[], int no_of_nodes) {
        Scanner input = new Scanner(System.in);
        int i, j, k, val;
        Node newnode = null;
        Node last = null;
        for (i = 0; i < no_of_nodes; i++) {
            System.out.print("Enter the Number of neighbours of " + (i + 1) + " ");
            k = input.nextInt();
            for (j = 0; j < k; j++) {
                System.out.print("Enter the value of " + (j + 1) + " neighbours of " + (i + 1) + " ");
                val = input.nextInt();
                newnode = new Node();
                newnode.data = val;
                newnode.next = null;
                if (adj[i] == null) {
                    adj[i] = newnode;
                } else {
                    last.next = newnode;
                }
                last = newnode;
            }
        }
    }

    public static void print_graph(Node adj[], int no_of_nodes) {
        Node ptr = null;
        int i;
        for (i = 0; i < no_of_nodes; i++) {
            ptr = adj[i];
            System.out.print("\nThe neighbours of " + (i + 1) + " are : ");
            while (ptr != null) {
                System.out.print(ptr.data + " ");
                ptr = ptr.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i, node;
        System.out.print("Enter the Nodes: ");
        node = input.nextInt();

        Node[] adj = new Node[node];
        for (i = 0; i < node; i++) {
            adj[i] = null;
        }
        read_graph(adj, node);
        print_graph(adj, node);

    }

}
