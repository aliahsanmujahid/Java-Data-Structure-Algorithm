
package quicksort;

import java.util.Arrays;

public class Quicksort {
public static void swap (int[] arr, int i, int j) {
       int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // Partition using Lomuto partition scheme
    public static int Partition(int[] a, int start, int end)
    {

        int pivot = a[end];
        
        int pIndex = start;
        
        for(int i=start;i<end;i++){
            if(a[i]<=pivot){
                swap(a,i,pIndex);
                pIndex++;
            }
        }
        swap(a,end,pIndex);
        return pIndex;
    }
 
    // Quicksort routine
    public static void quicksort(int[] a ,int start, int end)
    {
       // base condition
    if (start >= end)
        return;
 
    // rearrange the elements across pivot
    int pivot = Partition(a, start, end);
 
    // recur on sub-array containing elements that are less than pivot
    quicksort(a, start, pivot - 1);
 
    // recur on sub-array containing elements that are more than pivot
    quicksort(a, pivot + 1, end);
    }
    public static void main(String[] args) {
         int a[] = {7,6,10,5,5,7 ,10,10,7,5};
 
        quicksort(a, 0, a.length - 1);
 
        // print the sorted array
        System.out.println(Arrays.toString(a));
    }
    
}
