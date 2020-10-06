/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6.swap.two.numbers.pkg2;

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
public class SwapTwoNumbers2 {
// swap by using References in C++
public static void swap(num x, num y)
{
    // return if both variables data is same as we can't check for 
    // address of a reference
    if (x!=null && x!=y) {
    x.val = x.val * y.val;    // Note - overflow might happen
    y.val= x.val / y.val;
    x.val = x.val / y.val;
    }
   
}
    public static void main(String[] args) {
       num n1=new num(3);
        num n2=new num(4);
        
        swap(n1, n2);
        System.out.println("x: "+n1+" y: "+n2.val);
    }
    
}
