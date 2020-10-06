
package pkg14.multiply.two.numbers;

public class MultiplyTwoNumbers {
   public static int mul(int a, int b)
    {
        // base cases
        if (a == 0 || b == 0) {
            return 0;
        }
 
        if (b == 1) {
            return a;
        }
 
        if (a == 1) {
            return b;
        }
 
        return a + mul(a, b - 1);
    }
 
    public static int multiply(int a, int b)
    {
        int m = mul(a, Math.abs(b));
        return (b < 0) ? -m : m;
    }
 
    public static void main(String[] args)
    {
        System.out.print(multiply(3, 4) + " " + multiply(-3, -4) + " "
                        + multiply(-3, 4) + " " + multiply(3, -4));
    }
    
}
