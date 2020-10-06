
package pkg6.swap.two.numbers.pkg4;
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

public class SwapTwoNumbers4 {


public static void swap(num x, num y)
{
    // return if both variables data is same as we can't check for 
    // address of a reference
    if (x!=y) {
    x.val = x.val - y.val;    // Note - overflow might happen
    y.val= y.val + x.val;
    x.val = y.val - x.val;
    }
   
}
    public static void main(String[] args) {
       num n1=new num(3);
        num n2=new num(4);
        
        swap(n1, n2);
        System.out.println("x: "+n1+" y: "+n2.val);
    }
    
}
