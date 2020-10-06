
package pkg15.find.square;

public class FindSquare {
  public static int findSquare(int num)
    {
        int odd = 1;
        int sq = 0;
 
        // convert number to positive if it is negative
        num = Math.abs(num);
 
        while (num-- > 0) {
            sq = sq + odd;
            odd = odd + 2;
        }
 
        return sq;
    }
 
    public static void main(String[] args)
    {
        System.out.println(findSquare(8));
        System.out.println(findSquare(-4));
    }
}
