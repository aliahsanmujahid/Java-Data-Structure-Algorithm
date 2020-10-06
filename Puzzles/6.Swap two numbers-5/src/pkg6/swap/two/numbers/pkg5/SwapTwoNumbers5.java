
package pkg6.swap.two.numbers.pkg5;
class num{
    int val;
    num(int n){
        this.val=n;
    }
    public String toString() 
    { 
        return  val+ " "; 
    }
}
public class SwapTwoNumbers5 {


public static void swap(num x, num y)
{

    // x = x ^ y ^ (y = x);
   // x = x + y - (y = x);
    x.val = (x.val * y.val) / (y.val = x.val);
   
}
    public static void main(String[] args) {
       num n1=new num(3);
        num n2=new num(4);
        
        swap(n1, n2);
        System.out.println("x: "+n1+" y: "+n2.val);
    }
    
}
