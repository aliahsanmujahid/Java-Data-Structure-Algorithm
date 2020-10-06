
package counting.sort;

import java.util.Arrays;

public class CountingSort {
public static void countSort(int[] arr, int k)
    {
        // create an integer array of size n to store sorted array
        int[] output = new int[arr.length];
 
        // create an integer array of size k, initialized by all zero
        int[] freq = new int[k+1];
 
        // using value of integer in the input array as index,
        // store count of each integer in freq[] array
         for (int i: arr) {
            freq[i]++;
        }
 
        // calculate the starting index for each integer
        
        for (int i = 1; i <=k; i++)
        {
          
            freq[i] = freq[i]+freq[i-1];
       
        }
 
        // copy to output array, preserving order of inputs with equal keys
        for (int i = 0; i<arr.length; i++)
        {
            output[--freq[arr[i]]] = arr[i];
        }
 
        // copy the output array back to the input array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
      int[] arr = { 4, 2, 10, 10, 1, 4, 2, 1, 10 };
 
        // range of array elements
        int k = 10;
 
        countSort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
    
}
