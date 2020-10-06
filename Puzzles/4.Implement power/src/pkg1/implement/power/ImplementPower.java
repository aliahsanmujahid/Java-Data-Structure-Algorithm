
package pkg1.implement.power;


public class ImplementPower {
   public static int pow(int a, int b)
    {
        if(b == 0) {
            return 1;
        }
 
        int res = 0;
        int power = pow(a, b - 1);
 
        for(int i = 0; i < a; i++) {
            res += power;
        }
 
        return res;
    }
 
    public static void main(String[] args)
    {
        System.out.print(pow(7, 3));
    } 
}
