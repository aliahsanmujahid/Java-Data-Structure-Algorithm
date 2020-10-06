package minheap;

public class MinHeap {

  private int[] Heap;
  private int size;
  private int maxsize;
  
  private static final int FRONT = 1;

  public MinHeap(int maxsize){
    this.maxsize=maxsize;
    this.size=0;
    Heap = new int[this.maxsize+1];
    Heap[0] = Integer.MIN_VALUE;
}
  
  int parent(int pos){
      return pos/2;
  }
  int leftChild(int pos){
      return (2*pos);
  }
  int rightChild(int pos){
      return (2*pos) +1;
  }

  private void swap(int fpos, int spos) 
    { 
        int tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  
public void insert(int element) 
    { 
        if (size >= maxsize) { 
            return; 
        } 
        Heap[++size] = element; 
        int current = size; 
       // System.out.println(size);
       // System.out.println(Heap[current] +" "+ Heap[parent(current)]);
        while (Heap[current] < Heap[parent(current)]) { 
            System.out.println(Heap[current]+" "+Heap[parent(current)]);
            swap(current, parent(current)); 
            System.out.println(Heap[current]+" "+Heap[parent(current)]);
            current = parent(current); 
        } 
    } 
  public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + Heap[i] 
                             + " LEFT CHILD : " + Heap[2 * i] 
                             + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
 public int remove() 
    { 
        int popped = Heap[FRONT]; 
        Heap[FRONT] = Heap[size--]; 
        minHeapify(FRONT); 
        return popped; 
    } 
 void minHeapify(int pos) 
    { 
  
        // If the node is a non-leaf node and greater 
        // than any of its child 
        if (!isLeaf(pos)) { 
            if (Heap[pos] > Heap[leftChild(pos)] 
                || Heap[pos] > Heap[rightChild(pos)]) { 
  
                // Swap with the left child and heapify 
                // the left child 
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) { 
                    swap(pos, leftChild(pos)); 
                    minHeapify(leftChild(pos)); 
                } 
  
                // Swap with the right child and heapify 
                // the right child 
                else { 
                    swap(pos, rightChild(pos)); 
                    minHeapify(rightChild(pos)); 
                } 
            } 
        } 
    } 
  
  private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  public void minHeap() 
    { 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            minHeapify(pos); 
        } 
    } 
  
    public static void main(String[] args) {
        System.out.println("The Min Heap is "); 
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(34); 
        minHeap.insert(65); 
        minHeap.insert(86); 
        minHeap.insert(23); 
       // minHeap.minHeap(); 
  
        minHeap.print(); 
     // System.out.println("The Min val is " + minHeap.remove()); 
     // System.out.println("The Min val is " + minHeap.remove()); 
    }
}
