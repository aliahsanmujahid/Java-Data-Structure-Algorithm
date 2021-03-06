
package selection.sort;

import java.util.Arrays;

public class SelectionSort {
public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
public static void selectionSort(int[] arr)
    {
        // run (arr.length - 1) times
        for (int i = 0; i < arr.length - 1; i++)
        {
            // find the minimum element in the unsorted sub-array[i..n-1]
            // and swap it with arr[i]
            int min = i;
 
            for (int j = i + 1; j < arr.length; j++)
            {
                // if arr[j] element is less, then it is the new minimum
                if (arr[j] < arr[min]) {
                    min = j;    // update index of min element
                }
            }
 
            // swap the minimum element in sub-array[i..n-1] with arr[i]
            //swap(arr, min, i);
            if(min!=i){
                 int temp = arr[min];
                 arr[min] = arr[i];
                 arr[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = { 3, 5, 8, 4, 1, 9, -2 };
 
        selectionSort(arr);
 
        // print the sorted array
        System.out.println(Arrays.toString(arr));
    }
    
}
