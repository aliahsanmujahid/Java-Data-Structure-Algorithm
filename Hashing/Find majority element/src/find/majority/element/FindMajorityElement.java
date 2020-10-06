
package find.majority.element;

public class FindMajorityElement {
    
    static int majorityElement(int A[], int n)
{
   // System.out.println("--"+(n/2));
    // check if A[i] is majority element or not
    for (int i = 0; i <= n/2; i++)
    {
        int count = 1;
        for (int j = i + 1; j < n; j++) {
            if (A[j] == A[i]) {
                count++;
            }
        }
            System.out.println(count+"--"+(n/2));
        if (count > n/2) {
            return A[i];
        }
    }
 
    return -1;
}
   public static void main (String[] args)
    {
        // Assumption - valid input (majority element is present)
        int arr[] = { 2, 8, 7, 2, 2, 5, 2, 3, 1, 3, 2 };
 
        int res = majorityElement(arr,arr.length);
        if (res != -1) {
            System.out.println("Majority element is " + res);
        } else {
            System.out.println("Majority element does not exist");
        }
    }
}
