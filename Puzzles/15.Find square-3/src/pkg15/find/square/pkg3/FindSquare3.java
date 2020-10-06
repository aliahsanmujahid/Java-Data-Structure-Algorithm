
package pkg15.find.square.pkg3;

public class FindSquare3 {
   public static int findSquare(int num)
    {
        // base case
        if (num < 2) {
            return num;
        }
 
        // convert number to positive if it is negative
        num = Math.abs(num);
 
        // drop last bit from num (divide it by 2)
        int i = num >> 1;
 
        // if num is odd
        if ((num & 1) == 1) {
            return ((findSquare(i) << 2) + (i << 2) + 1);
        }
        // if num is even
        else {
            return (findSquare(i) << 2);
        }
    }
 
    public static void main(String[] args) {
        System.out.print(findSquare(8));
    }
}
