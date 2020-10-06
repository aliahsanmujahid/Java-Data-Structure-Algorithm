
package pkg15.find.square.pkg2;

public class FindSquare2 {
  public static int findSquare(int num)
    {
        // convert number to positive if it is negative
        num = Math.abs(num);
 
        // stores square of the number
        int sq = num;
 
        // repeatedly add num to the result
        for (int i = 1; i < num; i++) {
            sq = sq + num;
        }
 
        return sq;
    }
 
    public static void main(String[] args) {
        System.out.print(findSquare(8) + " " + findSquare(-4));
    } 
}
