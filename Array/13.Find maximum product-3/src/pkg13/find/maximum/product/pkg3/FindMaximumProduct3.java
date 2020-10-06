package pkg13.find.maximum.product.pkg3;

public class FindMaximumProduct3 {
    // Function to find maximum product of two integers in an array
    public static void findMaximumProduct(int[] A)
    {
        // to store maximum and second maximum element in an array
        int max1 = A[0], max2 = Integer.MIN_VALUE;
 
        // to store minimum and second minimum element in an array
        int min1 = A[0], min2 = Integer.MAX_VALUE;
 
        for (int i = 1; i < A.length; i++)
        {
            // if current element is more than the maximum element,
            // update maximum and second maximum element
            if (A[i] > max1) {
                max2 = max1;
                max1 = A[i];
            }
 
            // if current element is less than maximum but greater than
            // second maximum element, update second maximum element
            else if (A[i] > max2) {
                max2 = A[i];
            }
 
            // if current element is more than the minimum element,
            // update minimum and second minimum element
            if (A[i] < min1) {
                min2 = min1;
                min1 = A[i];
            }
 
            // if current element is less than minimum but greater than
            // second minimum element, update second minimum element
            else if (A[i] < min2) {
                min2 = A[i];
            }
 
            // else ignore the element
        }
 
        // Maximum product is formed by maximum of
        // 1. product of maximum and second maximum element or
        // 2. product of minimum and second minimum element
        if (max1 * max2 > min1 * min2) {
            System.out.print("Pair is (" + max1 + ", " + max2 + ")");
        }
        else {
            System.out.print("Pair is (" + min1 + ", " + min2 + ")");
        }
    }
 
    // main function
    public static void main (String[] args)
    {
        int arr[] = { -10, -3, 5, 6, -2 };
 
        findMaximumProduct(arr);
    }
}