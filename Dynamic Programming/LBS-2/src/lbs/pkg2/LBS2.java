package lbs.pkg2;

import java.util.ArrayList;
import java.util.List;
 
class LBS2 {
 
    // Function to find Longest Bitonic Subsequence in an array
    public static void LBS(int[] arr, int n)
    {
        // I.get(i) stores the longest increasing subsequence ending with arr.get(i)
        List<List<Integer>> I = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            I.add(i, new ArrayList<>());
        }
 
        I.get(0).add(arr[0]);
 
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (I.get(i).size() < I.get(j).size() && arr[i] > arr[j]) {
                    I.set(i, new ArrayList<>(I.get(j)));
                }
            }
            I.get(i).add(arr[i]);
        }
 
        // D.get(i) stores the longest decreasing subsequence starting from arr.get(i)
        List<List<Integer>> D = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            D.add(i, new ArrayList<>());
        }
        D.get(n).add(0, arr[n]);
 
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j > i; j--) {
                if (D.get(i).size() < D.get(j).size() && arr[i] > arr[j])
                    D.set(i, new ArrayList<>(D.get(j)));
            }
            D.get(i).add(0, arr[i]);
        }
 
        // Uncomment below lines to print contents of list LIS & LDS
        /*for (int i = 0; i <= n; i++) {
            System.out.println("LIS[" + i + "] - " + I.get(i));
        }
 
        for (int i = 0; i <= n; i++) {
            System.out.println("LDS[" + i + "] - " + D.get(i));
        }*/
 
        // find peak element index
        int peak = 0;
        for (int i = 1; i <= n; i++) {
            if (I.get(i).size() + D.get(i).size() > 
                    I.get(peak).size() + D.get(peak).size()) {
                peak = i;
            }
        }
 
        System.out.print("Longest Bitonic Subsequence is: ");
 
        // print longest increasing subsequence ending at peak element
        System.out.print(I.get(peak));
 
        // pop front element of LDS as it points to same element as rear of LIS
        D.get(peak).remove(0);
 
        // print longest decreasing subsequence starting from peak element
        System.out.println(D.get(peak));
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 2, 5, 9, 7, 6, 10, 3, 1 };
        LBS(arr, arr.length - 1);
    }
}
