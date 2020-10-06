
package pkg1.implement.power.pkg2;


public class ImplementPower2 {
  public static int pow(int a, int b)
    {
        float logx = 0;
        for (int i = 0; i < b; i++) {
            logx += Math.log(a);
        }
        return (int)Math.exp(logx);
    }
 
    public static void main(String[] args)
    {
        System.out.print(pow(2, 10));
    }
}
