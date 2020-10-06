package pkg5.find.a.duplicate.element.pkg2;

public class FindADuplicateElement2 {
   // Function to find a duplicate element in a limited range array
    public static int findDuplicate(int[] A)
    {
        int duplicate = -1;
 
        // do for each element in the array
        for (int i = 0; i < A.length; i++)
        {
            // get value of the current element
            int val = (A[i] < 0) ? -A[i] : A[i];
 
            // make element at index (val-1) negative if it is positive
            if (A[val-1] >= 0) {
                A[val-1] = -A[val-1];
            }
            else
            {
                // if element is already negative, it is repeated
                duplicate = val;
                break;
            }
        }
 
        // restore original array before returning
        for (int i = 0; i < A.length; i++) {
            // make negative elements positive
            if (A[i] < 0) {
                A[i] = -A[i];
            }
        }
 
        // return duplicate element
        return duplicate;
    }
 
    // main function
    public static void main (String[] args)
    {
        // input array contains n numbers between [1 to n - 1]
        // with one duplicate, where n = A.length
        int[] A = { 1, 2, 3, 4, 2 };
 
        System.out.println("Duplicate element is " + findDuplicate(A));
    }
}